package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UdemyBecomeTeacherPage extends BaseUdemy {

    WebDriver driver;

    public UdemyBecomeTeacherPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Make a global impact
    private By header = By.xpath("//h1[@class=\"text-shadow\"]");


    public String getHeadingText() {
        return driver.findElement(header).getText();
    }


}
