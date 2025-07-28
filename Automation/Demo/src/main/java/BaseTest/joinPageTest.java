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
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            LogUtils.info("RegisterPass");
            joinPageTest = new joinPage(driver);
            joinPageTest.register(
                    excelHelper.getCellData("name",1),
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1),
                    excelHelper.getCellData("re_password",1),
                    excelHelper.getCellData("phoneNumber",1),
                    excelHelper.getCellData("brithday",1)
            );
            joinPageTest.verifyRegisterSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test(priority = 2)
    public void haveAccountSucess(){
        try {
            LogUtils.info("Goto the page Login");
            joinPageTest = new joinPage(driver);
            joinPageTest.registerLogin();
        }catch (Exception e){
            e.getMessage();
        }
    }

}
