package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    void waitVisibilityClicability(By elementBy){}

    void waitVisibilityClicability(WebElement elementWeb){
        wait.until(
                ExpectedConditions.elementToBeClickable(elementWeb));

    }

    //void waitwait (WebElement elementWeb){ driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);}

    void waitVisibility(By elementBy) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //Click Method
    void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    String getText(By elementBy){
       return driver.findElement(elementBy).getText();
    }

    void click(WebElement elementWeb){
        waitVisibilityClicability(elementWeb);
        Actions actions = new Actions(driver);
        actions.click(elementWeb).build().perform();
        //elementWeb.click();
    }

    //Write text
    void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    void sendHotKeyCtrlA(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(Keys.chord(Keys.CONTROL,"a"));
    }
}
