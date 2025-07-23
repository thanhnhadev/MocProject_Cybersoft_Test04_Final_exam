package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Helper.PropertiesHelper;
import utils.LogUtils;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;

//    @Parameters({"email","password","phoneNumber","editEmail","birthday","gender","certificate","skill"})
    @Test(priority = 1)
    public void verifyUser()
    {
        PropertiesHelper.loadAllFiles();
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(
                PropertiesHelper.getValue("email"),
                PropertiesHelper.getValue("password"));
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        LogUtils.info("login sucessfully");
        profilePageTest.openPodup(
                PropertiesHelper.getValue("phone"),
                PropertiesHelper.getValue("email"),
                PropertiesHelper.getValue("brithday"),
                PropertiesHelper.getValue("gender"),
                PropertiesHelper.getValue("certificate"),
                PropertiesHelper.getValue("skill")
        );
    }
//    @Parameters({"email","password","context1"})
    @Test(priority =2)
    public void dataUser(){
        PropertiesHelper.loadAllFiles();
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(
                PropertiesHelper.getValue("email"),
                PropertiesHelper.getValue("password")
        );
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        profilePageTest.RemovecardItem(PropertiesHelper.getValue("context1"));
    }
//    @Parameters({"email","password","context2"})
    @Test(priority =3)
    public void detaildataUser(){
        PropertiesHelper.loadAllFiles();
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(
                PropertiesHelper.getValue("email"),
                PropertiesHelper.getValue("password")
        );
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        profilePageTest.DetailcardItem(PropertiesHelper.getValue("context2"));
    }
}
