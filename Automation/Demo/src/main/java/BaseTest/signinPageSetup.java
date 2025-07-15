package BaseTest;


import Base.BaseSetup;

public class signinPageSetup extends BaseSetup {

    public static void main(String[] args) {
        createBrowser();
        driver.get("https://demo5.cybersoft.edu.vn/");

        closeBrowser();
    }
}
