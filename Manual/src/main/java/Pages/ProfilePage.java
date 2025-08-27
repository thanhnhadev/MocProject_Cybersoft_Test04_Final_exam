package Pages;

import Base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import Locators.ProfileLocator;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfilePage extends BasePage {
    public ProfilePage(Page page) {
        super(page);
    }

    // Hàm update profile
    public void updateProfile(
            Optional<String> newPhone,
            Optional<String> newName,
            Optional<String> newBirthday,
            Optional<Boolean> isMale,
            Optional<String> certificate,
            Optional<String> skill
    ) {
        click(ProfileLocator.editProfile);
        page.waitForTimeout(3000);
        AtomicBoolean hasUpdate = new AtomicBoolean(false);

        newPhone.ifPresent(phone -> {
            fill(ProfileLocator.editPhoneNumber, phone);
            hasUpdate.set(true);
        });

        newName.ifPresent(name -> {
            fill(ProfileLocator.editName, name);
            hasUpdate.set(true);
        });

        newBirthday.ifPresent(birthday -> {
            fill(ProfileLocator.editBirthday, birthday);
            hasUpdate.set(true);
        });

        isMale.ifPresent(male -> {
            click(male ? ProfileLocator.optionMale : ProfileLocator.optionFemale);
            hasUpdate.set(true);
        });

        certificate.ifPresent(cer -> {
            fill(ProfileLocator.editCetificate, cer);
            hasUpdate.set(true);
        });

        skill.ifPresent(sk -> {
            fill(ProfileLocator.editSkill, sk);
            hasUpdate.set(true);
        });

        if (hasUpdate.get()) {
            click(ProfileLocator.btnSave);
        }
    }

    // Hàm điều hướng sang trang Create New Gig
    public void transferToCreateNewGig() {
        click(ProfileLocator.createNewGigBtn);
    }

    // Hàm verify thông tin hiển thị (so sánh với expected data)
    public boolean verifyInfo(
            Optional<String> expectedPhone,
            Optional<String> expectedName,
            Optional<String> expectedBirthday,
            Optional<Boolean> expectedIsMale,
            Optional<String> expectedCertificate,
            Optional<String> expectedSkill
    ) {
        boolean ok = true;
        click(ProfileLocator.editProfile);
        page.waitForTimeout(3000);

        if (expectedPhone.isPresent()) {
            String actual = page.inputValue(ProfileLocator.editPhoneNumber);
            ok = ok && actual.equals(expectedPhone.get());
        }
        if (expectedName.isPresent()) {
            String actual = page.inputValue(ProfileLocator.editName);
            ok = ok && actual.equals(expectedName.get());
        }
        if (expectedBirthday.isPresent()) {
            String actual = page.inputValue(ProfileLocator.editBirthday);
            ok = ok && actual.equals(expectedBirthday.get());
        }
        if (expectedIsMale.isPresent()) {
            String selectedLocator = expectedIsMale.get() ? ProfileLocator.optionMale : ProfileLocator.optionFemale;
            ok = ok && page.locator(selectedLocator).isChecked();
        }
        if (expectedCertificate.isPresent()) {
            String actual = page.inputValue(ProfileLocator.editCetificate);
            ok = ok && actual.equals(expectedCertificate.get());
        }
        if (expectedSkill.isPresent()) {
            String actual = page.inputValue(ProfileLocator.editSkill);
            ok = ok && actual.equals(expectedSkill.get());
        }
        return ok;
    }

    // Kiểm tra item theo h1, đảm bảo không có trùng lặp
    public boolean verifyItemInProfile(String searchItem) {
        // lấy tất cả locator h1 trong item
        Locator items = page.locator(ProfileLocator.item + "//h1[text()='"+searchItem+"']");
        int count = items.count();

        if (count == 0) {
            logger.warn("Không có sản phẩm nào.");
            return false;
        }

        // nếu chỉ có 1 item => coi như thành công
        if (count == 1) {
            logger.info("sản phẩm đã có trong giỏ hàng");
            return true;
        }

        // nếu có nhiều hơn 1, kiểm tra trùng lặp text
        java.util.Set<String> titles = new java.util.HashSet<>();
        for (int i = 0; i < count; i++) {
            String title = items.nth(i).innerText().trim();
            if (!titles.add(title)) {
                logger.error("Phát hiện sản phẩm trùng lặp: " + title);
                return false;
            }
        }

        logger.info("Tất cả sản phẩm đều có tiêu đề h1 duy nhất.");
        return true;
    }


    // Kiểm tra xem nút Save có bị disable không
    public boolean isSaveButtonDisabled() {
        return page.locator(ProfileLocator.btnSave).isDisabled();
    }
}
