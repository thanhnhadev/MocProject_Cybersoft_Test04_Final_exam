package BaseTest;


import Base.BaseSetup;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Constants.DataFactory;
import utils.Helper.ExcelHelper;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

import java.util.Hashtable;

public class signinPageTest extends BaseSetup {
    signinPage signinPageTest;

    @Test(priority = 1, dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginSucess(Hashtable< String, String > data){
        try {
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
            signinPageTest.verifyLoginSuccsess();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test (priority = 2,  dataProvider = "data_Login_Excel", dataProviderClass = DataFactory.class)
    public void verifyLoginFail(Hashtable< String, String > data){
        try {
            signinPageTest = new signinPage(driver);
            signinPageTest.login(
                    data.get("username"),
                    data.get("password"));
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
