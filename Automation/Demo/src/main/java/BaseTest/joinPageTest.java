package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;


public class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1)
    public void verifyRegisterSucess(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.Excel,"Register");
        LogUtils.info("RegisterPass");
        joinPageTest = new joinPage(driver);
        joinPageTest.register();
        joinPageTest.verifyRegisterSuccsess();
    }
    @Test(priority = 2)
    public void haveAccountSucess(){
        LogUtils.info("Goto the page Login Pass");
        joinPageTest = new joinPage(driver);
        joinPageTest.registerLogin();
    }

}
