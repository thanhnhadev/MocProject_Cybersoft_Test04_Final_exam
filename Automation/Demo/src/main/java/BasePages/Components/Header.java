package BasePages.Components;

import Locator.Locator_CMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.ActionKeyword.ActionKeyword;
import utils.Logs.LogUtils;

import java.time.Duration;

import static Base.BaseSetup.driver;
import static Base.BaseSetup.sleep;

public class Header {
    private WebDriver _driver;
    private WebDriverWait wait;
    private By Fiverr_Business= By.xpath(Locator_CMS.Fiverr_Business);
    private By Search_Bar= By.xpath(Locator_CMS.Search_Bar);
    private By btnSearching= By.xpath(Locator_CMS.btnSearching);
    private By Explore= By.xpath(Locator_CMS.Explore);
    private By English= By.xpath(Locator_CMS.English);
    private By UsD= By.xpath(Locator_CMS.UsD);
    private By Become_a_Seller= By.xpath(Locator_CMS.Become_a_Seller);
    private By btnSignin= By.xpath(Locator_CMS.btnSignin);
    private By btnJoin= By.xpath(Locator_CMS.btnJoin);

    public Header(WebDriver driver) {
        this._driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // page valation
    public boolean LogoDisplay(){
        try{
            return this._driver.findElement(By.className(Locator_CMS.Logo)).isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    public void Fiverr_Business(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Fiverr_Business));
        String title= driver.findElement(Fiverr_Business).getText();
        LogUtils.info("header:"+title);
        driver.findElement(Fiverr_Business).click();
    }
    public void Search_Bar(String content){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search_Bar));
        String title= driver.findElement(Search_Bar).getText();
        driver.findElement(Search_Bar).sendKeys(content);
        LogUtils.info("header:"+title);
        this.btnSearch();
    }
    public void btnSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearching));
        driver.findElement(Search_Bar).click();
        LogUtils.info("click search");
    }
    public void Explore(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Explore));
        String title= driver.findElement(Explore).getText();
        LogUtils.info("header:"+title);
        driver.findElement(Explore).click();
    }
    public void English(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(English));
        String title= driver.findElement(English).getText();
        LogUtils.info("header:"+title);
        driver.findElement(English).click();
    }
    public void UsD(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsD));
        String title= driver.findElement(UsD).getText();
        LogUtils.info("header:"+title);
        driver.findElement(UsD).click();
    }
    public void Become_a_Seller(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Become_a_Seller));
        String title= driver.findElement(Become_a_Seller).getText();
        LogUtils.info("header:"+title);
        driver.findElement(Become_a_Seller).click();
    }
    public void btnSignin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignin));
        String title= driver.findElement(btnSignin).getText();
        LogUtils.info("header:"+title);
        driver.findElement(btnSignin).click();
    }
    public void btnJoin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnJoin));
        String title= driver.findElement(btnJoin).getText();
        LogUtils.info("header:"+title);
        driver.findElement(btnJoin).click();
    }
    public boolean checkSuccessFull(String content){
        sleep(5);
        Assert.assertTrue(driver.getCurrentUrl().contains(content),"fail van login");
        LogUtils.error("Login Fail");
        return false;
    }
}
