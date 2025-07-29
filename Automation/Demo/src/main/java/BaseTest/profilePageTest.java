package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

import java.util.Hashtable;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;
    signinPage signinPageTest;

    @Test(priority = 1,dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyUser(Hashtable< String, String > data)
    {
        try {
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password")
            );
            sleep(2);
            profilePageTest= new profilePage(driver);
            LogUtils.info("login sucessfully");
            profilePageTest.openPodup();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test(priority =2,dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void dataUser(Hashtable< String, String > data){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password")
            );
            sleep(2);
            profilePageTest= new profilePage(driver);
            profilePageTest.RemoveCartItem(PropertiesHelper.getValue(ConfigData.contentItem));
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test(priority =3,dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void detaildataUser(Hashtable< String, String > data){
        try {
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
            profilePageTest= new profilePage(driver);
            profilePageTest.DetailItem(PropertiesHelper.getValue(ConfigData.contentItem01));
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
