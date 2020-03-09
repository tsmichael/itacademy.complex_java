package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamesPage extends BasePage {

    // elements on the left side bar
    By checkbox_rebate = By.xpath("//ul/li/label[@class='filter-label-useful-rebate']");
    By checkbox_playStation = By.cssSelector("label.filter-label-4377-525383");

    // range field of price
    By min_inputField = By.xpath("//div[@class='filter-range']/input[@name='min']");
    By max_inputField = By.xpath("//div[@class='filter-range']/input[@name='max']");

    // button for filtering -> show result of filter`s search
    By btn_show = By.xpath("//button[contains(text(),'показати')]");

    public GamesPage(WebDriver driver) {
        super(driver);
    }

    // Put 'check' to rebate && playStation filters
    public GamesPage filterSettings() {
        click(checkbox_rebate);
        click(checkbox_playStation);

        return this;
    }

    // Input some Value to fields (minimum and maximum values of price)
    public GamesPage fillRangeOfPrice(String minimum, String maximum) {
        // fill minimum value
        click(min_inputField);
        sendHotKeyCtrlA(min_inputField);
        writeText(min_inputField, minimum);

        System.out.println("Minimum price is filled ");

        // fill maximum value
        click(max_inputField);
        sendHotKeyCtrlA(max_inputField);
        writeText(max_inputField, maximum);
        System.out.println("Maximum price is filled ");
        return this;
    }

    // Press button for confirm filter search
    public GamesPage confirmFilterSearch() {
        click(btn_show);
        System.out.println("Filters are configured");
        return this;
    }

    // Method for searching element by method with parameter
    public By getProduct(String nameProduct) {

        By btn_purchase = By.xpath("//a[contains(text(), '" + nameProduct + "')]/../../" +
                "button[contains(@class,'product-tile_button')]");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(btn_purchase));

        return btn_purchase;
    }

    // Clicking on button "Купити" / Purchase button
    public BasketPage clickPurchaseGame(String nameProduct) {

        click(getProduct(nameProduct));
        System.out.println("You clicked on 'Purchase' button");
        return new BasketPage(driver);
    }

    // Access for using Header items
    public Header useHeaderItems() {
        System.out.println("Now you can use elements of Header");
        return new Header(driver);
    }
}

