import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareAgeInYears {

    @Test
    public void test_getAge(){

        Product example1 = new Product("Apple.inc", "iPhone X", "10/07/2005");

        int age_tested = example1.getAge();

        Assert.assertEquals(age_tested, 15);
    }
}
