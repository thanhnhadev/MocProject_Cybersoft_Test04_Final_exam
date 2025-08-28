package BaseTest;

import Base.BaseSetup;
import BasePages.Components.Header;
import BasePages.HomePage;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ActionKeyword.ActionKeyword;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import org.openqa.selenium.WebElement;

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
        sleep(45);
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
    @Test(priority = 10, testName = "TC-13 Input Valid keywords Search Box" )
    public void inputValidKey() {
        this.gotoHomePage();
        sleep(5);
        int serviceCount = this.checkSearchBox("website");
        Assert.assertTrue(serviceCount > 0, "Expected > 0 services but found: " + serviceCount);
        LogUtils.info("Input Valid keywords Search Box Passed");
    }

    @Test(priority = 11, testName = "TC-14 Input Invalid keywords Search Box " )
    public void inputInValidKey() {
        this.gotoHomePage();
        sleep(5);
        int serviceCount = this.checkSearchBox("xyz123");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
        LogUtils.info("Input Invalid keywords Search Box Passed");
    }

    @Test(priority = 12, testName = "TC-15 Input Special Character Search Box" )
    public void inputSpecialCharacter() {
        this.gotoHomePage();
        sleep(10);
        int serviceCount = this.checkSearchBox("@@@###");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
        LogUtils.info("Input Special Character Search Box Passed");
    }

    @Test(priority = 13, testName = "TC-16 Input Empty Search Box" )
    public void inputEmpty() {
        this.gotoHomePage();
        sleep(15);
        int serviceCount = this.checkSearchBox("");
        Assert.assertEquals(serviceCount, 0, "Expected 0 services but found: " + serviceCount);
        LogUtils.info("Input Empty Search Box Passed");
    }

    // Popular
    @Test(priority = 14, testName = "TC-17 Click key Website Design of Popular Search" )
    public void clickWebsiteDesignKey() {
        this.gotoHomePage();
        HomePageTest.clickPopularKeyWord("Website Design");
        System.out.println("CurrentUrl: " + driver.getCurrentUrl());
        Header.checkSuccessFull("Website Design");
        LogUtils.info("Click key Website Design of Popular Search Passed");
    }

    @Test(priority = 15, testName = "TC-17 Click key WordPress of Popular Search" )
    public void clickWordPressKey() {
        this.gotoHomePage();
        HomePageTest.clickPopularKeyWord("WordPress");
        System.out.println("CurrentUrl: " + driver.getCurrentUrl());
        Header.checkSuccessFull("WordPress");
        LogUtils.info("Click key Website Design of Popular Search Passed");
    }

//     Popular professional services
    @Test(priority = 16, testName = "TC-18 Verify click button next of Popular professional services" )
    public void clickNextBtn() {
        this.gotoHomePage();
        sleep(5);
        ActionKeyword actionKeyword= new ActionKeyword(driver);
        WebElement element  = driver.findElement(By.xpath(Locator_CMS.tileSliderbar));
        actionKeyword.scrollToElement(element);
        sleep(10);
        WebElement elementbtnNext  = driver.findElement(By.xpath(Locator_CMS.btnNext));
        elementbtnNext.click();
        sleep(10);
        LogUtils.info("Click key WordPress of Popular Search Passed");
    }

    @Test(priority = 17, testName = "TC-18 Verify click button previous of Popular professional services" )
    public void clickPrevBtn() {
        this.gotoHomePage();
        sleep(5);
        ActionKeyword actionKeyword= new ActionKeyword(driver);
        WebElement element  = driver.findElement(By.xpath(Locator_CMS.tileSliderbar));
        actionKeyword.scrollToElement(element);
        sleep(10);
        WebElement elementbtnPre  = driver.findElement(By.xpath(Locator_CMS.btnPre));
        elementbtnPre.click();
        LogUtils.info("Click key WordPress of Popular professional services Passed");
    }

    @Test(priority = 18, testName = "TC-19 CLick a slider of Popular professional services" )
    public void clickSlider() {
        this.gotoHomePage();
        sleep(5);
        ActionKeyword actionKeyword= new ActionKeyword(driver);
        WebElement element  = driver.findElement(By.xpath(Locator_CMS.tileSliderbar));
        actionKeyword.scrollToElement(element);
        sleep(10);
        WebElement elementbtnPre  = driver.findElement(By.xpath(Locator_CMS.sliderActive));
        elementbtnPre.click();
        sleep(5);
        String resultText = HomePageTest.checkResultSearch();
        sleep(10);
        int serviceCount = HomePageTest.extractNumber(resultText);
        System.out.println("serviceCount" + serviceCount);
        sleep(10);
        Assert.assertTrue(serviceCount > 0, "Expected > 0 services but found: " + serviceCount);
        LogUtils.info("CLick a slide of Popular professional services Passed");

    }

    //Catogories Menu
    @Test(priority = 20, testName = "TC-22 Hover Catogories Menu" )
    public void clickHoverCatogories() {
        this.gotoHomePage();
        sleep(5);
        ActionKeyword actionKeyword= new ActionKeyword(driver);
        WebElement element  = driver.findElement(By.xpath(Locator_CMS.trustBy));
        actionKeyword.scrollToElement(element);
        sleep(10);
        WebElement result = HomePageTest.catagoriesMenu("Graphics & Design");
        actionKeyword.hover(result);
        LogUtils.info("Click key WordPress of Popular Search Passed");
    }

    @Test(priority = 21, testName = "TC-19 Click SubCatogories Menu" )
    public void clickSubCatogories() {
        this.gotoHomePage();
        sleep(15);
        ActionKeyword actionKeyword= new ActionKeyword(driver);
        WebElement element  = driver.findElement(By.xpath(Locator_CMS.trustBy));
        actionKeyword.scrollToElement(element);
        sleep(15);
        WebElement result = HomePageTest.catagoriesMenu("Graphics & Design");
        result.click();
        sleep(10);
        WebElement subResult = HomePageTest.subCatagoriesMenu("Website Design");
        subResult.click();
        sleep(10);
        HomePageTest.testHasService();
        sleep(10);
        LogUtils.info("Click Click SubCatogories Menu Passed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // đóng hết tab
        }
    }
}
