package Pages;

import Base.BasePage;
import com.microsoft.playwright.Page;
import Data.*;
import Locators.*;
import Pages.*;

public class DetailPage extends BasePage {
    public DetailPage(Page page, String baseUrl) {
        super(page);
    }

    public void chooseAccountStatus(boolean status) {
        if (status) {
            navigate(UrlLocator.LOGIN_URL);
            LoginPage loginPage = new LoginPage(page);
            loginPage.login(LoginData.email, LoginData.password);
            navigate(UrlLocator.detailPageUrl);
        } else {
            navigate(UrlLocator.detailPageUrl);
        }
    }

    public void chooseLevel(String expectLevel) {
        if (expectLevel.toLowerCase().equals("basic")) {
        } else if (expectLevel.toLowerCase().equals("standard")) {
            click(DetailLocator.standardLevel);
        } else if (expectLevel.toLowerCase().equals("premium")) {
            click(DetailLocator.premiumPrice);
        }
    }

    public void buyProductByUser(String level) {
        this.chooseAccountStatus(true);
        String nameProduct = page.locator(DetailLocator.detailTitle).innerText().trim();
        chooseLevel(level);
        click(DetailLocator.continuteButton);
        page.waitForTimeout(3000);
        page.navigate(UrlLocator.profilePageUrl);
        ProfilePage profilePage  = new ProfilePage(page);
        profilePage.verifyItemInProfile(nameProduct);
    }

    public void compareProduct() {
        this.chooseAccountStatus(true);
        navigate(UrlLocator.detailPageUrl);
        click(DetailLocator.compareButton);
    }

    public void comment(String think, float ratingStar) {
        this.chooseAccountStatus(true);
        fill(DetailLocator.commentTextBox, think);
        click(DetailLocator.commentButton);


    }

}
