package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Locator.Locator_CMS.opionFemales;
import static Locator.Locator_CMS.opionMales;

public class profilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public profilePage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void editEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editProfile)));
        driver.findElement(By.xpath(Locator_CMS.editProfile)).click();
    }
    public void fieldEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editEmail)));
        driver.findElement(By.xpath(Locator_CMS.editEmail)).getText();
    }
    public void fieldPhoneNumber(String numberPhone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editPhoneNumber)));
        driver.findElement(By.xpath(Locator_CMS.editPhoneNumber)).sendKeys(numberPhone);
    }
    public void fieldName(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editName)));
        driver.findElement(By.xpath(Locator_CMS.editName)).sendKeys(email);
    }
    public void fieldBirthDay(String brithday){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_CMS.editBirthday)));
        driver.findElement(By.xpath(Locator_CMS.editBirthday)).sendKeys(brithday);
    }
    public void fiedGender(){
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
    public void openPodup(String numberPhone){

    }
}
