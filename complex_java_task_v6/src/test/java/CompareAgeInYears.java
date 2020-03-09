import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareAgeInYears {

    @Test
    public void test_getAge_positive(){


        Product example_p = new Product("Apple.inc", "iPhone X", "10/02/2005");

        int age_tested = example_p.getAge();

        Assert.assertEquals(age_tested, 15);
    }

//    @Test
//    public void test_getAge_negative(){
//
//        Product example_n = new Product("Apple.inc", "iPhone X", "10/07/2005");
//
//
//        int age_tested = example_n.getAge();
//
//        Assert.assertEquals(age_tested, 15);
//    }
}
