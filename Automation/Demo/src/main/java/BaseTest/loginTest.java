package BaseTest;

import Base.BaseSetup;
import BasePages.LoginPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class loginTest extends BaseSetup {
    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSucess(){
        createBrowser("chrome");
        LogUtils.info("sucess fully");
        loginPage= new LoginPage(driver);
        loginPage.login("thanhnhadev@gmail.com","Aty05121995");
        loginPage.verifyLoginSuccsess();
    }
    @Test(priority = 2)
    public void testLoginFail(){
        createBrowser("chrome");
        LogUtils.info(" login faile");
        loginPage= new LoginPage(driver);
        loginPage.login("thanhnhadev@gmail.com.vn","Aty05121995");
        loginPage.verifyLoginSuccsess();
    }

}
