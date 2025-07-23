package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;
//    @Parameters({"email","password"})
    @Test(priority = 1)
    public void verifyLoginSucess(){
        PropertiesHelper.loadAllFiles();
        LogUtils.info("loginPass");
        signinPageTest = new signinPage(driver);
        signinPageTest.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        signinPageTest.verifyLoginSuccsess();
    }
    @Test(priority = 2)
    public void goToPageRester(){
        LogUtils.info("Go to Page Resgiter Pass");
        signinPageTest= new signinPage(driver);
        signinPageTest.loginRegister();
    }
}
