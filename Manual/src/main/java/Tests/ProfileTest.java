package Tests;

import Base.BaseTest;
import Data.LoginData;
import Pages.LoginPage;
import Pages.ProfilePage;
import Data.ProfileData;
import Locators.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class ProfileTest extends BaseTest {
    private ProfilePage profilePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void init() {
        profilePage = new ProfilePage(page);
        loginPage = new LoginPage(page);
        page.navigate(UrlLocator.LOGIN_URL);
        loginPage.login(LoginData.email, LoginData.password);
        page.waitForTimeout(3000);
        page.navigate(UrlLocator.profilePageUrl);
    }

    @Test
    public void testUpdateProfileWithValidData() {
        profilePage.updateProfile(
                ProfileData.newPhone,
                ProfileData.newUsername,
                ProfileData.newBirthday,
                ProfileData.isMale,
                ProfileData.newCertificate,
                ProfileData.newSkill
        );
        page.waitForTimeout(5000);
        Assert.assertTrue(
                profilePage.verifyInfo(
                        ProfileData.newPhone,
                        ProfileData.newUsername,
                        ProfileData.newBirthday,
                        ProfileData.isMale,
                        ProfileData.newCertificate,
                        ProfileData.newSkill
                ),
                "Thông tin cập nhật không khớp"
        );
    }

    @Test
    public void testUpdateProfileWithNoData() {
        profilePage.updateProfile(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        );
        Assert.assertTrue(profilePage.isSaveButtonDisabled(), "Nút Save phải bị disable khi không thay đổi dữ liệu");
    }

    @Test
    public void testSavingDataAfterCancel() {
        // Điền dữ liệu nhưng không nhấn Save, nhấn Cancel
        profilePage.click(ProfileLocator.editProfile);
        page.fill(ProfileLocator.editName, "Test Cancel");
        page.click(ProfileLocator.btnCancel);

        // Mở lại form kiểm tra dữ liệu cũ không bị đổi
        profilePage.click(ProfileLocator.editProfile);
        String actualName = page.inputValue(ProfileLocator.editName);
        Assert.assertNotEquals(actualName, "Test Cancel", "Cancel không lưu thay đổi");
        page.click(ProfileLocator.btnCancel);
    }
    @Test
    public void testTransferToCreateNewGigPage() {
        profilePage.click(ProfileLocator.createNewGigBtn);
        page.waitForTimeout(3000);
        if(page.locator(ProfileLocator.createNewGigBtn).isEnabled()) {
            Assert.assertTrue(page.url().contains("gig"),"Điều hướng thành công sang trang Create New Gig");
        }else {
            logger.warn("Nút điều hướng bị lỗi");
        }

    }
}
