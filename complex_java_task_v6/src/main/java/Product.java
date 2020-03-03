import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Product {
    //current time in the world
    LocalDate currentTime = LocalDate.now();
    // for inputting from console
    InputStreamReader stream_Reader = new InputStreamReader(System.in) ;
    BufferedReader keyboard = new BufferedReader(stream_Reader);


    private String Brand;
    private String Model;
    //public LocalDate ProductionDate = LocalDate.of(1,1,1);
    private String ProductionDate;

    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public Product(){}

    public Product(String brand, String model, String productionDate) {
        this.Brand = brand;
        this.Model = model;
        //this.ProductionDate = LocalDate.parse(stringDate,df);
        this.ProductionDate = productionDate;
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

    public void setProductionDate(String productionDate) {
        ProductionDate = productionDate;
    }

    public String getProductionDate() {
        return ProductionDate;
    }

    public void input() throws IOException {

        System.out.println("Input name of Brand ");
        this.Brand = keyboard.readLine();

        System.out.println("Input name of Model ");
        this.Model = keyboard.readLine();

        System.out.println("Input Date of creationProduct 'year-month-day' ");
        String productionDate = keyboard.readLine();

        //this.ProductionDate = LocalDate.parse(stringDate,df);
        ProductionDate = productionDate;
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
        info += "\nThis product is " + getAge() + " year(s) old\n";
        return info;
    }

    public int getAge() {
        LocalDate dateOfCreation = LocalDate.parse(ProductionDate,df);
        int diff = currentTime.getYear() - dateOfCreation.getYear();
        return diff;
    }


    public static Comparator<Product> ModelComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String ModelName1 = p1.getModel().toUpperCase();
            String ModelName2 = p2.getModel().toUpperCase();

            return ModelName1.compareTo(ModelName2);
        }
    };

    public static Comparator<Product> BrandComparator = new Comparator<Product>() {

        public int compare(Product p1, Product p2) {
            String BrandName1 = p1.getBrand().toUpperCase();
            String BrandName2 = p2.getBrand().toUpperCase();

            return BrandName1.compareTo(BrandName2);
        }
    };
}
