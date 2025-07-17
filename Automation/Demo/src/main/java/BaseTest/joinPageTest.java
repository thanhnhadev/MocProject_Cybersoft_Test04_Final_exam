package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import BasePages.signinPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1)
    public void verifyRegisterSucess(){
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register("","","","","");
        joinPageTest.verifyRegisterSuccsess();
    }
}
