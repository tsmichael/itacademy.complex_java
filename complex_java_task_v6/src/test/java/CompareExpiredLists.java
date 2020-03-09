import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CompareExpiredLists {

    @Test
    public void compareExpiredFoodProducts(){
        Product example1 = new FoodProduct("ChinaFood","FriedDogChicks","10/02/2020","FastFood",7);
        Product example2 = new FoodProduct("Yamaika.Transition", "yellow-yellow", "12/12/2019", "ice-banana",90);
        Product example3 = new FoodProduct("Korea", "spice", "05/10/2018", "hot cake", 25);
        Product example4 = new FoodProduct("NashaRyaba", "chicken legs", "01/02/2020", "raw food", 100);

        ArrayList<Product> listForTest = new ArrayList<>();

        listForTest.add(example1);
        listForTest.add(example2);
        listForTest.add(example3);
        listForTest.add(example4);

        ArrayList<Product> expectedList = new ArrayList<>();

        expectedList.add(example1);
        //expectedList.add(example2);
        expectedList.add(example3);

        ArrayList<Product> actualList = Expired.findExpiredFoodProducts(listForTest);

        Assert.assertEquals(actualList,expectedList);
    }


}
