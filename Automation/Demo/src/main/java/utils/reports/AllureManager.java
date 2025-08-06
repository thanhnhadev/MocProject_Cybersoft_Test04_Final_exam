package utils.reports;

import Base.BaseSetup;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureManager {

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
//    @Epic
//    @Features
//    @Stories/@Story
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("In this cool test we will check cool thing")
//    @Step
//    @Attachment
//    @Link
    //Screenshot attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
