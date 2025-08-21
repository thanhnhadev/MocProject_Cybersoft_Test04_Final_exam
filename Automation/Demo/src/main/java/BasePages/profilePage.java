package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;

import java.time.Duration;
import java.util.List;

import static Locator.Locator_CMS.*;

public class profilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By phoneName= By.xpath(Locator_CMS.editPhoneNumber);
    private By editName= By.xpath(Locator_CMS.editName);
    private By editBirthday = By.xpath(Locator_CMS.editBirthday);
//    private By lstCartItem =By.className(Locator_CMS.lstCartItemclass);
//    private By detailItemView = By.className(Locator_CMS.btnViewdetail);


    public profilePage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void editAccount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editProfile)));
        driver.findElement(By.xpath(Locator_CMS.editProfile)).click();
        LogUtils.info("click edit account");
    }
    public void titlePodup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.titlePodup)));
        driver.findElement(By.xpath(Locator_CMS.titlePodup)).getText();
        LogUtils.info("Title Podup"+titlePodup);
    }
    public void fieldEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editEmail)));
        driver.findElement(By.xpath(Locator_CMS.editEmail)).getText();
        LogUtils.info("field_Email: " + email);
    }
    public void fieldPhoneNumber(String numberPhone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneName));
        WebElement inputElement = driver.findElement(phoneName);
        inputElement.click();
        inputElement.sendKeys(ActionKeyword.keyPress_Delete());
        inputElement.sendKeys(numberPhone);
        LogUtils.info("field_Phone: " + numberPhone);
    }
    public void fieldName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editName));
        WebElement inputElement = driver.findElement(editName);
        inputElement.click();
        inputElement.sendKeys(ActionKeyword.keyPress_Delete());
        inputElement.sendKeys(name);
        LogUtils.info("field_Name: " + name);
    }
    public void datePicker(String datetimes){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBirthday));
        WebElement inputElement = driver.findElement(editBirthday);
        inputElement.click();
        inputElement.sendKeys(ActionKeyword.keyPress_Delete());
        inputElement.sendKeys(datetimes);
        LogUtils.info("field_brithday: " + datetimes);
    }
    public void fieldGender(){
        WebElement maleRadioButton = driver.findElement(By.xpath(opionMales));
        WebElement femaleRadioButton = driver.findElement(By.xpath(opionFemales));
        if(!maleRadioButton.isSelected()){
            maleRadioButton.click();
            LogUtils.info("gender is: Male click");
        }else if(!femaleRadioButton.isSelected()){
            femaleRadioButton.click();
            LogUtils.info("gender is: Female click");
        }else {
            LogUtils.info("please chossen: Male or Female");
        }
    }
    public void fieldCentificate(String certificate){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editCetificate)));
        driver.findElement(By.xpath(Locator_CMS.editCetificate)).click();
        driver.findElement(By.xpath(Locator_CMS.editCetificate)).sendKeys(certificate);
        LogUtils.info("field_certificate: " + certificate);
    }
    public void fieldSkill(String skill){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editSkill)));
        driver.findElement(By.xpath(Locator_CMS.editSkill)).sendKeys(skill);
        LogUtils.info("field_skill: " + skill);
    }
    public void btnCancel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.btnCancel)));
        driver.findElement(By.xpath(Locator_CMS.btnCancel)).click();
        LogUtils.info("press button Cancel");
    }
    public void btnSave(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.btnSave)));
        driver.findElement(By.xpath(Locator_CMS.btnSave)).click();
        LogUtils.info("press button Save");
    }


    public void RemoveCartItem(String productName){
        String productXpath = String.format(Locator_CMS.btnRemoveCartItemclass1,productName);
        List<WebElement> elements = driver.findElements(By.xpath(productXpath));
        if (elements.isEmpty()) {
            LogUtils.warn("No cart item found to remove for product ");
            return;
        }
        for (WebElement element : elements) {
            try {
                element.click();
                LogUtils.info("Removed item successfully: " + productXpath);
            } catch (Exception e) {
                LogUtils.error(e+"Failed to remove item: " + productXpath);
            }
        }
    }
    public void DetailItem(String productName){
        String productXpath = String.format(Locator_CMS.btnViewdetail,productName);
        List<WebElement> elements = driver.findElements(By.xpath(productXpath));
        if (elements.isEmpty()) {
            LogUtils.warn("No detail button found for product " );
            return;
        }
        for (WebElement element : elements) {
            try {
                element.click();
                LogUtils.info("Viewed details for product: " + productXpath);
            } catch (Exception e) {
                LogUtils.error(e+"Failed to view details for product: " + productXpath);
            }
        }
    }

    public void openPodup(){
        this.editAccount();
        LogUtils.info("open podup");
        this.titlePodup();
        this.fieldEmail();
        this.fieldPhoneNumber(ConfigData.phone);
        this.fieldName(ConfigData.userEmailId);
        this.datePicker(ConfigData.date);
        this.fieldGender();
        this.fieldCentificate(ConfigData.certificate);
        this.fieldSkill(ConfigData.skill);
        this.btnSave();
    }



}
