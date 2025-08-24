package BaseTest;

import Base.BaseSetup;
import BasePages.Components.Header;
import BasePages.HomePage;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import org.openqa.selenium.WebElement;
import utils.reports.CaptureReport;
import utils.reports.ExtentTestManager;

import java.time.Instant;

@Listeners(TestListener.class)
public class HomePageTest extends BaseSetup {
    HomePage HomePageTest;
    Header Header;
    private WebDriverWait wait;
    private By SearchPlaceholder = By.xpath(Locator_CMS.SearchPlaceholder);
//    @Test(testName = "tc_02_Navigatio Fiverr Bussines")
//    public void verify_Navigation (){
//        HomePageTest = new HomePage(driver);
//        driver.get("https://demo5.cybersoft.edu.vn/");
//        driver.findElement(By.xpath(Locator_CMS.Fiverr_Business)).click();
//        CaptureReport.captureScreenshot(driver, "navigation success");
//        CaptureReport.stopRecord();
//    }

    // Navigation Bar
    public void gotoHomePage() {
        Header = new Header(driver);
        HomePageTest = new HomePage(driver);
        driver.get(ConfigData.base_url);
        LogUtils.info("Go to Home Page");
    }

    @Test(priority = 1, testName = "TC-02 Navigatio Fiverr")
    public void verifyNavigationFiverr () {
        this.gotoHomePage();
        LogUtils.info("Go to Home Page");
        Header.Fiverr_Business();
        Header.checkSuccessFull("Fiverr Business");
    }

    @Test(priority = 2, testName = "TC-03 Navigation Explore")
    public void verifyNavigationExplore () {
        this.gotoHomePage();
        Header.Explore();
        Header.checkSuccessFull("Explore");
    }

    @Test(priority = 3, testName = "TC-04 Navigation English")
    public void verifyNavigationEnglish () {
        this.gotoHomePage();
        LogUtils.info("Go to Home Page");
        Header.English();
        Header.checkSuccessFull("English");
    }

    @Test(priority = 4, testName = "TC-06 Navigation US$ USD")
    public void verifyCurrencyConversion () {
        this.gotoHomePage();
        Header.UsD();
        LogUtils.info("Currency conversion US");
        Header.checkSuccessFull("US$ USD");
    }
    @Test(priority = 5, testName = "TC-08 Navigation Become a Seller")
    public void verifyNavigationSeller () {
        this.gotoHomePage();
        Header.Become_a_Seller();
        LogUtils.info("Navigation Become a Seller");
        Header.checkSuccessFull("seller");
    }

    @Test(priority = 6, testName = "TC-9 Navigation SignIn")
    public void verifyNavigationSignIn () {
        this.gotoHomePage();
        Header.btnSignin();
        LogUtils.info("Go to Sign In Page");
        Header.checkSuccessFull("login");
    }

    @Test(priority = 7, testName = "TC-10 Navigation Join")
    public void verifyNavigationRegister () {
        this.gotoHomePage();
        Header.btnJoin();
        LogUtils.info("Go to Register Page");
        Header.checkSuccessFull("register");
    }

    @Test(priority = 8, testName = "TC-11 Back to the homepage" )
    public void verifyBackHomePage() {
        this.verifyNavigationSignIn();
        driver.findElement(By.xpath(Locator_CMS.Logo)).click();
        LogUtils.info("Go to back Home Page");
        Header.checkSuccessFull("");
    }

    @Test(priority = 9, testName = "TC-12 Placeholder Search Box" )
    public void placeholderSearchBox() {
        this.gotoHomePage();
        WebElement searchBox = driver.findElement(By.xpath(Locator_CMS.SearchPlaceholder));
        // Lấy placeholder
        String placeholder = searchBox.getAttribute("placeholder");
        System.out.println("Placeholder text: " + placeholder);
        // So sánh với giá trị mong đợi
        Assert.assertEquals(placeholder, "Try \"building mobile app\"");
        LogUtils.info("Placeholder assertion passed!");
    }
    // Search Box
    @Test(priority = 10, testName = "TC-13 Input Valid keywords Search Box " )
    public void inputValidKeySearchBox() {
        this.gotoHomePage();
        WebElement searchBox = driver.findElement(By.xpath(Locator_CMS.SearchPlaceholder));
        sleep(5);
        searchBox.sendKeys("Website");
        HomePageTest.btnSearch();
        sleep(5);
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        Header.checkSuccessFull("result/Website");
        LogUtils.info("Input Valid keywords Search Box passed!");
    }
}
