package BaseTest;

import Base.BaseSetup;
import BasePages.profilePage;
import BasePages.signinPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class profilePageTest extends BaseSetup {

    @Test(priority = 1)
    public void verifyUser(){
        signinPage signinPageTest= new signinPage(driver);
        signinPageTest.login("","");
        sleep(2);
        profilePage profilePageTest= new profilePage(driver);

    }
}
