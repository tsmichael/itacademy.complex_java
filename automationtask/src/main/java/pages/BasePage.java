package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    void waitVisibility(By elementBy) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //Click Method
    void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
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
