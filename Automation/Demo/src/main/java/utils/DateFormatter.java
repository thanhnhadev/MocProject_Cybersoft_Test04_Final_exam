package utils;

import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DateFormatter {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator cho ô nhập ngày
    private By datetime = By.xpath(Locator_CMS.ipBrithday); // Cập nhật ID theo trang web của bạn

    // Constructor
    public DateFormatter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Nhập ngày vào ô input và in ra ngày đã format
     * @param datetimes - chuỗi ngày đầu vào (ví dụ: "28-07-2025")
     */
    public void datePicker(String datetimes) {
        // Chờ ô nhập ngày hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(datetime));

        // Lấy phần tử input
        WebElement dateInput = driver.findElement(datetime);

        // Xóa nội dung cũ và nhập ngày mới
        dateInput.clear();
        dateInput.sendKeys(datetimes);

        // Format ngày từ định dạng dd-MM-yyyy sang yyyy/MM/dd
        String formattedDate = formatDate(datetimes, "dd-mm-yyyy", "yyyy/MM/dd");

        if (formattedDate != null) {
            System.out.println("Ngày sau khi format: " + formattedDate);
        } else {
            System.out.println("Định dạng ngày không hợp lệ!");
        }
    }

    /**
     * Hàm format ngày tháng từ định dạng này sang định dạng khác
     */
    public String formatDate(String inputDate, String currentFormat, String expectedFormat) {
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat(currentFormat);
            SimpleDateFormat targetFormat = new SimpleDateFormat(expectedFormat);
            Date date = originalFormat.parse(inputDate);
            return targetFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
