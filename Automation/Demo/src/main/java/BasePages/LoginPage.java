package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
;
    private By inputUserID = By.xpath(Locator_CMS.email);
    private By inputPasssword = By.xpath(Locator_CMS.password);
    private  By btnLogin = By.xpath(Locator_CMS.btnLogin);
    public LoginPage(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    private void setinputUserID(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUserID));
        driver.findElement(inputUserID).sendKeys(email);
    }
    private void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPasssword));
        driver.findElement(inputPasssword).sendKeys(password);
    }
    private void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        driver.findElement(btnLogin).click();
    }
    public void verifyLoginSuccsess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"),"fail van login");
    }
    public WebView login(String email, String password){
        driver.get(Locator_CMS.base_url);
        setinputUserID(email);
        setPassword(password);
        clickLoginButton();
        return new WebView(driver);
    }
}
