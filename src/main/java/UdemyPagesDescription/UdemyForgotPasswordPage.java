package UdemyPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UdemyForgotPasswordPage extends BaseUdemy {

    private WebDriver driver;

    public UdemyForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By header = By.xpath("//div[@class=\"loginbox-v4__header\"]");

//Forgot Password
    public String getHeaderText(){
        return driver.findElement(header).getText();
    }


}
