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

import java.util.Hashtable;
import java.util.Random;

import static Locator.Locator_CMS.email;

@Listeners(TestListener.class)
public  class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1,testName = "Register_Account", dataProvider = "data_Register_Excel", dataProviderClass = DataFactory.class)
    public void verifyRegister(Hashtable< String, String> data){
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register(
                data.get("name"),
                data.get("username"),
                data.get("password"),
                data.get("re_password"),
                data.get("phoneNumber"),
                data.get("brithday")
        );
        joinPageTest.verifyRegisterSuccsess();
    }
    @Test(priority = 2)
    public void haveAccountSucess(){
            LogUtils.info("Goto the page Login");
            joinPageTest = new joinPage(driver);
            joinPageTest.registerLogin();
    }
}
