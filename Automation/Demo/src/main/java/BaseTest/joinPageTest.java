package BaseTest;

import Base.BaseSetup;
import BasePages.joinPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Helper.ExcelHelper;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;

import java.util.Hashtable;

@Listeners(TestListener.class)
public  class joinPageTest extends BaseSetup {
    joinPage joinPageTest;
    @Test(priority = 1,dataProvider = "data_Register_Excel", dataProviderClass = DataFactory.class)
    public void verifyRegisterSucess(Hashtable< String, String> data){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
//            LogUtils.info("RegisterPass");
            joinPageTest = new joinPage(driver);
            excelHelper.setCellData("thanhnhav@gmail.com", 0, 1);
            excelHelper.setCellData("Aty05121995", 1, 1);
            excelHelper.setCellData("Aty05121995", 3, 1);
            excelHelper.setCellData("tynguyen", 2, 1);
            excelHelper.setCellData("0912345678", 4, 1);
            excelHelper.setCellData("22112014", 5, 1);
            LogUtils.info("Write Data Successfully");
            joinPageTest.register(
                    data.get("name"),
                    data.get("username"),
                    data.get("password"),
                    data.get("re_password"),
                    data.get("phoneNumber"),
                    data.get("brithday")
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
