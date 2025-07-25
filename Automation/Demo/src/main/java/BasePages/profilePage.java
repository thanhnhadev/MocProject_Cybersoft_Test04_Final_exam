package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants.ConfigData;
import utils.LogUtils;

import java.time.Duration;
import java.util.List;

import static Locator.Locator_CMS.*;

public class profilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By phoneName= By.xpath(Locator_CMS.editPhoneNumber);
    private By editName= By.xpath(Locator_CMS.editName);
    private By editBirthday = By.xpath(Locator_CMS.editBirthday);
    private By lstCartItem =By.className(Locator_CMS.lstCartItemclass);
//    private By detailItemView = By.className(Locator_CMS.btnViewdetail);


    public profilePage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void editAccount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editProfile)));
        driver.findElement(By.xpath(Locator_CMS.editProfile)).click();
    }
    public void titlePodup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.titlePodup)));
        driver.findElement(By.xpath(Locator_CMS.titlePodup)).getText();
    }
    public void fieldEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editEmail)));
        driver.findElement(By.xpath(Locator_CMS.editEmail)).getText();
    }
    public void fieldPhoneNumber(String numberPhone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneName));
        WebElement inputElement = driver.findElement(phoneName);
        inputElement.click();
        inputElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(numberPhone);
    }
    public void fieldName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editName));
        WebElement inputElement = driver.findElement(editName);
        inputElement.click();
        inputElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(name);
    }
    public void datePicker(String datetimes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBirthday));
        WebElement inputElement = driver.findElement(editBirthday);
        inputElement.click();
        inputElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        inputElement.sendKeys(Keys.DELETE);
        inputElement.sendKeys(datetimes);
    }
    public void fieldGender(){
        WebElement maleRadioButton = driver.findElement(By.xpath(opionMales));
        WebElement femaleRadioButton = driver.findElement(By.xpath(opionFemales));
        if (maleRadioButton.isSelected()){
            System.out.println("gender is: Male");
        } else if(femaleRadioButton.isSelected()){
            System.out.println("gender is: Female");
        }else {
            System.out.println("please chossen: Male or Female");
        }
    }
    public void fieldCentificate(String certificate){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editCetificate)));
        driver.findElement(By.xpath(Locator_CMS.editCetificate)).click();
        driver.findElement(By.xpath(Locator_CMS.editCetificate)).sendKeys(certificate);
    }
    public void fieldSkill(String skill){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editSkill)));
        driver.findElement(By.xpath(Locator_CMS.editSkill)).sendKeys(skill);
    }
    public void btnCancel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.btnCancel)));
        driver.findElement(By.xpath(Locator_CMS.btnCancel)).click();
    }
    public void btnSave(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.btnSave)));
        driver.findElement(By.xpath(Locator_CMS.btnSave)).click();
    }

    public int getCartItem(){
        List<WebElement> lstCartItems = this.driver.findElements(lstCartItem);
        return lstCartItems.size();
    }

    public void RemoveCartItem(String productName){
        String productXpath = String.format(Locator_CMS.btnRemoveCartItemclass1,productName);
//        for (int i = 1; i < productXpath.length();i++) {
//            WebElement element = driver.findElement(By.xpath(productXpath + '['+i+']' ));
//            this.driver.findElement(By.xpath(String.valueOf(element))).click();
//        }
        List<WebElement> elements = driver.findElements(By.xpath(productXpath));
        for (WebElement element : elements) {
            element.click();
        }
    }
    public void DetailItem(String productName){
        String productXpath = String.format(Locator_CMS.btnViewdetail,productName);
        List<WebElement> elements = driver.findElements(By.xpath(productXpath));
        for (WebElement element : elements) {
            element.click();
        }
    }
    public boolean isCartItemEmpty(){
        List<WebElement> lstCartItems = this.driver.findElements(lstCartItem);
        boolean isTrue= true;
        if(lstCartItems.size()>0){
            isTrue= false;
        }
        return isTrue;
    }

    public void openPodup(){
        editAccount();
        LogUtils.info("open podup");
        titlePodup();
        fieldEmail();
        fieldPhoneNumber(ConfigData.phone);
        fieldName(ConfigData.userEmailId);
        datePicker(ConfigData.date);
        fieldGender();
        fieldCentificate(ConfigData.certificate);
        fieldSkill(ConfigData.skill);
        btnSave();
    }



}
