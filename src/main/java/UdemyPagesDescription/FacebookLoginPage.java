package UdemyPagesDescription;

import org.openqa.selenium.WebDriver;

public class FacebookLoginPage extends BaseUdemy {

    private WebDriver driver;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
