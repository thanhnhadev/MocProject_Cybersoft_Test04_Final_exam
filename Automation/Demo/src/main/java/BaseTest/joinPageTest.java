package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;


public class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1)
    public void verifyRegisterSucess(){
        PropertiesHelper.setFile("src/main/java/utils/Config/file1.properties");
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register(
                PropertiesHelper.getValue("name"),PropertiesHelper.getValue("email"),
                PropertiesHelper.getValue("password"),PropertiesHelper.getValue("re_password"),
                PropertiesHelper.getValue("phone"),PropertiesHelper.getValue("brithday"),
                PropertiesHelper.getValue("gender"));
        joinPageTest.verifyRegisterSuccsess();
    }
    @Test(priority = 2)
    public void haveAccountSucess(){
        LogUtils.info("Goto the page Login Pass");
        joinPageTest = new joinPage(driver);
        joinPageTest.registerLogin();
    }

}
