package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class signinPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By UserID = By.xpath(Locator_CMS.email);
    private By Passsword = By.xpath(Locator_CMS.password);
    private  By btnLogin = By.xpath(Locator_CMS.btnLogin);
    public signinPage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void fieldUserID(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
        driver.findElement(UserID).sendKeys(email);
    }
    public void fiedPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Passsword));
        driver.findElement(Passsword).sendKeys(password);
    }
    private void loginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        driver.findElement(btnLogin).click();
    }
    public void verifyLoginSuccsess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"),"fail van login");
    }
    public webUIPage login(String email, String password){
        driver.get("https://demo5.cybersoft.edu.vn/login");
        fieldUserID(email);
        fiedPassword(password);
        loginButton();
        return new webUIPage(driver);
    }
}
