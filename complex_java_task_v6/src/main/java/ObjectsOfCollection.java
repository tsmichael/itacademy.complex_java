import java.util.ArrayList;

public class ObjectsOfCollection {

    // class-method where i have hardcoded data for objects of classes
    public static ArrayList<Product> getObjectsForCollection(){
        ArrayList<Product> example =new ArrayList<>();

        Product product1 =new Product("Apple","iMac","19/05/2005");
        Product product2 =new Product("Ford","Sedan","01/09/1998");
        Product product3 =new Product("Acer","Aspire","03/02/2003");
        Product product4 =new Product("AWC","BlackBerry","11/11/2011");

        Product fproduct1 =new FoodProduct("Dolche", "Elite", "26/09/2016","Yogurt",14);
        Product fproduct2 =new FoodProduct("Yamaika.Transition", "long_yellow", "27/01/2019","banana",30);
        Product fproduct3 =new FoodProduct("Green word", "Home", "05/09/1999","Garlic",60);

        example.add(product1);
        example.add(product2);
        example.add(product3);
        example.add(product4);
        example.add(fproduct1);
        example.add(fproduct2);
        example.add(fproduct3);

        return example;


    }
}
