import java.util.ArrayList;

public class Expired {

    public static void findExpiredFoodProducts(ArrayList<Product> productList){
        System.out.println("Expired FoodProducts  => ");

        for (Product object : productList) {
            if(object instanceof FoodProduct){
                if(((FoodProduct) object).outExpiredProducts()<0){ // output FoodProducts which expired
                    System.out.println(object);
                }
            }
        }
    }
}
