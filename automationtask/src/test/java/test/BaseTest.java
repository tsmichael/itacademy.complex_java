package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void openURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.moyo.ua/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
