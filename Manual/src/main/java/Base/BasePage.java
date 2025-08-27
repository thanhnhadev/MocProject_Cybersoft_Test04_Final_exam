// File: src/main/java/Base/BasePage.java
package Base;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected Page page;
    protected final Logger logger = LogManager.getLogger(this.getClass());

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void click(String locator) {
        page.locator(locator).click();
    }

    public void fill(String locator, String text) {
        page.locator(locator).fill(text);
    }
}