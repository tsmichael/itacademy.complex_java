import java.util.ArrayList;

public class Expired {

    public static ArrayList<Product> findExpiredFoodProducts(ArrayList<Product> productList){


        ArrayList<Product> returnedList = new ArrayList<>();

        for (Product object : productList) {
            if(object instanceof FoodProduct){
                if(((FoodProduct) object).outExpiredProducts()<0){ // output FoodProducts which expired
                    returnedList.add(object);                       // negative value means FoodProduct is expired
                }
            }
        }
        return returnedList;
    }
}
