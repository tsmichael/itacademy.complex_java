package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {

    WebDriver driver;

    @BeforeClass
    public void openURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.moyo.ua/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @Test
    public void testSomeFunctionality() throws InterruptedException {
        //language switch
        WebElement languageList = driver.findElement(
                By.xpath("//div[contains(@class,'header__lang-switch-wrap')]/a[contains(@data-value,'ru')]"));
        languageList.click();
        // [ua] button
        WebElement ua_active = driver.findElement(
                By.xpath("//div[contains(@class,'header__lang-switch-wrap')]/a[contains(@data-value,'ua')]"));
        ua_active.click();

        WebElement catalog = driver.findElement(By.cssSelector("div.menuupd-trigger"));
        catalog.click();

        WebElement game_zone = driver.findElement(By.xpath("//a/span[contains(text(),'Гральна зона')]"));
        game_zone.click();

        WebElement game_zone_games = driver.findElement(By.xpath("//a[contains(text(),'Ігри')]"));

        game_zone_games.click();
        System.out.println("1");
        Thread.sleep(2000);
        //WebElement rebate_checkbox = driver.findElement(By.cssSelector("li input#filter-useful-rebate"));
        //WebElement rebate_checkbox = driver.findElement(By.xpath("//span/strong[contains(text(),'Знижки')]"));
        //WebElement rebate_checkbox = driver.findElement(By.id("filter-useful-rebate"));
        //WebElement leftMenu_filters = driver.findElement(By.xpath("//form/div[contains(@class,'filter-group-title')]"));
        //rebate_checkbox.click();
        WebElement rebate_checkbox = driver.findElement(By.xpath("//ul/li/label[@class='filter-label-useful-rebate']"));
        rebate_checkbox.click();
        System.out.println("2");
        //leftMenu_filters.click();
        WebElement ps_checkbox = driver.findElement(By.cssSelector("label.filter-label-4377-525383"));
        ps_checkbox.click();
        WebElement min_inputField =driver.findElement(By.xpath("//div[@class='filter-range']/input[@name='min']"));

        min_inputField.click();
        min_inputField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        min_inputField.sendKeys("1280");

        WebElement max_inputField =driver.findElement(By.xpath("//div[@class='filter-range']/input[@name='max']"));

        max_inputField.click();
        max_inputField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        max_inputField.sendKeys("2280");

        WebElement btn_show =driver.findElement(By.xpath("//button[contains(text(),'показати')]"));
        System.out.println("3");
        //btn_show.wait(10);
        btn_show.click();
        System.out.println("4");

        //List<WebElement> a = driver.findElements(By.xpath("//div/section[contains(@class,'product-tile_product productContainer ')]"));
        //int aa= a.size();

//        WebElement sortList =driver.findElement(By.id("catalog-sort"));
//                //driver.findElement(By.xpath("//select[@name='sort']"));
//        sortList.click();

//        WebElement sortByPopularity = driver.findElement(By.xpath("//select[@name='sort']/option[@value='weeklyrate-desc']"));
//        sortByPopularity.click();
        Thread.sleep(3000);
        WebElement btn_Purchase = driver.findElement((By.xpath("//a[contains(text(),'Гра Metro')]/../../" +
                "button[@class='product-tile_button product-tile_button--buy button_buy_product tc-anim js-add-to-cart gtm-buy-product']")));

        btn_Purchase.click();

        WebElement trashBin = driver.findElement(By.xpath("//div/*[name()='svg']/*[name()='use' and @*='#remove']/.."));
        System.out.println('5');
//        trashBin.click();***
        Thread.sleep(3000);
        Actions actions = new Actions(driver);

        actions.click(trashBin).build().perform();
        Thread.sleep(3000);
        System.out.println('6');
        WebElement llabel_returnDeletedItem = driver.findElement(By.xpath("//span[@class='cart-empty__recovery-link']"));
        System.out.println('7');
        Actions actions2 = new Actions(driver);
        actions2.click(llabel_returnDeletedItem).build().perform();
        System.out.println('8');

        WebElement close_cross = driver.findElement(By.xpath("//div[@class='modal__container']/*[name()='svg']/*[name()='use']/.."));
        actions.click(close_cross).build().perform();
    }


}
