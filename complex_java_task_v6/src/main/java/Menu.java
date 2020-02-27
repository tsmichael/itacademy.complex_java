import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {

    public static ArrayList<Product> productList = ObjectsOfCollection.getObjectsForCollection();

    public InputStreamReader stream_Reader = new InputStreamReader(System.in);
    public BufferedReader keyboard = new BufferedReader(stream_Reader);



    int console_choise;
    int iterator;

    public void o_Menu() throws IOException {

        boolean flag = true;


        while (flag) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("1)Create new Product");
            System.out.println("2)Show your 'product list'");
            System.out.println("3)Sort List by Brand");
            System.out.println("4)Sort List by Model");
            System.out.println("5)List of expired FoodProducts");
            System.out.println("6)Write to file all list of data");
            System.out.println("7)Serialize/Deserialize DATA");
            System.out.println("");
            System.out.println("----------------------------------------------------");

            console_choise = Integer.parseInt(keyboard.readLine());
            switch (console_choise) {
                case 1:
                    u_Menu(); // output UI for creation new objects of Product and FoodProduct
                    break;
                case 2:
                    System.out.println("\n----------------------ListOfProducts-----------------------------");
                    iterator = 0;
                    for(Product object_p : productList){
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    break;
                case 3:
                    System.out.println("\n--------------------SortedByBrand----------------------------------");
                    Collections.sort(productList,Product.BrandComparator);
                    iterator = 0;
                    for(Product object_p : productList){
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    break;
                case 4:
                    System.out.println("\n--------------------SortedByModel----------------------------------");
                    Collections.sort(productList,Product.ModelComparator);
                    iterator = 0;
                    for(Product object_p : productList){
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    break;
                case 5:
                    System.out.println("\n---------------Expired FoodProducts------------------------------------");
                    Expired.findExpiredFoodProducts(productList);
                    break;
                case 6:
                    FileIn.inputToFile(productList);
                    System.out.println("\n < Information was entered to the file >");
                    break;
                case 7:
                    System.out.println("\n-------------Serialization/Deserialization in ACTION------------------");
                    Serialization.serializeToXML(productList);
                    System.out.println(Serialization.deserializeFromXML());
                    break;
                default:
                    flag=!flag;
                    break;
            }
        }
    }

    public void u_Menu() throws IOException {
        System.out.println("    1)Create < Product > object");
        System.out.println("    2)Create < FoodProduct > object");
        System.out.println("    //)Back to the ' Main Menu '");

        console_choise = Integer.parseInt(keyboard.readLine());
        switch (console_choise){
            case 1:
                Product product = new Product();
                product.input();
                productList.add(product);
                break;
            case 2:
                Product foodProduct = new FoodProduct();
                foodProduct.input();
                productList.add(foodProduct);
                break;
            default:
                break;
        }
    }
}
