package utils.reports;

import Base.BaseSetup;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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
    public void allureVideo() {
        try {
            byte[] byteArr = IOUtils.toByteArray(new FileInputStream("reports/video_records/videoplayback.mp4"));
            Allure.addAttachment("attachment name", "video/mp4", new ByteArrayInputStream(byteArr), "mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
