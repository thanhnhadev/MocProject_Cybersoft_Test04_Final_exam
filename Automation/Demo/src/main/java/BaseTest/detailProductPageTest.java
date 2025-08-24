package BaseTest;

import Base.BaseSetup;
import BasePages.detailProductPage;
import BasePages.signinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.listeners.TestListener;
import utils.reports.CaptureReport;


@Listeners(TestListener.class)
public class detailProductPageTest extends BaseSetup {

    detailProductPage detailPage;
    private WebDriverWait wait;



    @BeforeMethod
    public void init() {
        detailPage = new detailProductPage(driver);
    }

//    @Test(priority = 1,testName = "tc_01_Join_Detail_Page")
//    public void verifyJoinDetailPage(){
//        CaptureReport.startRecord("Join Detail Page");
//        detailPage = new detailProductPage(driver);
//
//        detailPage.joinDetailPage();
//
//        CaptureReport.captureScreenshot(driver, "Join detail page success");
//        CaptureReport.stopRecord();
//    }

    @Test(priority = 1, testName = "tc_01_Hire_Service_When_Not_Logged_in")
    public void hireServiceWhenNotLoggedIn() {
        CaptureReport.startRecord("Hire Service When Not Logged In");

        // B1: Vào trang detail
        detailPage.joinDetailPage();

        // B2: Click Continue
        detailPage.clickContinueHire();

        // B3: Verify điều hướng sang trang Login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(
                currentUrl,
                ConfigData.siginPage_url,
                "Không chuyển hướng sang trang login sau khi click Continue mà chưa đăng nhập!"
        );

        CaptureReport.captureScreenshot(driver, "Redirect_To_Login_When_Not_LoggedIn");
        CaptureReport.stopRecord();
    }

    @Test(priority = 2, testName = "tc_02_Hire_Service_When_Logged_in")
    public void hireServiceWhenLoggedIn() {
        CaptureReport.startRecord("Hire Service When Logged In");

        // B1 Login (hàm login )
        detailPage.login();

        // B2 Vào trang detail
        detailPage.joinDetailPage();
        // B3 Click Continue
        detailPage.clickContinueHire();
//      // B4 Verify toast
        Assert.assertTrue(detailPage.isHireSuccessToastShown(),
                "Không thấy thông báo 'Thuê công việc thành công' sau khi click Continue.");


        CaptureReport.captureScreenshot(driver, "Thue thanh cong dich vu khi da loggin");
        CaptureReport.stopRecord();
    }

    @Test(priority = 3, testName = "tc_03_Click_Compare_Packages_When_Not_Logged_In")
    public void clickComparepackages(){
        CaptureReport.startRecord("Click button Compare Packages When Not Logged In");
        detailPage.joinDetailPage();
        detailPage.clickButtonComparePackages();
        // B3: Verify điều hướng sang trang Login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(
                currentUrl,
                ConfigData.siginPage_url,
                "Không chuyển hướng sang trang login sau khi click Compare Packages mà chưa đăng nhập!");

        CaptureReport.captureScreenshot(driver, "Redirect_To_Login_When_LoggedIn");
        CaptureReport.stopRecord();

    }





}
