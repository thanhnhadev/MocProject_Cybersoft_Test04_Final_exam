package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;
    @Test(priority = 1)
    public void verifyLoginSucess(){
        LogUtils.info("loginPass");
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.Excel,"Sheet1");
        signinPageTest = new signinPage(driver);
        signinPageTest.login(
                excelHelper.getCellData("username",1),
                excelHelper.getCellData("password",1)
        );
        signinPageTest.verifyLoginSuccsess();
    }
    @Test(priority = 2)
    public void goToPageRester(){
        LogUtils.info("Go to Page Resgiter Pass");
        signinPageTest= new signinPage(driver);
        signinPageTest.loginRegister();
    }
}
