package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class joinPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By Title= By.xpath(Locator_CMS.lbRegisterTitle);
    private By ip_YourName=By.xpath(Locator_CMS.ipUser);
    private By UserID = By.xpath(Locator_CMS.email);
    private By Passsword= By.xpath(Locator_CMS.ipPw);
    private By rePassword= By.xpath(Locator_CMS.ipRpw);
    private By numberPhone = By.xpath(Locator_CMS.ipPhone);

    private By submit = By.xpath(Locator_CMS.btnSubmit);
    private  By alreadyMember= By.xpath(Locator_CMS.aLogin);
    public joinPage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void TitlePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
        driver.findElement(Title).getText();
    }
    public void fieldUserName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ip_YourName));
        driver.findElement(ip_YourName).sendKeys(name);
    }
    public void fieldUserID(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
        driver.findElement(UserID).sendKeys(email);
    }
    public void fiedPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Passsword));
        driver.findElement(Passsword).sendKeys(password);
    }
    public void fiedRePassword(String re_password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(rePassword));
        driver.findElement(rePassword).sendKeys(re_password);
    }
    public void phoneNumber(String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberPhone));
        driver.findElement(numberPhone).sendKeys(phone);
    }


    private void submitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        driver.findElement(submit).click();
    }
    public void verifyRegisterSuccsess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"),"fail van login");
    }
    public void login(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyMember));
        driver.findElement(alreadyMember).click();

    }
    public webUIPage register(String name,String email, String password, String re_password, String phone ){
        driver.get("https://demo5.cybersoft.edu.vn/register");
        TitlePage();
        fieldUserName(name);
        fieldUserID(email);
        fiedPassword(password);
        fiedRePassword(re_password);
        phoneNumber(phone);
        submitButton();
        return new webUIPage(driver);
    }
}
