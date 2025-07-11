package BaseTest;

import Base.BaseSetup;
import BasePages.LoginPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class loginTest extends BaseSetup {
    LoginPage loginPage;
    @Test
    public void testLoginSucess(){
        LogUtils.info("sucess fully");
        loginPage= new LoginPage(driver);
        loginPage.login("thanhnhadev@gmail.com","Aty05121995");
        loginPage.verifyLoginSuccsess();

    }


}
