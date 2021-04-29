package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UdemyMainPage extends BaseUdemy{

    private WebDriver driver;

    public UdemyMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //elements locators
    private By searchField = By.xpath("//input[@name='q'][1]");

    private By searchFieldSmall = By.xpath("//input[@placeholder='What do you want to learn?']");

    private By searchButton = By.xpath("//input[@placeholder='Search for anything']/following-sibling::*[1]");

    private By searchButtonSmall = By.xpath("//input[@placeholder='What do you want to learn?']/following-sibling::*[1]");

    private By udemyForBusinessLink = By.xpath("//span[text()='Udemy for Business']");

    private By udemyTeachOnUdemy = By.xpath("//span[text()='Teach on Udemy']");

    private By shoppingCartLink = By.id("u111-popper-trigger--11");

    private By logInButton = By.xpath("//a[@data-purpose='header-login']");

    private By signUpButton = By.xpath("//a[@data-purpose='header-signup']");

    private By languageChangeButton = By.xpath("//button[@class=\"udlite-btn udlite-btn-medium udlite-btn-ghost udlite-text-md locale-select-button language-selector-button--button--1wgoL\"]");



    //searching
    public UdemySearchResultsPage searchInSearchfieldByKey(String query){
        driver.findElement(searchField).sendKeys(query, Keys.ENTER);
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage searchInSearchfieldByClick(String query){
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchButton).click();
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage searchInSearchFieldSmallByKey(String query){
        driver.findElement(searchFieldSmall).sendKeys(query,Keys.ENTER);
        return new UdemySearchResultsPage(driver);
    }

    public UdemySearchResultsPage searchInSearchFieldSmallByClick(String query){
        driver.findElement(searchFieldSmall).sendKeys(query);
        driver.findElement(searchButtonSmall).click();
        return new UdemySearchResultsPage(driver);
    }


//click on links
    public UdemyLoginPage loginClick(){
        driver.findElement(logInButton).click();
        return new UdemyLoginPage(driver);
    }
    public UdemySignUpPage signUpClick(){
        driver.findElement(signUpButton).click();
        return new UdemySignUpPage(driver);
    }
    public UdemyForBusinessPage udemyForBusinessLinkClick(){
        driver.findElement(udemyForBusinessLink).click();
        return new UdemyForBusinessPage(driver);
    }

    public UdemyBecomeTeacherPage udemyBecomeTeacherLinkClick(){
        driver.findElement(udemyTeachOnUdemy).click();
        return new UdemyBecomeTeacherPage(driver);
    }


    public ShoppingCartPage shoppingCartLinkClick(){
        driver.findElement(shoppingCartLink).click();
        return new ShoppingCartPage(driver);
    }
    public UdemyMainPage languageButton(){
        driver.findElement(languageChangeButton).click();
        return this;
    }

    public UdemyMainPage chooseLanguage(String language){
        driver.findElement(By.xpath("\"//span[text()=\\\"\""+language+"\"\\\"]\"")).click();
        return this;
    }






}
