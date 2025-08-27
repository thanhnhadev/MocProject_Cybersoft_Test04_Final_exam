// File: src/main/java/Pages/RegisterPage.java
package Pages;

import Base.BasePage;
import com.microsoft.playwright.Page;
import Locators.*;

public class RegisterPage extends BasePage {
    public RegisterPage(Page page) {
        super(page);
    }

    public void register(String name, String email, String password, String confirmPass, String phone, String daybirth, String monthbirth, String yearbirth, boolean isMale, boolean isConfirm) {
        navigate(UrlLocator.registerPageUrl);
        fill(RegisterLocator.ipUser, name);
        fill(RegisterLocator.ipMail, email);
        fill(RegisterLocator.ipPw, password);
        fill(RegisterLocator.ipRpw, confirmPass);
        fill(RegisterLocator.ipPhone, phone);

        // === Birthday field debug ===
        try {
            click(RegisterLocator.ipBrithday);

            // Một số date picker không cho nhập từng phần. Thử nhập toàn bộ chuỗi ddmmyyyy.
            String birthday = daybirth + monthbirth + yearbirth;
            page.locator(RegisterLocator.ipBrithday).fill(birthday);

            String actual = page.inputValue(RegisterLocator.ipBrithday);
            if (!birthday.equals(actual)) {
                logger.warn("[Bug] Birthday input không nhận giá trị. Expected=" + birthday + " | Actual=" + actual);
            } else {
                logger.info("Birthday input set thành công: " + actual);
            }
        } catch (Exception e) {
            logger.error("[Bug] Không thể thao tác với birthday input. Locator=" + RegisterLocator.ipBrithday + " | Error=" + e.getMessage());
            // không throw để test vẫn có thể tiếp tục kiểm tra các phần khác nếu cần
        }

        if (isMale) {
            click(RegisterLocator.opionMale);
        } else {
            click(RegisterLocator.opionFemale);
        }
        if (isConfirm) {
            click(RegisterLocator.cbox_agreeitem);
        }
        click(RegisterLocator.btnSubmit);
    }


    public void transferToLoginPage() {
        navigate(UrlLocator.registerPageUrl);
        click(RegisterLocator.aLogin);
    }
}