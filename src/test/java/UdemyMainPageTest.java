import UdemyPagesDescription.UdemyMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UdemyMainPageTest {

    private WebDriver driver;

    private UdemyMainPage mainPage;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new UdemyMainPage(driver);
    }


    @Test(description = "Page URL Validation")
    public void urlValidation() {
        Assert.assertEquals(mainPage.gettingUrl(), "https://www.udemy.com/");
    }

    @Test(description = "Page Title Validation")
    public void titleValidation() {
        Assert.assertEquals(mainPage.gettingTitle(), "Online Courses - Learn Anything, On Your Schedule | Udemy");
    }

    @AfterTest
    public void shutDown(){
        driver.quit();
    }
}
