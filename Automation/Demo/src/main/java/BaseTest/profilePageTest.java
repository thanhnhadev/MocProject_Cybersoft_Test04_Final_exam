package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.testng.annotations.Test;
import utils.LogUtils;

public class profilePageTest extends BaseSetup {
    profilePage profilePageTest;
    @Test(priority = 1)
    public void verifyUser(){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login("thanhnhadev@gmail.com","Aty05121995");
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        LogUtils.info("login sucessfully");
        profilePageTest.openPodup("0939018814","jhonNguyen@gmai.com","20/02/2002","male","sahdhu2-dsad2","c#");
    }
    @Test(priority =2)
    public void dataUser(){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login("thanhnhadev@gmail.com","Aty05121995");
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);
        profilePageTest.cardItem("I will write simple and interesting content for your website");
    }
}
