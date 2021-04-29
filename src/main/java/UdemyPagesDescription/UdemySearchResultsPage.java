package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UdemySearchResultsPage extends BaseUdemy {

    private WebDriver driver;

    public UdemySearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //10,000 results for “test”
    private By header = By.xpath("//h1[@class=\"udlite-heading-xxl search--header-title--3wfny\"]");

    private By showMoreLink = By.xpath("//form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]/span[1]");

    private By apiTestingCheckBox = By.xpath("//form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/fieldset[1]/label[19]");

    private By course = By.xpath("//div[text()=\"Rest API Testing (Automation) from Scratch -RestAssured Java\"]");//2 elements

    private By addToCartButton = By.xpath("//div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/button[1]");//2 elements

    private By goToCartButton = By.xpath("//span[contains(text(),'Go to cart')]");


    public String getHeadingTest() {
        return driver.findElement(header).getText();
    }

    public UdemySearchResultsPage showMoreLinkClick() {
        driver.findElement(showMoreLink).click();
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage apiTestingCheckBoxClick() {
        driver.findElement(apiTestingCheckBox).click();
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage choosingCourse() {
        driver.findElement(course).click();
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage addToCartClick() {
//explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        driver.findElement(addToCartButton).click();
        return new UdemySearchResultsPage(driver);
    }


    public void goToCartClick() {
        driver.findElement(goToCartButton).click();
    }

    public ShoppingCartPage addingCourseToCart() {
        this.showMoreLinkClick();
        this.scrollingDown(600);
        this.apiTestingCheckBoxClick();
        this.scrollingUp(-600);
        this.choosingCourse();
        this.addToCartClick();
        this.switchingToWindow();
        this.goToCartClick();
        return new ShoppingCartPage(driver);
    }


}
