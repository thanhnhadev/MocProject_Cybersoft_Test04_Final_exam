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

    @Test(priority = 1,testName = "tc_01", dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginSucess(Hashtable< String, String > data){
        try {
            CaptureReport.startRecord("Login_success");
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
            CaptureReport.captureScreenshot(driver, "Login_success");
            sleep(5);
            CaptureReport.stopRecord();
            signinPageTest.verifyLoginSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test (priority = 2,  dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginFail(Hashtable< String, String > data){
        try {
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
            signinPageTest.verifyLoginSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test(priority = 3)
    public void goToPageRester(){
        try {
            LogUtils.info("Go to Page Resgiter Pass");
            signinPageTest= new signinPage(driver);
            signinPageTest.loginRegister();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
