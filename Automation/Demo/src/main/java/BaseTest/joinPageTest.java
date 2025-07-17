package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1)
    public void verifyRegisterSucess(){
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register("thanhnha","nhanguyen051295@gmail.com","1234567890","1234567890","123456789","11/02/2021","Male");
        joinPageTest.verifyRegisterSuccsess();
    }
}
