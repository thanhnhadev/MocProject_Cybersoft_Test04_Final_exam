package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.LogUtils;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;

    @Parameters({"email","password","phoneNumber","editEmail","birthday","gender","certificate","skill"})
    @Test(priority = 1)
    public void verifyUser(String email, String password,String phoneNumber,
                           String editEmail,String birthday, String gender,
                           String certificate, String skill  ){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(email,password);
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        LogUtils.info("login sucessfully");
        profilePageTest.openPodup(phoneNumber,editEmail,birthday,gender,certificate,skill);
    }
    @Parameters({"email","password","context1"})
    @Test(priority =2)
    public void dataUser(String email, String password,String context1){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(email,password);
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        profilePageTest.RemovecardItem(context1);
    }
    @Parameters({"email","password","context2"})
    @Test(priority =3)
    public void detaildataUser(String email, String password,String context2){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login(email,password);
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        profilePageTest.DetailcardItem(context2);
    }
}
