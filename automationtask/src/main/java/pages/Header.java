package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    //language switcher [as a default is RU]
    By languageSwitcher = By.xpath("//div[contains(@class,'header__lang-switch-wrap')]" +
            "/a[contains(@data-value,'ru')]");
    //button which will switch language to UA
    By ua_active = By.xpath("//div[contains(@class,'header__lang-switch-wrap')]" +
            "/a[contains(@data-value,'ua')]");
    //basket icon
    By basket_icon = By.id("cart-button");

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header changeLanguageToUkrainian() {
        click(languageSwitcher);
        click(ua_active);
        System.out.println("Language is changed to Ukrainian ");
        return this;
    }

    // Access for using Home Page items
    public HomePage useHomePageItems() {
        System.out.println("Now you can use elements of HomePage");
        return new HomePage(driver);
    }

    // Open Basket Page
    public BasketPage openBasketPage() {
        click(basket_icon);
        System.out.println("Basket is opened");
        return new BasketPage(driver);
    }

}
