import UdemyPagesDescription.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UdemyMainPageButtonsValidation {

    private WebDriver driver;

    private UdemyMainPage mainPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://udemy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new UdemyMainPage(driver);

    }

    @Test(description = "Link to SignIn Validation")
    public void signInButtonValidation() {
        UdemyLoginPage signInPage = mainPage.loginClick();
        Assert.assertEquals(signInPage.gettingUrl(), "https://www.udemy.com/join/login-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F");
        Assert.assertEquals(signInPage.getHeadingText(), "Log In to Your Udemy Account!");
        Assert.assertEquals(signInPage.gettingTitle(), "Login | Udemy");
    }

    @Test(description = "Link to SignUp Validation")
    public void signUpButtonValidation() {
        UdemySignUpPage signUpPage = mainPage.signUpClick();
        Assert.assertEquals(signUpPage.gettingUrl(), "https://www.udemy.com/join/signup-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F");
        Assert.assertEquals(signUpPage.getHeadingText(), "Sign Up and Start Learning!");
        Assert.assertEquals(signUpPage.gettingTitle(), "Sign up and start learning | Udemy");
    }

    @Test(description = "Link to Udemy for Business Validation")
    public void udemyForBusinessLinkValidation(){
        UdemyForBusinessPage udemyForBusiness = mainPage.udemyForBusinessLinkClick();
        //other tab switching
        udemyForBusiness.switchingToTab();
        Assert.assertEquals(udemyForBusiness.getHeadingText(),"Get your demo");
        Assert.assertEquals(udemyForBusiness.gettingTitle(),"Request a free demo | Udemy for Business");
    }

    @Test(description = "Link to Becomes a Teacher Validation")
    public void udemyBecomeATeacherLinkValidation(){
        UdemyBecomeTeacherPage udemyBecomeTeacher = mainPage.udemyBecomeTeacherLinkClick();
        Assert.assertEquals(udemyBecomeTeacher.getHeadingText(),"Make a global impact");
        Assert.assertEquals(udemyBecomeTeacher.gettingTitle(),"Teach Online - Share your knowledge with millions of students across the globe and earn money");
    }


    @AfterMethod
    public void closingWindows() {
        driver.quit();
    }
}
