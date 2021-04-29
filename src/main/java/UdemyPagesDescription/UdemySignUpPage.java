package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UdemySignUpPage extends BaseUdemy {

    private WebDriver driver;

    public UdemySignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //elements locators
    private By element1 = By.xpath("//input[@name='q']");

    //methods
    public UdemyLoginPage method(){
        return new UdemyLoginPage(driver);
    }


    private By header = By.xpath("//div[@id=\"auth-to-udemy-title\"]");

    private By loginLink = By.xpath("//a[@class=\"sign-link\"]");



    //Sign Up and Start Learning!
    public String getHeadingText(){

        return driver.findElement(header).getText();
    }

    public UdemyLoginPage loginLinkClick(){
        driver.findElement(loginLink).click();
        return new UdemyLoginPage(driver);
    }

}
