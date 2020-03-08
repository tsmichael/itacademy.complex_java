package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;

public class CDLXXXI_VerifyTheFunctionalityOfReturningRemovedItemsFromTheBasket extends BaseTest {

    @Test
    public void test_CDLXXXI_verifyTheFunctionalityOfReturningRemovedItemsFromTheBasket(){

        HomePage testEx = new HomePage(driver);

        testEx.useHeaderItems()
                .changeLanguageToUkrainian()
                .useHomePageItems()
                .openGameZonePage()
                .openGamePage()
                .filterSettings()
                .fillRangeOfPrice("1280","2800")
                .confirmFilterSearch()
                .clickPurchaseGame("Гра Metro")
                .deleteItem()
                .backToGamePage()
                .useHeaderItems()
                .openBasketPage()
                .returnDeletedItemToBasket()
                .getActualResult();

        BasketPage compareObject = new BasketPage(driver);

        Assert.assertEquals(compareObject.getActualResult(),"Гра Metro Exodus Видання першого дня (PS4, Російська версія)");
    }
}
