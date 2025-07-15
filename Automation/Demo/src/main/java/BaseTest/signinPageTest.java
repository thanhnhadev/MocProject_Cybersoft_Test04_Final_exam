package BaseTest;


import Base.BaseTest;

public class signinPageTest extends BaseTest {

    public static void main(String[] args) {
        createBrowser();
        driver.get("https://demo5.cybersoft.edu.vn/");

        closeBrowser();
    }
}
