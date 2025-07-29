package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Constants.ConfigData;

import java.time.Duration;
import java.util.regex.Pattern;

import static Base.BaseSetup.sleep;
import static utils.Constants.ConfigData.regexNumber;

public class joinPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By Title= By.xpath(Locator_CMS.lbRegisterTitle);
    private By ip_YourName=By.xpath(Locator_CMS.ipUser);
    private By UserID = By.xpath(Locator_CMS.email);
    private By Passsword= By.xpath(Locator_CMS.ipPw);
    private By rePassword= By.xpath(Locator_CMS.ipRpw);
    private By numberPhone = By.xpath(Locator_CMS.ipPhone);
    private By datetime= By.xpath(Locator_CMS.ipBrithday);
    private String option1 =String.format(Locator_CMS.opionMale);
    private String option2 =String.format(Locator_CMS.opionFemale);
    private By cbIagree= By.xpath(Locator_CMS.cbox_agreeitem);
    private By submit = By.xpath(Locator_CMS.btnSubmit);
    private  By alreadyMember= By.xpath(Locator_CMS.aLogin);
    public joinPage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void TitlePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
       String title= driver.findElement(Title).getText();
        System.out.println(title);
    }
    public void fieldUserName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ip_YourName));
        driver.findElement(ip_YourName).sendKeys(name);
    }
    public void fieldEmailID(String email){
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
    public boolean checkPassword(){
        if (!Pattern.matches(regexNumber, ConfigData.pw)) {
            System.out.println("Mật khẩu phải có độ dài từ 6 đến 32 ký tự.");
            return false;
        }
        if (!ConfigData.pw.equals(ConfigData.re_pw)) {
            System.out.println("Mật khẩu và mật khẩu nhập lại không khớp.");
            return false;
        }
        return true;
    }
    public void phoneNumber(String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberPhone));
        driver.findElement(numberPhone).sendKeys(phone);
    }
    public void datePicker(String datetimes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(datetime));
        driver.findElement(datetime).sendKeys(datetimes);
    }
    private void optionChecked(){
        WebElement maleRadioButton = driver.findElement(By.xpath(option1));
        WebElement femaleRadioButton = driver.findElement(By.xpath(option2));
        if (maleRadioButton.isSelected()){
            System.out.println("gender is: Male");
        } else if(femaleRadioButton.isSelected()){
            System.out.println("gender is: Female");
        }else {
            System.out.println("please chossen: Male or Female");
        }
    }
    private void cbAgree(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cbIagree));
        WebElement checkboxRemember = driver.findElement(cbIagree);
        if (checkboxRemember.isSelected()==false){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        driver.findElement(By.xpath(Locator_CMS.cbox_agreeitem)).click();
        if (checkboxRemember.isSelected()==false){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    private void submitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        driver.findElement(submit).click();
    }
    public void verifyRegisterSuccsess(){
        this.submitButton();
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"),"fail van login");
    }
    public void login(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyMember));
        driver.findElement(alreadyMember).click();
    }
    public HomePage register(String name,String email, String password,String re_password,String phone,String datetimes)
    {
        driver.get(ConfigData.registerUrl);
        this.TitlePage();
        this.fieldUserName(name);
        this.fieldEmailID(email);
        this.fiedPassword(password);
        this.fiedRePassword(re_password);
        this.checkPassword();
        this.phoneNumber(phone);
        this.datePicker(datetimes);
        this.optionChecked();
        this.cbAgree();

        this.verifyRegisterSuccsess();
        return new HomePage(driver);
    }

    public HomePage registerLogin(){
        driver.get(ConfigData.registerUrl);
        this.TitlePage();
        this.login();
        return new HomePage(driver);
    }
}
