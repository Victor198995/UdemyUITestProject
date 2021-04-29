package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BaseUdemy{

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Shopping Cart
    private By header = By.xpath("//div[1]/section[1]/div[1]/div[1]/div[1]/h1[1]/span[1]");
    //Shopping Cart

    private By courseInCart = By.xpath("//div[1]/div[1]/div[1]/ul[1]/div[1]/li[1]/div[1]/div[2]/a[1]/div[1]");
    //Rest API Testing (Automation) from Scratch -RestAssured Java


    public String getHeadingText(){
        return driver.findElement(header).getText();
    }

    public String getCourseText(){
        return driver.findElement(courseInCart).getText();
    }

}

//h1[@data-purpose="shopping-cart-title"]/span//div[contains(text(),'Rest API Testing (Automation) from Scratch -RestAs')]