package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends BasePage {


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    // Deleting element from Basket
    public BasketPage deleteItem() {

        // Rubbish Bin icon
        WebElement trashBin = driver.findElement(By.xpath("//div/*[name()='svg']/*[name()='use' and @*='#remove']/.."));
        click(trashBin);
        System.out.println("Item is removed from basket");

        return new BasketPage(driver);
    }

    // Closes BasketPage / BasketWindow
    public GamesPage backToGamePage() {
        // cross-icon in the upper right corner
        WebElement close_cross = driver.findElement(By.xpath("//div[@class='modal__container']/*[name()='svg']/*[name()='use']/.."));

        click(close_cross);
        System.out.println("Basket is closed");
        return new GamesPage(driver);
    }

    // For returning recently deleted items
    public BasketPage returnDeletedItemToBasket() {

        WebElement linkText_returnDeletedItem = driver.findElement(By.xpath("//span[@class='cart-empty__recovery-link']"));
        click(linkText_returnDeletedItem);
        System.out.println("Removed item is returned");
        return new BasketPage(driver);
    }

    // Get name of Returned Item
    public String getActualResult() {

        By actualTitleOfGame = By.xpath("//a[contains(text(),'Гра Metro') and @class='link product-link color-blue']");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(actualTitleOfGame));

        return getText(actualTitleOfGame);
    }

}
