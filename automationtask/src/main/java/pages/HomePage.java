package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //catalog - menu
    By catalog = By.cssSelector("div.menuupd-trigger");
    //element of catalog
    By game_zone = By.xpath("//a/span[contains(text(),'Гральна зона')]");


    public Header useHeaderItems(){

        return new Header(driver);
    }

    public GameZonePage openGameZonePage() {
        click(catalog);
        click(game_zone);

        return new GameZonePage(driver);
    }

    public HomePage(WebDriver driver){
        super(driver);
    }
}
