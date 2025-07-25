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

    @Test(priority = 1)
    public void verifyUser()
    {
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        LogUtils.info("login sucessfully");
        profilePageTest.openPodup();
    }

    @Test(priority =2)
    public void dataUser(){
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        profilePageTest.RemoveCartItem(PropertiesHelper.getValue(ConfigData.contentItem));
    }

    @Test(priority =3)
    public void detaildataUser(){
        signinPageTest= new signinPage(driver);
        signinPageTest.login();
        sleep(2);
        profilePageTest= new profilePage(driver);
        profilePageTest.DetailItem(PropertiesHelper.getValue(ConfigData.contentItem01));
    }

}
