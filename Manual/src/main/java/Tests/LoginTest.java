package Tests;

import Base.BaseTest;
import Data.LoginData;
import Locators.LoginLocator;
import Locators.UrlLocator;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(page);
        page.navigate(UrlLocator.LOGIN_URL);
    }

    @Test
    public void testLoginWithValidData() {
        loginPage.login(LoginData.email, LoginData.password);
        page.waitForTimeout(5000);
        page.navigate(UrlLocator.profilePageUrl);

        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.contains("profile"), "Đăng nhập thành công");
    }

    @Test
    public void testLoginWithWrongData() {
        loginPage.login(LoginData.wrongEmail, LoginData.wrongPassword);
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator(LoginLocator.loginFailedNotification).isVisible(), "Đăng nhập thất bại có hiện thông báo lỗi");
    }

    @Test
    public void testLoginWithNoData() {
        loginPage.login("", "");
        page.waitForTimeout(3000);

        boolean isEmailEmptyErrorVisible = page.locator(LoginLocator.emailEmptyNotification).isVisible();
        boolean isPasswordEmptyErrorVisible = page.locator(LoginLocator.passwordEmptyNotification).isVisible();

        Assert.assertTrue(isEmailEmptyErrorVisible, "Thông báo 'Email không được bỏ trống !' phải hiển thị");
        Assert.assertTrue(isPasswordEmptyErrorVisible, "Thông báo 'Password không được bỏ trống !' phải hiển thị");
    }

    @Test
    public void testLoginWithInvalidData() {
        loginPage.login(LoginData.invalidEmail, LoginData.invalidPassword);
        page.waitForTimeout(3000);

        boolean isEmailInvalidErrorVisible = page.locator(LoginLocator.emailInvalidNotification).isVisible();
        boolean isPasswordInvalidErrorVisible = page.locator(LoginLocator.passwordInvalidNotification).isVisible();

        Assert.assertTrue(isEmailInvalidErrorVisible, "Thông báo 'Email không đúng định dạng !' phải hiển thị");
        Assert.assertTrue(isPasswordInvalidErrorVisible, "Thông báo 'pass từ 6 - 32 ký tự !' phải hiển thị");
    }

    @Test
    public void testLoginWithMultipleTimesWrongData() {
        for (int i = 0; i < (LoginData.wrongTimes); i++) {
            loginPage.login(LoginData.wrongEmail, LoginData.wrongPassword);
            page.waitForTimeout(3000);
            Assert.assertTrue(page.locator(LoginLocator.loginFailedNotification).isVisible(), "Lần " + (i + 3) + ": Thông báo đăng nhập thất bại phải hiển thị");
        }

        // Kiểm tra chuyển hướng về trang chủ
        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.equals("https://demo5.cybersoft.edu.vn/"), "Sau " + LoginData.wrongTimes + " lần sai, chuyển về trang chủ");
    }

    @Test
    public void testUnseenPassword() {
        page.fill(LoginLocator.password, LoginData.password);

        // Ban đầu phải là type="password"
        String typeBefore = page.getAttribute(LoginLocator.password, "type");
        Assert.assertEquals(typeBefore, "password", "Mặc định ô password phải là type=password");

        // Click nút eye icon
        page.click(LoginLocator.unseenPasswordBtn);

        // Sau khi click phải là type="text"
        String typeAfter = page.getAttribute(LoginLocator.password, "type");
        Assert.assertEquals(typeAfter, "text", "Sau khi click, mật khẩu phải hiển thị (type=text)");

        // Click lần nữa để ẩn lại
        page.click(LoginLocator.unseenPasswordBtn);
        String typeAfter2 = page.getAttribute(LoginLocator.password, "type");
        Assert.assertEquals(typeAfter2, "password", "Sau khi click lại, mật khẩu phải ẩn (type=password)");
    }

    @Test
    public void testTransferToRegisterPage() {
        loginPage.transferToRegisterPage();

        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.contains("register"), "Đã điều hướng thành công đến trang đăng kí");
    }

    @Test
    public void testTransferToLoginPageByUser() {
        loginPage.login(LoginData.email, LoginData.password);
        page.waitForTimeout(5000);
        loginPage.navigate(UrlLocator.LOGIN_URL);
        Assert.assertFalse(page.locator(LoginLocator.lbsigninTitle).isVisible(),"Vẫn truy cập vào trang Login dù đang trong session đăng nhập");

    }
}