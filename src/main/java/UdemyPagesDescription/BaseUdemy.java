package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BaseUdemy {

    private WebDriver driver;

    public BaseUdemy(WebDriver driver) {
        this.driver = driver;
    }


    public String gettingTitle(){
        return driver.getTitle();
    }

    //get url
    public String gettingUrl(){
        return driver.getCurrentUrl();
    }


    public void switchingToTab(){
        for(String windowHandle: driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
    }

    public void switchingToWindow(){
        String myWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(myWindowHandle);
    }

    public void scrollingDown(int pixels){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, "+pixels+")","");
    }

    public void scrollingUp(int pixels){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, "+pixels+")","");
    }

    private By homePageBtnHeader = By.xpath("//a[@class=\"header--flex-middle--2Xqjv header--logo--bdAod\"]");

}
