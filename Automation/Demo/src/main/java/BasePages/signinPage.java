package BasePages;

import utils.Constants.ConfigData;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Logs.LogUtils;

import java.time.Duration;

import static Base.BaseSetup.sleep;
import static utils.Constants.ConfigData.emailRegex;

public class signinPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By Title= By.xpath(Locator_CMS.lbsigninTitle);
    private By UserID = By.xpath(Locator_CMS.email);
    private By Passsword = By.xpath(Locator_CMS.password);
    private By aResgister = By.xpath(Locator_CMS.aResgister);
    private  By btnLogin = By.xpath(Locator_CMS.btnLogin);
    public signinPage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void titlePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
        driver.findElement(Title).getText();
    }
    public void fieldUserID(String email){
        if (email.matches(emailRegex)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
            driver.findElement(UserID).clear(); // Xóa trước khi nhập
            driver.findElement(UserID).sendKeys(email);
            System.out.println("Email hợp lệ: " + email);
            LogUtils.info("Email hợp lệ: " + email);
        } else {
            System.out.println("Email không hợp lệ: " + email);
            LogUtils.info("Email không hợp lệ: " + email);
            // Có thể ném exception nếu muốn dừng quá trình
            // throw new IllegalArgumentException("Định dạng email không hợp lệ: " + email);
        }
    }
    public void fiedPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Passsword));
        driver.findElement(Passsword).sendKeys(password);
    }
    private  void a_Resgister(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(aResgister));
        driver.findElement(aResgister).click();
    }
    private void loginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        driver.findElement(btnLogin).click();
    }
    public void verifyLoginSuccsess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"),"fail van login");
    }
    public HomePage login(String email, String password){
        try{
            driver.get(ConfigData.signinUrl);
            sleep(2);
            this.titlePage();
            this.fieldUserID(email);
            this.fiedPassword(password);
            sleep(2);
            this.loginButton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new HomePage(driver);
    }
    public HomePage loginRegister(){
        driver.get(ConfigData.signinUrl);
        this.a_Resgister();
        return new HomePage(driver);
    }
}
