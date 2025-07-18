package BasePages.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private WebDriver _driver;
    private WebDriverWait wait;
    public Header(WebDriver driver) {
        this._driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }




}
