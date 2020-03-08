package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {

    //By trashBoxIcon = By.cssSelector("cart-item__remove > svg");
    //By close_cross = By.cssSelector(".modal__close");
//  By label_returnDeletedItem = By.xpath("//span[@class='cart-empty__recovery-link']");
//
    ////    WebElement trashBin = driver.findElement(By.xpath("//div/*[name()='svg']/*[name()='use' and @*='#remove']/.."));

    //WebElement llabel_returnDeletedItem = driver.findElement(By.xpath("//span[@class='cart-empty__recovery-link']"));


    public BasketPage(WebDriver driver) {
        super(driver);
    }



    public BasketPage deleteItem() throws InterruptedException {


        WebElement trashBin = driver.findElement(By.xpath("//div/*[name()='svg']/*[name()='use' and @*='#remove']/.."));

        //Thread.sleep(3000);
        //Actions actions = new Actions(driver);

        System.out.println("find?");
        //builder.click(trashBin).;

//        wait.until(
//                ExpectedConditions.elementToBeClickable(trashBin));
        System.out.println(trashBin.isDisplayed());
        System.out.println(trashBin.isEnabled());
        System.out.println(trashBin.isSelected());


        System.out.println("click?");

        //Thread.sleep(3000);
        System.out.println(trashBin.isDisplayed());
        System.out.println(trashBin.isEnabled());
        System.out.println(trashBin.isSelected());
        //actions.click(trashBin).build().perform();
        click(trashBin);
        System.out.println("clicked");

        //Thread.sleep(3000);
        //return new BasketPage(driver);
        return new BasketPage(driver);
    }

    //closes BasketPage / BasketWindow
    public GamesPage backToGamePage(){
        WebElement close_cross = driver.findElement(By.xpath("//div[@class='modal__container']/*[name()='svg']/*[name()='use']/.."));

        System.out.println("close?");
        click(close_cross);
        System.out.println("close");
        return new GamesPage(driver);
    }

    public BasketPage returnDeletedItemToBasket(){
        System.out.println("Want to delete");

        WebElement llabel_returnDeletedItem = driver.findElement(By.xpath("//span[@class='cart-empty__recovery-link']"));
        click(llabel_returnDeletedItem);
        System.out.println("returned!");
        return new BasketPage(driver);
    }

    public String getActualResult(){

        By actualTitleOfGame =By.xpath("//a[contains(text(),'Гра Metro') and @class='link product-link color-blue']");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(actualTitleOfGame));

//        WebElement actualTitleOfGame = driver.findElement(By.xpath("//div[@class='cart-item__title']/a[contains(text(),'Игра Metro')]"));
//        waitVisibilityClicability(actualTitleOfGame);
        System.out.println(getText(actualTitleOfGame));
        //return new BasketPage(driver);
        return getText(actualTitleOfGame);
    }

    }
