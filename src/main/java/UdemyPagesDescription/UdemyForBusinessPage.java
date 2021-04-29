package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UdemyForBusinessPage extends BaseUdemy {

    private WebDriver driver;

    public UdemyForBusinessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
//Get your demo
    private By header = By.xpath("//body/section[1]/div[2]/div[2]/div[1]/div[1]/h1[1]");

    public String getHeadingText(){
        return driver.findElement(header).getText();
    }



}
