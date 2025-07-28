package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;
    signinPage signinPageTest;

    @Test(priority = 1)
    public void verifyUser()
    {
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1)
            );
            sleep(2);
            profilePageTest= new profilePage(driver);
            LogUtils.info("login sucessfully");
            profilePageTest.openPodup();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test(priority =2)
    public void dataUser(){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1)
            );
            sleep(2);
            profilePageTest= new profilePage(driver);
            profilePageTest.RemoveCartItem(PropertiesHelper.getValue(ConfigData.contentItem));
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test(priority =3)
    public void detaildataUser(){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    excelHelper.getCellData("username",1),
                    excelHelper.getCellData("password",1));
            sleep(2);
            profilePageTest= new profilePage(driver);
            profilePageTest.DetailItem(PropertiesHelper.getValue(ConfigData.contentItem01));
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
