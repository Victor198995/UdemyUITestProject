import UdemyPagesDescription.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class UdemyLoginPageTest {

    private WebDriver driver;

    private UdemyMainPage mainPage;

    private UdemyLoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new UdemyMainPage(driver);
        loginPage = mainPage.loginClick();
    }


    @Test(description = "Link to Password Recovery Validation")
    public void forgotPasswordLinkClick() {

        UdemyForgotPasswordPage forgotPasswordPage = loginPage.forgotPasswordLinkClick();
        Assert.assertEquals(forgotPasswordPage.gettingUrl(), "https://www.udemy.com/user/forgot-password/?locale=en_US&next=https%3A%2F%2Fwww.udemy.com%2F&response_type=html");
        Assert.assertEquals(forgotPasswordPage.getHeaderText(),"Forgot Password");
    }

    @Test(description = "Sign In by Apple ID Validation")
    public void appleLogin(){
       AppleLoginPage appleLoginPage = loginPage.appleLoginLinkClick();
       Assert.assertEquals(appleLoginPage.gettingTitle(),"Sign in with Apple ID");
    }

   @Test(description = "Sign In by Facebook Validation")
    public void facebookLogin(){
        FacebookLoginPage facebookLoginPage = loginPage.facebookLoginLinkClick();
        Assert.assertEquals(facebookLoginPage.gettingTitle(),"Увійти у Facebook | Facebook");

    }



    @AfterMethod
    public void shutDown(){
        driver.quit();
    }
}
