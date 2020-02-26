import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Comparator;

public class Product {
    //current time in the world
    LocalDate currentTime = LocalDate.now();
    // for inputting from console
    InputStreamReader stream_Reader = new InputStreamReader(System.in) ;
    BufferedReader keyboard = new BufferedReader(stream_Reader);


    private String Brand;
    private String Model;
    private LocalDate ProductionDate = LocalDate.now();

    public Product(){}

    public Product(String brand, String model, String stringDate) {
        Brand = brand;
        Model = model;
        ProductionDate = LocalDate.parse(stringDate);
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getModel() {
        return Model;
    }

    public void setProductionDate(String stringDate) {
        ProductionDate = LocalDate.parse(stringDate);
    }

    public LocalDate getProductionDate() {
        return ProductionDate;
    }

    public void input() throws IOException {

        System.out.println("Input name of Brand ");
        this.Brand = keyboard.readLine();

        System.out.println("Input name of Model ");
        this.Model = keyboard.readLine();

        System.out.println("Input Date of creationProduct 'year-month-day' ");
        String stringDate =keyboard.readLine();

        this.ProductionDate = LocalDate.parse(stringDate);
    }

    public void output(){
        System.out.println("Product Brand : " + this.Brand);
        System.out.println("Product Model : " + this.Model);
        System.out.println("Production Date : " + this.ProductionDate);
    }

    @Override
    public String toString(){
        String info ="";
        info += "\nBelongs to [ Product ] ";
        info += "\nProduct Brand : " + this.Brand;
        info += "\nProduct Model :" + this.Model;
        info += "\nDate of creation :" + this.ProductionDate;
        info += "\nThis product is " + getAge() + " year(s)";
        return info;
    }

    public int getAge() {

        int diff = currentTime.getYear() - this.ProductionDate.getYear();
        //System.out.println(diff);
        return diff;
    }


    public static Comparator<Product> ModelComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String ModelName1 = p1.getModel().toUpperCase();
            String ModelName2 = p2.getModel().toUpperCase();

            //ascending order
            return ModelName1.compareTo(ModelName2);

            //descending order
            //return ModelName2.compareTo(ModelName1);
        }
    };

    public static Comparator<Product> BrandComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String BrandName1 = p1.getBrand().toUpperCase();
            String BrandName2 = p2.getBrand().toUpperCase();

            //ascending order
            return BrandName1.compareTo(BrandName2);

            //descending order
            //return BrandName2.compareTo(BrandName1);
        }
    };
}
