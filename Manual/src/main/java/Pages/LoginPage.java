package Pages;

import Base.BasePage;
import Locators.*;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }

    public void unseenPassword(String password) {
        navigate(UrlLocator.LOGIN_URL);
        fill(LoginLocator.password, password);
        click(LoginLocator.unseenPasswordBtn);
    }

    public void login(String email, String password) {
        fill(LoginLocator.email, email);
        page.waitForTimeout(1000);
        fill(LoginLocator.password, password);
        page.waitForTimeout(1000);
        click(LoginLocator.btnLogin);
    }

    public void transferToRegisterPage() {
        navigate(UrlLocator.LOGIN_URL);
        click(LoginLocator.aResgister);
    }
}
