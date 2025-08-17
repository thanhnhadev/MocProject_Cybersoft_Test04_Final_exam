package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import utils.reports.CaptureReport;

import java.util.Hashtable;
@Listeners(TestListener.class)
public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;

    @Test(priority = 2,testName = "tc_01_Login_Pass", dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginSucess(Hashtable< String, String > data){
        CaptureReport.startRecord("Login_success");
        signinPageTest = new signinPage(driver);
        signinPageTest.login(
                data.get("username"),
                data.get("password"));
        CaptureReport.captureScreenshot(driver, "Login_success");
        CaptureReport.stopRecord();
        signinPageTest.verifyLoginSuccsess();
    }
    @Test (priority = 1, testName = "tc_02_Login_Fail", dataProvider = "data_LoginFail_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginFail(Hashtable< String, String > data){
            CaptureReport.startRecord("Login_Fail");
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
            CaptureReport.captureScreenshot(driver, "Login_Fail");
            CaptureReport.stopRecord();
            signinPageTest.verifyLoginSuccsess();
    }
    @Test(priority = 3,testName = "tc_03_Click_Register")
    public void goToPageRester(){
            CaptureReport.startRecord("Page Resgiter Pass");
            signinPageTest= new signinPage(driver);
            signinPageTest.loginRegister();
            CaptureReport.captureScreenshot(driver, "Page Resgiter Pass");
            CaptureReport.stopRecord();
    }

    @Test(priority = 4, testName =  "tc_04_Empty_Username_Field")
    public void verifyEmptyusernameField(){
        CaptureReport.startRecord("Empty_Username_Field");
        signinPageTest = new signinPage(driver);

        driver.get(ConfigData.signinUrl);
        signinPageTest.triggerEmailError();
        Assert.assertTrue(signinPageTest.verifyEmptyEmailError(),
                "Không thấy hiển thị lỗi 'Email không được bỏ trống !'");
        CaptureReport.captureScreenshot(driver, "Empty_Username_Field");
        CaptureReport.stopRecord();
    }

    @Test(priority = 5, testName = "tc_05_Invalid_Email_Format")
        public void verifyInvalidEmailFormat(){
            CaptureReport.startRecord("Invalid_Email_Field");
            signinPageTest = new signinPage(driver);

            driver.get(ConfigData.signinUrl);
            signinPageTest.getEmailFormatErrorText();
             Assert.assertTrue(signinPageTest.verifyInvalidEmailFormat(),
                "Không thấy hiển thị lỗi 'Email không đúng định dạng !'");

            CaptureReport.captureScreenshot(driver, "Invalid_Email_Format");
            CaptureReport.stopRecord();
    }


}
