package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Constants.ConfigData;
import utils.Helper.ExcelHelper;
import utils.Logs.LogUtils;
import utils.reports.CaptureReport;

import java.time.Duration;
import java.util.Random;
import java.util.regex.Pattern;

import static Base.BaseSetup.sleep;
import static utils.Constants.ConfigData.*;

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
        LogUtils.info("Title Page Register:"+title);
    }
    public void fieldUserName(String name){
        if (name.matches(nameRegex)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ip_YourName));
            WebElement inputName = driver.findElement(ip_YourName);
            inputName.clear(); // Xóa trước khi nhập
            inputName.sendKeys(name);
            LogUtils.info("name:"+name);
        } else {
            LogUtils.info("Tên không hợp lệ (không được chứa số hoặc ký tự đặc biệt): " + name);
            // throw new IllegalArgumentException("Tên không hợp lệ: " + name);
        }
    }
    public void fieldEmailID(String email){
        if (email.matches(emailRegex)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
            driver.findElement(UserID).clear(); // Xóa trước khi nhập
            driver.findElement(UserID).sendKeys(email);
            LogUtils.info("Email hợp lệ: " + email);

        } else {
            LogUtils.info("Email không hợp lệ: " + email);
            // Có thể ném exception nếu muốn dừng quá trình
            // throw new IllegalArgumentException("Định dạng email không hợp lệ: " + email);
        }
    }
    public void fiedPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Passsword));
        driver.findElement(Passsword).sendKeys(password);
        LogUtils.info("password: " + password);
    }
    public void fiedRePassword(String re_password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(rePassword));
        driver.findElement(rePassword).sendKeys(re_password);
        LogUtils.info("Re_password: " + re_password);
    }
    public boolean checkPassword(){
        if (!Pattern.matches(regexNumber, ConfigData.pw)) {
            LogUtils.info("password has lens 6 to 32 charater.");
            return false;
        }
        if (!ConfigData.pw.equals(ConfigData.re_pw)) {
            LogUtils.info("password and re_password fail.");
            return false;
        }
        return true;
    }
    public void phoneNumber(String phone){
        if (phone.matches(phoneRegex)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(numberPhone));
            driver.findElement(numberPhone).clear(); // Xóa trước khi nhập
            driver.findElement(numberPhone).sendKeys(phone);
            LogUtils.info("Số điện thoại hợp lệ: " + phone);
        } else {
            LogUtils.info("Số điện thoại không hợp lệ: " + phone);
            // Có thể throw lỗi nếu cần
            // throw new IllegalArgumentException("Số điện thoại không hợp lệ: " + phone);
        }
    }
    public void datePicker(String datetimes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(datetime));
        driver.findElement(datetime).sendKeys(datetimes);
        LogUtils.info("birthday: " + datetimes);
    }
    private void optionChecked(){
        WebElement maleRadioButton = driver.findElement(By.xpath(option1));
        WebElement femaleRadioButton = driver.findElement(By.xpath(option2));
        if(!maleRadioButton.isSelected()){
            maleRadioButton.click();
            LogUtils.info("gender is: Male");
        }else if(!femaleRadioButton.isSelected()){
            femaleRadioButton.click();
            LogUtils.info("gender is: Female");
        }else {
            LogUtils.info("please chossen: Male or Female");
        }
    }
    private void cbAgree(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cbIagree));
        WebElement checkboxRemember = driver.findElement(cbIagree);
        if (!checkboxRemember.isSelected()) {
            checkboxRemember.click();
        }
        LogUtils.info("click Agree ");
    }
    private void submitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        driver.findElement(submit).click();
        LogUtils.info("Click button Register");
    }
    public boolean verifyRegisterSuccsess(){
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),"fail van login");
        LogUtils.error("verify Register Fail");
        return false;
    }
    public void login(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyMember));
        driver.findElement(alreadyMember).click();
        LogUtils.info("Go To Page Login"+alreadyMember);
    }
    public void WriteData(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.Excel,"Login");
        excelHelper.setCellData("vietnam@gmail.com", 0, 3);
        excelHelper.setCellData("Aty05121995@", 1, 3);
        excelHelper.setCellData("Aty05121995@", 3, 3);
        excelHelper.setCellData("tynguyen", 2, 3);
        excelHelper.setCellData("0376082747", 4, 3);
        excelHelper.setCellData("22112014", 5, 3);
        LogUtils.info("Write Data Successfully");
    }
    public HomePage register(String name,String email, String password,String re_password,String phone,String datetimes)
    {
        driver.get(ConfigData.registerUrl);
        LogUtils.info("This is Page Register");
        this.WriteData();
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
        this.submitButton();
        this.verifyRegisterSuccsess();
        return new HomePage(driver);
    }
    public HomePage registerLogin(){
        driver.get(ConfigData.registerUrl);
        LogUtils.info("Goto the page Login");
        this.TitlePage();
        this.login();
        return new HomePage(driver);
    }
}
