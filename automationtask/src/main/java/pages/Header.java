package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {

    //language switcher as a default is RU
    By languageSwitcher = By.xpath("//div[contains(@class,'header__lang-switch-wrap')]" +
            "/a[contains(@data-value,'ru')]");
    //button which will switch language to UA
    By ua_active = By.xpath("//div[contains(@class,'header__lang-switch-wrap')]" +
            "/a[contains(@data-value,'ua')]");
    //basket icon
    By basket_icon =

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header changeLanguage(){
        click(languageSwitcher);
        click(ua_active);
        return this;
    }

    public HomePage useHomePageItems(){

        return new HomePage(driver);
    }

}
