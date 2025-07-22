package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.LogUtils;


public class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Parameters({"name","email","password","re_password","phone","brithday","gender"})
    @Test(priority = 1)
    public void verifyRegisterSucess(String name, String email, String password, String re_password,
                                     String phone, String brithday, String gender){
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register(name,email,password,re_password,phone,brithday,gender);
        joinPageTest.verifyRegisterSuccsess();
    }
    @Test(priority = 2)
    public void haveAccountSucess(){
        LogUtils.info("Goto the page Login Pass");
        joinPageTest = new joinPage(driver);
        joinPageTest.registerLogin();
    }

}
