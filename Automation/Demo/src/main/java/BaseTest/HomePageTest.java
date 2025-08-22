package BaseTest;

import Base.BaseSetup;
import BasePages.Components.Header;
import BasePages.HomePage;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import utils.reports.CaptureReport;

@Listeners(TestListener.class)
public class HomePageTest extends BaseSetup {
    HomePage HomePageTest;
    Header Header;
//    @Test(testName = "tc_02_Navigatio Fiverr Bussines")
//    public void verify_Navigation (){
//        HomePageTest = new HomePage(driver);
//        driver.get("https://demo5.cybersoft.edu.vn/");
//        driver.findElement(By.xpath(Locator_CMS.Fiverr_Business)).click();
//        CaptureReport.captureScreenshot(driver, "navigation success");
//        CaptureReport.stopRecord();
//    }

    @Test(testName = "tc_02_Navigatio Fiverr")
    public void verifyNavigationSignIn () {
        Header = new Header(driver);
        HomePageTest = new HomePage(driver);
        driver.get(ConfigData.base_url);
        LogUtils.info("Go to Home Page");
        sleep(5);
        Header.Fiverr_Business();
        Header.checkSuccessFull("Fiverr Business");
    }


}
