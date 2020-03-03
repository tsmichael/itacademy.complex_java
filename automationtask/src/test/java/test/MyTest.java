package test;

import org.testng.annotations.Test;
import pages.HomePage;

public class MyTest extends BaseTest {

    @Test
    public void testMyTest(){

        HomePage testEx = new HomePage(driver);

        testEx.useHeaderItems()
                .changeLanguage()
                .useHomePageItems()
                .openGameZonePage()
                .openGamePage()
                .filterSettings()
                .fillRangeOfPrice("1280","2800")
                .confirmFilterSearch()
                .sortOrderByPopularity()
                .find_and_purchaseGame("Гра Metro")
                .deleteItem()
                .backToGamePage()
                .useHeaderItems()
                .

        ;

    }
}
