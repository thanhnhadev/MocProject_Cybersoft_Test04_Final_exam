package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.Logs.LogUtils;
import utils.listeners.TestListener;

import java.util.Hashtable;
@Listeners(TestListener.class)
public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;
    signinPage signinPageTest;
    @Test(priority = 1,testName = "Update_Profile",dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verify_UpdateUser(Hashtable< String, String > data)
    {
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password")
            );
            profilePageTest= new profilePage(driver);
            LogUtils.info("login sucessfully");
            //update profile
            profilePageTest.openPodup();
    }
    @Test(priority =2,testName = "Detail_Items", dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void detail_dataUser(Hashtable< String, String > data){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.Excel,"Login");
        signinPageTest= new signinPage(driver);
        signinPageTest.login(
                data.get("username"),
                data.get("password"));
        profilePageTest= new profilePage(driver);
        profilePageTest.DetailItem(PropertiesHelper.getValue(ConfigData.contentItem));
    }
    @Test(priority =3,testName = "Delete_Items", dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void remove_DataUser(Hashtable< String, String > data){
            ExcelHelper excelHelper = new ExcelHelper();
            excelHelper.setExcelFile(ConfigData.Excel,"Login");
            signinPageTest= new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password")
            );
            profilePageTest= new profilePage(driver);
            profilePageTest.RemoveCartItem(PropertiesHelper.getValue(ConfigData.contentItem2));
    }
}
