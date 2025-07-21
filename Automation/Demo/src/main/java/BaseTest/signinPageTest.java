package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;
    @Test(priority = 1)
    public void verifyLoginSucess(){
        LogUtils.info("loginPass");
        signinPageTest = new signinPage(driver);
        signinPageTest.login("","");
        signinPageTest.verifyLoginSuccsess();
    }
    @Test(priority = 2)
    public void goToPageRester(){
        LogUtils.info("Go to Page Resgiter Pass");
        signinPageTest= new signinPage(driver);
        signinPageTest.loginRegister();
    }
}
