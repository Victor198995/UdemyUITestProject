package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UdemyLoginPage extends BaseUdemy {

    private WebDriver driver;

    public UdemyLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By header = By.xpath("//div[@id=\"auth-to-udemy-title\"]");

    private By forgotPasswordLink = By.xpath("//a[@class=\"forgot-password-link\"]");

    private By appleLoginLink  = By.xpath("//a[@class=\"fxac social-buttons--social-btn--1JTo2 apple-auth--social-btn--apple--3Zv96\"]");

    private By facebookLoginLink = By.xpath("//a[@class=\"fxac social-buttons--social-btn--1JTo2 facebook-auth--social-btn--facebook--3SDC_\"]");

//Log In to Your Udemy Account!
    public String getHeadingText(){
        return driver.findElement(header).getText();
    }

    public UdemyForgotPasswordPage forgotPasswordLinkClick(){
        driver.findElement(forgotPasswordLink).click();
        return new UdemyForgotPasswordPage(driver);
    }


    public AppleLoginPage appleLoginLinkClick(){
        driver.findElement(appleLoginLink).click();
        return new AppleLoginPage(driver);
    }

    public FacebookLoginPage facebookLoginLinkClick(){
        driver.findElement(facebookLoginLink).click();
        return new FacebookLoginPage(driver);
    }


}
