package BaseTest;

import Base.BaseSetup;
import BasePages.Components.Header;
import BasePages.HomePage;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import org.openqa.selenium.WebElement;
import utils.reports.CaptureReport;
import utils.reports.ExtentTestManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Instant;

@Listeners(TestListener.class)
public class HomePageTest extends BaseSetup {
    HomePage HomePageTest;
    Header Header;
    private WebDriverWait wait;
    private By inputSearch = By.xpath(Locator_CMS.inputSearch);
    private By btnPre1 = By.xpath(Locator_CMS.btnPre);
    private By btnSignin = By.xpath(Locator_CMS.btnSignin);
    private String btnPre = Locator_CMS.btnPre;
    private String btnNext = Locator_CMS.btnNext;
    private String currSliderPopular = Locator_CMS.currSliderPopular;

    public void gotoHomePage() {
        Header = new Header(driver);
        HomePageTest = new HomePage(driver);
        driver.get(ConfigData.base_url);
        LogUtils.info("Go to Home Page");
        sleep(5);
    }

    public int checkSearchBox(String sendkey){
        WebElement searchBox = driver.findElement(inputSearch);
        sleep(10);
        searchBox.sendKeys(sendkey);
        HomePageTest.btnSearch();
        sleep(10);
        String resultText = HomePageTest.checkResultSearch();
        sleep(10);
        System.out.println("resultText" + resultText);
        int serviceCount = HomePageTest.extractNumber(resultText);
        System.out.println("serviceCount" + serviceCount);
        sleep(10);
        return serviceCount;
    }

    // Navigation Bar
    @Test(priority = 1, testName = "TC-02 Navigation Fiverr")
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
        WebElement searchBox = driver.findElement(inputSearch);
        // Lấy placeholder
        String placeholder = searchBox.getAttribute("placeholder");
        System.out.println("Placeholder text: " + placeholder);
        // So sánh với giá trị mong đợi
        Assert.assertEquals(placeholder, "Try \"building mobile app\"");
        LogUtils.info("Placeholder assertion passed!");
    }
    // Search Box
    @Test(priority = 10, testName = "TC-13 Input Valid keywords Search Box " )
    public void inputValidKey() {
        this.gotoHomePage();
        sleep(5);
        int serviceCount = this.checkSearchBox("website");
        Assert.assertTrue(serviceCount > 0, "Expected > 0 services but found: " + serviceCount);
    }

    @Test(priority = 11, testName = "TC-14 Input Invalid keywords Search Box " )
    public void inputInValidKey() {
        this.gotoHomePage();
        sleep(5);
        int serviceCount = this.checkSearchBox("xyz123");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
    }

    @Test(priority = 12, testName = "TC-15 Input Special Character Search Box " )
    public void inputSpecialCharacter() {
        this.gotoHomePage();
        sleep(10);
        int serviceCount = this.checkSearchBox("@@@###");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
    }

    @Test(priority = 13, testName = "TC-16 Input Empty Search Box " )
    public void inputEmpty() {
        this.gotoHomePage();
        sleep(15);
        int serviceCount = this.checkSearchBox("");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
    }

    // Popular
    @Test(priority = 14, testName = "TC-17 CLick key Website Design of Popular Search" )
    public void clickWebsiteDesignKey() {
        this.gotoHomePage();
        HomePageTest.clickPopularKeyWord("Website Design");
        System.out.println("CurrentUrl: " + driver.getCurrentUrl());
        Header.checkSuccessFull("Website Design");
    }

    @Test(priority = 15, testName = "TC-17  CLick key WordPress of Popular Search" )
    public void clickWordPressKey() {
        this.gotoHomePage();
        HomePageTest.clickPopularKeyWord("WordPress");
        System.out.println("CurrentUrl: " + driver.getCurrentUrl());
        Header.checkSuccessFull("WordPress");
    }

    // Popular professional services
    @Test(priority = 16, testName = "TC-18  CLick key WordPress of Popular Search" )
    public void clickPreAndNextBtn() {
        this.gotoHomePage();
        System.out.println("btnPre: " + btnPre);
        HomePageTest.clickElement(btnPre);
    }

    @Test(priority = 17, testName = "TC-18  CLick key WordPress of Popular Search" )
    public void clickNextBtn() {
        this.gotoHomePage();
        System.out.println("btnPre: " + btnNext);
        HomePageTest.clickElement(btnNext);
    }

    @Test(priority = 18, testName = "TC-19  CLick key WordPress of Popular Search" )
    public void clickSlide() {
        this.gotoHomePage();
        System.out.println("btnPre: " + currSliderPopular);
        HomePageTest.clickElement(currSliderPopular);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // đóng hết tab
        }
    }
}
