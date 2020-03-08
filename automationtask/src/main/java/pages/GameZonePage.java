package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GameZonePage extends BasePage {

    By game_zone_games = By.xpath("//img[contains(@alt,'Ігри')]");

    public GameZonePage(WebDriver driver) {
        super(driver);
    }

    //Go to Game Page
    public GamesPage openGamePage() {

        click(game_zone_games);
        System.out.println("Go to from GameZonePage -> to GamesPage");
        return new GamesPage(driver);
    }
}
