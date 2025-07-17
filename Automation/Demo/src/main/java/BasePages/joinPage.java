package BasePages;

import Constants.ConfigData;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import static Constants.ConfigData.regex;

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
    private String option1 =String.format(Locator_CMS.opion);
    private By cbIagree= By.xpath(Locator_CMS.cbox_agreeitem);
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
    public boolean checkPassword(String password, String re_password){
        if (!Pattern.matches(regex, password)) {
            System.out.println("Mật khẩu phải có độ dài từ 6 đến 32 ký tự.");
            return false;
        }
        // Check if password and re-password match
        if (!password.equals(re_password)) {
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
//        driver.findElement(datetime).sendKeys(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm", Locale.ENGLISH);
        String formatted = LocalDateTime.parse(datetimes).format(formatter);
        System.out.println(formatted);
    }
    private boolean optionChecked(String gender){
        String productXpath = String.format(option1, gender);
//        this.driver.findElement(By.xpath(productXpath)).click();

        if (this.driver.findElement(By.xpath(productXpath)).isSelected()==true){
            System.out.println("gender is: Male");
        } else {
            System.out.println("gender is: Female");
        }
        return false;
    }
    private void cbAgree(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cbIagree));
        driver.findElement(cbIagree).click();
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
    public webUIPage register(String name,String email, String password, String re_password, String phone,String datetimes, String gender )
    {
        driver.get(ConfigData.registerUrl);
        TitlePage();
        fieldUserName(name);
        fieldUserID(email);
        fiedPassword(password);
        fiedRePassword(re_password);
        checkPassword(password, re_password);
        phoneNumber(phone);
        datePicker(datetimes);
        optionChecked(gender);
        cbAgree();
        submitButton();
        return new webUIPage(driver);
    }
}
