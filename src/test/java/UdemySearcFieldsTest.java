import UdemyPagesDescription.UdemyMainPage;
import UdemyPagesDescription.UdemySearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UdemySearcFieldsTest {

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

    @Test(description = "Validation ability to search by click after entering text in main Searchfield")
    public void mainSearchFieldValidationByClick() {
        String query = "test";
        UdemySearchResultsPage searchResultsPage = mainPage.searchInSearchfieldByClick(query);
        Assert.assertEquals(searchResultsPage.getHeadingTest(), "10,000 results for “" + query + "”");
    }

    @Test(description = "Validation ability to search by pressing Enter button after entering text in main Searchfield")
    public void mainSearchFieldValidationByKey() {
        String query = "test";
        UdemySearchResultsPage searchResultsPage = mainPage.searchInSearchfieldByClick(query);
        Assert.assertEquals(searchResultsPage.getHeadingTest(), "10,000 results for “" + query + "”");
    }

    @Test(description = "Validation ability to search by pressing Enter button after entering text")
    public void secondarySearchFieldValidationByKey() {
        String query = "test";
        UdemySearchResultsPage searchResultsPage = mainPage.searchInSearchFieldSmallByKey(query);
        Assert.assertEquals(searchResultsPage.getHeadingTest(), "10,000 results for “" + query + "”");
    }

    @Test(description = "Validation ability to search by click after entering text")
    public void secondarySearchFieldValidationByClick() {
        String query = "test";
        UdemySearchResultsPage searchResultsPage = mainPage.searchInSearchFieldSmallByKey(query);
        Assert.assertEquals(searchResultsPage.getHeadingTest(), "10,000 results for “" + query + "”");
    }


    @AfterMethod
    public void closingWindows() {
        driver.quit();
    }

}
