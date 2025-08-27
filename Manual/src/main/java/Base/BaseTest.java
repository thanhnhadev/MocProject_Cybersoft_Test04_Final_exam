package Base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.Arrays;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass
    public void setupBrowser() {
        logger.info("=== Khởi tạo Browser (chung cho toàn bộ class) ===");
        playwright = Playwright.create();

        try {
            // Ưu tiên Chromium và mở full màn hình
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setArgs(Arrays.asList(new String[]{"--start-maximized"}))
            );
            logger.info("Khởi tạo Chromium thành công");
        } catch (Exception e1) {
            try {
                // Firefox không hỗ trợ start-maximized
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                );
                logger.info("Khởi tạo Firefox thành công");
            } catch (Exception e2) {
                // WebKit fallback
                browser = playwright.webkit().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                );
                logger.info("Khởi tạo WebKit thành công");
            }
        }
    }

    @BeforeMethod
    public void setupContextAndPage() {
        logger.info("=== Tạo context + page mới cho mỗi test ===");

        // Lấy kích thước màn hình hệ thống
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Tạo context với viewport khớp kích thước màn hình
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(width, height)
                .setLocale("en-US")
        );
        page = context.newPage();
        page.setDefaultTimeout(30000); // Timeout mặc định cho page

        // Tối đa hóa cửa sổ trình duyệt bằng JavaScript (cho Firefox/WebKit)
        try {
            page.evaluate("() => window.moveTo(0, 0); window.resizeTo(screen.width, screen.height);");
            logger.info("Tối đa hóa cửa sổ trình duyệt thành công");
        } catch (Exception e) {
            logger.warn("Không thể tối đa hóa cửa sổ bằng JavaScript: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDownContext() {
        logger.info("=== Đóng context sau mỗi test ===");
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    public void tearDownBrowser() {
        logger.info("=== Đóng Browser & Playwright khi kết thúc class ===");
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}