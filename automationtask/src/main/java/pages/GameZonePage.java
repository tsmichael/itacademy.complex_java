package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GameZonePage extends BasePage {
    //element of game_zone_page consist of big section of games
    By game_zone_games = By.xpath("//a[contains(text(),'Ігри')]");


    public GameZonePage(WebDriver driver){super(driver);}

    public GamesPage openGamePage() throws InterruptedException {
        Thread.sleep(3000);
        click(game_zone_games);
        return new GamesPage(driver);
    }
}
