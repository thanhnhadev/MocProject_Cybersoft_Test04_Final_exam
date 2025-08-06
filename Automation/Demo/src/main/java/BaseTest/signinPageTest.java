package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.DataFactory;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import utils.reports.CaptureReport;

import java.util.Hashtable;
@Listeners(TestListener.class)
public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;

    @Test(priority = 1,testName = "tc_01_Login_Pass", dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
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
//    @Test (priority = 2, testName = "tc_02_Login_Fail", dataProvider = "data_LoginFail_Excel", dataProviderClass = DataFactory.class)
//    public void verifyLoginFail(Hashtable< String, String > data){
//            CaptureReport.startRecord("Login_Fail");
//            signinPageTest = new signinPage(driver);
//            signinPageTest.login(
//                    data.get("username"),
//                    data.get("password"));
//            CaptureReport.captureScreenshot(driver, "Login_Fail");
//            CaptureReport.stopRecord();
//            signinPageTest.verifyLoginSuccsess();
//    }
    @Test(priority = 2,testName = "tc_03_Click_Register")
    public void goToPageRester(){
            CaptureReport.startRecord("Page Resgiter Pass");
            signinPageTest= new signinPage(driver);
            signinPageTest.loginRegister();
            CaptureReport.captureScreenshot(driver, "Page Resgiter Pass");
            CaptureReport.stopRecord();
    }
}
