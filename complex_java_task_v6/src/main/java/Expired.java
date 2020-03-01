import java.util.ArrayList;

public class Expired {

    public static ArrayList<Product> findExpiredFoodProducts(ArrayList<Product> productList){
        System.out.println("Expired FoodProducts  => ");

        ArrayList<Product> returnedList = new ArrayList<>();

        for (Product object : productList) {
            if(object instanceof FoodProduct){
                if(((FoodProduct) object).outExpiredProducts()<0){ // output FoodProducts which expired
                    returnedList.add(object);
                }
            }
        }

        return returnedList;
    }
}
 // MEthods of BO non console - JUST RETURN

//RETURN