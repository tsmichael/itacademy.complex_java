package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //catalog - menu
    By catalog = By.cssSelector("div.menuupd-trigger");
    //element of catalog
    By game_zone = By.xpath("//a/span[contains(text(),'Гральна зона')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Access for using Header panel
    public Header useHeaderItems() {
        System.out.println("Now you can use elements of Header");
        return new Header(driver);
    }

    // Go to GameZone Page
    public GameZonePage openGameZonePage() {
        click(catalog);
        click(game_zone);
        System.out.println("From HomePage -> to GameZonePage");
        return new GameZonePage(driver);
    }

}
