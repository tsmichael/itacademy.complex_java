package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;

public class MyTest extends BaseTest {

    @Test
    public void testMyTest() throws InterruptedException {

        HomePage testEx = new HomePage(driver);

        testEx.useHeaderItems()
                .changeLanguage()
                .useHomePageItems()
                .openGameZonePage()
                .openGamePage()
                .filterSettings()
                .fillRangeOfPrice("1280","2800")
                .confirmFilterSearch()
                //.sortOrderByPopularity()
                .find_and_purchaseGame("Гра Metro")
                .deleteItem()
                .backToGamePage()
                .useHeaderItems()
                .openBasketPage()
                .returnDeletedItemToBasket()
                .getActualResult();

        BasketPage bpobj = new BasketPage(driver);

        Assert.assertEquals(bpobj.getActualResult(),"Гра Metro Exodus Видання першого дня (PS4, Російська версія)");
    }
}
