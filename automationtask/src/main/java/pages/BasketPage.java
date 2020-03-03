package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    By trashBoxIcon = By.cssSelector("div > div.cart-item__remove");
    By close_cross = By.cssSelector(".modal__close");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage deleteItem(){
        click(trashBoxIcon);

        return this;
    }

    public GamesPage backToGamePage(){
        click(close_cross);
        return new GamesPage(driver);
    }



}
