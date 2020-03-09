import java.io.IOException;
import java.util.ArrayList;

public class ClassTestClassMAin extends FoodProduct{

    public static void main(String args[]) throws IOException {

        Product fproduct1 =new FoodProduct
                ("Dolche", "Elite", "05/12/1999","Yogurt",27);
        Product fproduct2 =new FoodProduct
                ("Yamaika.Transition", "long_yellow", "27/01/2019","banana",30);
        Product fproduct3 =new FoodProduct
                ("Green word", "Home", "05/09/1999","Garlic",60);
        ArrayList<Product> returnedList = new ArrayList<>();
        returnedList.add(fproduct1);
        returnedList.add(fproduct2);
        for (Product object : returnedList) {
            if(object instanceof FoodProduct){
                ((FoodProduct) object).getExpiredDateValue();
                System.out.println(((FoodProduct) object).outExpiredDate());
            }
        }





    }
}
