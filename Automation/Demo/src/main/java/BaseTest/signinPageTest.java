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
        try {
            LogUtils.info("loginPass");
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1)
            );
            signinPageTest.verifyLoginSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test (priority = 2)
    public void verifyLoginFail(){
        try {
            LogUtils.info("loginFail");
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1)
            );
            signinPageTest.verifyLoginSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test(priority = 3)
    public void goToPageRester(){
        try {
            LogUtils.info("Go to Page Resgiter Pass");
            signinPageTest= new signinPage(driver);
            signinPageTest.loginRegister();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
