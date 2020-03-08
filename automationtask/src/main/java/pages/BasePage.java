package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }


    // Waiter for WebElements
    void waitToBeClicked(WebElement elementWeb) {
        wait.until(
                ExpectedConditions.elementToBeClickable(elementWeb));
    }

    // Waiter for By elements
    void waitVisibility(By elementBy) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    // Click Method for By elements
    void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    // Click for WebElement
    void click(WebElement elementWeb) {
        waitToBeClicked(elementWeb);
        Actions actions = new Actions(driver);
        actions.click(elementWeb).build().perform();
    }

    // getText from the element
    String getText(By elementBy) {
        return driver.findElement(elementBy).getText();
    }


    // Write text ->  data entry in the field
    void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    // Using Ctrl+A hot key combination
    void sendHotKeyCtrlA(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }
}
