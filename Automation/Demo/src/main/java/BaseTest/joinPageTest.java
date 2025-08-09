package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Helper.ExcelHelper;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;
import utils.reports.CaptureReport;

import java.util.Hashtable;
import java.util.Random;

import static Locator.Locator_CMS.email;

@Listeners(TestListener.class)
public  class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1,testName = "WriteData")
   public void Write_Data(){
        joinPageTest = new joinPage(driver);
       joinPageTest.WriteData();
        LogUtils.info("WriteData_Pass");
   }
    @Test(priority = 2,testName = "Register_Account", dataProvider = "data_Register_Excel", dataProviderClass = DataFactory.class)
    public void verify_Register(Hashtable< String, String> data){
        joinPageTest = new joinPage(driver);
        joinPageTest.register(
                data.get("name"),
                data.get("username"),
                data.get("password"),
                data.get("re_password"),
                data.get("phoneNumber"),
                data.get("brithday")
        );
        LogUtils.info("RegisterPass");
        joinPageTest.verifyRegisterSuccsess();
    }
    @Test(priority = 3,testName = "Click button I am already member")
    public void haveAccountSucess(){
        joinPageTest = new joinPage(driver);
        joinPageTest.registerLogin();
        LogUtils.info("Goto the page Login");
    }
}
