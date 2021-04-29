import UdemyPagesDescription.ShoppingCartPage;
import UdemyPagesDescription.UdemyMainPage;
import UdemyPagesDescription.UdemySearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class UdemyShoppingCartTest {

    private WebDriver driver;

    private UdemyMainPage mainPage;

  private UdemySearchResultsPage searchResultsPage;

    String query = "test";


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://udemy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new UdemyMainPage(driver);
        searchResultsPage = mainPage.searchInSearchfieldByClick(query);

    }


    @Test(description = "Validation ability of course choosing and moving it to shopping cart")
    public void addingCourseToCart(){
        ShoppingCartPage shoppingCart = searchResultsPage.addingCourseToCart();
        Assert.assertEquals(shoppingCart.gettingUrl(),"https://www.udemy.com/cart/");
        Assert.assertEquals(shoppingCart.gettingTitle(),"Online Courses - Anytime, Anywhere | Udemy");
        Assert.assertEquals(shoppingCart.getHeadingText(),"Shopping Cart");
        Assert.assertEquals(shoppingCart.getCourseText(),"Rest API Testing (Automation) from Scratch -RestAssured Java");
    }

    @AfterTest
    public void closingWindows() {
        driver.quit();
    }
}
