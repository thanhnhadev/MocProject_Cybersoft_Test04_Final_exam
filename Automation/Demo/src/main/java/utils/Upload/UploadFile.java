package utils.Upload;

import utils.Helper.SystemHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {

    public static void uploadWithRobot(String fileName) {
        try {
            // Lấy đường dẫn đầy đủ đến file
            String filePath = SystemHelper.getCurrentDir() + "datatest\\" + fileName;

            // Copy đường dẫn file vào clipboard
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // Khởi tạo Robot
            Robot rb = new Robot();
            rb.setAutoDelay(200); // độ trễ để tránh lỗi tốc độ

            // Nhấn Ctrl + V để dán đường dẫn
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);

            // Nhấn Enter để xác nhận
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
//    WebElement uploadBtn = driver.findElement(By.id("uploadButton"));
//uploadBtn.click(); // Mở hộp thoại upload
//
//// Gọi Robot để upload file
//UploadFile.uploadWithRobot("Selenium4_Upload.jpg");
}
