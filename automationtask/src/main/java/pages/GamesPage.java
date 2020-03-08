package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.WeakHashMap;

public class GamesPage extends BasePage {

    // elements on the left side bar
    By checkbox_rebate = By.xpath("//ul/li/label[@class='filter-label-useful-rebate']");
    By checkbox_playStation = By.cssSelector("label.filter-label-4377-525383");

    // range field of price
    By min_inputField =By.xpath("//div[@class='filter-range']/input[@name='min']");
    By max_inputField =By.xpath("//div[@class='filter-range']/input[@name='max']");

    // button for filtering -> show result of filter`s search
    By btn_show =By.xpath("//button[contains(text(),'показати')]");

    // dropdown for sorting store products[games]
    By dropdown_sortList = By.id("catalog-sort");

    // element of sorting_dropdown
    By sortByPopularity = By.xpath("//select[@name='sort']/option[@value='weeklyrate-desc']");



    public GamesPage(WebDriver driver){super(driver);}

    //put 'check' to rebate && playStation filters
    public GamesPage filterSettings(){
        click(checkbox_rebate);
        click(checkbox_playStation);

        return this;
    }

    public GamesPage fillRangeOfPrice(String minimun, String maximun){
        // fill minimum value
        click(min_inputField);
        sendHotKeyCtrlA(min_inputField);
        writeText(min_inputField, minimun);
        // fill maximum value
        click(max_inputField);
        sendHotKeyCtrlA(max_inputField);
        writeText(max_inputField, maximun);

        return this;
    }


    public GamesPage confirmFilterSearch(){
        click(btn_show);

        return this;
    }

    public GamesPage sortOrderByPopularity(){
        click(dropdown_sortList);
        click(sortByPopularity);

        return this;
    }

    public By getProduct(String nameProduct){

        By btn_purchase = By.xpath("//a[contains(text(), '"+nameProduct+"')]/../../" +
                "button[@class='product-tile_button product-tile_button--buy button_buy_product tc-anim js-add-to-cart gtm-buy-product']");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(btn_purchase));

        return btn_purchase;

//
    }


    public BasketPage find_and_purchaseGame(String nameProduct){
        // button for purchasing product
        //By btn_Purchase = (By.xpath("//a[contains(text(), '"+ nameProduct + "')]/../../" +
          //      "button[@class='product-tile_button product-tile_button--buy button_buy_product tc-anim js-add-to-cart gtm-buy-product']"));
//        By btn_Purchase = ((By.xpath("//a[contains(text(),'Гра Metro')]/../../" +
//                "button[@class='product-tile_button product-tile_button--buy button_buy_product tc-anim js-add-to-cart gtm-buy-product']")));

        click(getProduct(nameProduct));

        return new BasketPage(driver);
    }

    public Header useHeaderItems(){
        return new Header(driver);
    }


}
