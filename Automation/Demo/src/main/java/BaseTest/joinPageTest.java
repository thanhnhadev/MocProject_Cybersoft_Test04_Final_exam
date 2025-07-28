package BaseTest;

import Base.BaseSetup;
import BasePages.HomePage;
import BasePages.joinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;


public  class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1)
    public void verifyRegisterSucess(){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            LogUtils.info("RegisterPass");
            joinPageTest = new joinPage(driver);
            excelHelper.setCellData("thanhnhav@gmail.com", 0, 1);
            sleep(2);
            excelHelper.setCellData("Aty05121995", 1, 1);
            sleep(2);
            excelHelper.setCellData("Aty05121995", 3, 1);
            sleep(2);
            excelHelper.setCellData("tynguyen95", 2, 1);
            sleep(2);
            excelHelper.setCellData("0912345678", 4, 1);
            sleep(2);
            excelHelper.setCellData("22/11/2014", 5, 1);
            sleep(2);
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
