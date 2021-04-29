package UdemyPagesDescription;

import org.openqa.selenium.WebDriver;

public class AppleLoginPage extends BaseUdemy {

    private WebDriver driver;

    public AppleLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
