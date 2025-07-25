package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Constants.ConfigData;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;
    signinPage signinPageTest;
//    @Parameters({"email","password","phoneNumber","editEmail","birthday","gender","certificate","skill"})
    @Test(priority = 1)
    public void verifyUser()
    {
        PropertiesHelper.loadAllFiles();
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        LogUtils.info("login sucessfully");
        profilePageTest.openPodup();
    }
    @Parameters({"context1"})
    @Test(priority =2)
    public void dataUser(){
        PropertiesHelper.loadAllFiles();
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        profilePageTest.RemoveCartItem(PropertiesHelper.getValue(ConfigData.contentItem));
    }
    @Parameters({"context2"})
    @Test(priority =3)
    public void detaildataUser(){
        PropertiesHelper.loadAllFiles();
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        profilePageTest.DetailItem(PropertiesHelper.getValue(ConfigData.contentItem01));
    }
}
