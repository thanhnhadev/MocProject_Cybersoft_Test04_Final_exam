package BaseTest;

import Base.BaseSetup;
import BasePages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LogUtils;
import utils.listeners.SimpleListener;

@Listeners(SimpleListener.class)
public class loginTest extends BaseSetup {
    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSucess(){
        createBrowser("chrome");
        LogUtils.info("sucess fully");

    }
    @Test(priority = 2)
    public void testLoginFail(){
        createBrowser("chrome");
        LogUtils.info(" login faile");

    }

}
