import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {

    public static ArrayList<Product> productList = ObjectsOfCollection.getObjectsForCollection();
    // for console input
    public InputStreamReader stream_Reader = new InputStreamReader(System.in);
    public BufferedReader keyboard = new BufferedReader(stream_Reader);


    // value for switch menu
    int console_choise;
    int iterator;

    // waiting some action for not so fast menu displaying
    String space_waiter;

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
            // checking the right number of command
            console_choise = MyExceptionHandling.handlingOFIncorrectExitFromMenu();
            switch (console_choise) {
                case 1:
                    u_Menu(); // output UI for creation new objects of Product and FoodProduct
                    break;
                case 2:
                    System.out.println("\n----------------------ListOfProducts-----------------------------");
                    iterator = 1;
                    for (Product object_p : productList) {
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    // waiting some action for not so fast menu displaying
                    space_waiter = keyboard.readLine();

                    break;
                case 3:
                    System.out.println("\n--------------------SortedBy_Brand----------------------------------");
                    Collections.sort(productList, Product.BrandComparator);
                    iterator = 1;
                    for (Product object_p : productList) {
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    // waiting some action for not so fast menu displaying
                    space_waiter = keyboard.readLine();

                    break;
                case 4:
                    System.out.println("\n--------------------SortedBy_Model----------------------------------");
                    Collections.sort(productList, Product.ModelComparator);
                    iterator = 1;
                    for (Product object_p : productList) {
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    // waiting some action for not so fast menu displaying
                    space_waiter = keyboard.readLine();

                    break;
                case 5:
                    // Output list of foodProducts which expired
                    System.out.println("\n---------------Expired FoodProducts------------------------------------");
                    ArrayList<Product> expiredList = Expired.findExpiredFoodProducts(productList);
                    iterator = 1;
                    for (Product object_p : expiredList) {
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    // waiting some action for not so fast menu displaying
                    space_waiter = keyboard.readLine();

                    break;
                case 6:
                    // Save to file
                    FileIn.inputToFile(productList);
                    System.out.println("\n < Information was entered to the file >");
                    break;
                case 7:
                    System.out.println("\n-------------Serialization/Deserialization in ACTION------------------");
                    // Serialize to XML file
                    Serialization.serializeToXML(productList);

                    // Deserialize from XML file
                    ArrayList<Product> deserializedList = Serialization.deserializeFromXML();

                    iterator = 1;
                    System.out.println("Deserialized List of Products");
                    for (Product object_p : deserializedList) {
                        System.out.println(iterator + "." + object_p);
                        iterator++;
                    }
                    // waiting some action for not so fast menu displaying
                    space_waiter = keyboard.readLine();

                    break;
                case 481:
                    break;
                default:
                    flag = !flag;
                    break;
            }
        }
    }

    public void u_Menu() throws IOException {
        System.out.println("    1)Create < Product > object");
        System.out.println("    2)Create < FoodProduct > object");
        System.out.println("    //)Back to the ' Main Menu '");

        console_choise = Integer.parseInt(keyboard.readLine());
        switch (console_choise) {
            case 1:
                // Create new object of Product class
                Product product = new Product();
                product.input();
                productList.add(product);
                break;
            case 2:
                // Create new object of FoodProduct class
                Product foodProduct = new FoodProduct();
                foodProduct.input();
                productList.add(foodProduct);
                break;
            default:
                break;
        }
    }
}
