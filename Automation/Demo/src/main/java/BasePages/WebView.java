package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebView {
    private WebDriver driver;
    private WebDriverWait wait;
    private By btnSignin = By.xpath(Locator_CMS.btnSignin);
    public WebView(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public LoginPage logOut(){
        driver.findElement(btnSignin).click();
        return new LoginPage(driver);
    }
}
