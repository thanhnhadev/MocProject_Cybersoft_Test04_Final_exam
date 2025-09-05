package BasePages.Components;

import BasePages.Components.Header;
import BasePages.categoryPage;
import Locator.Locator_CMS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import utils.Logs.LogUtils;

import java.time.Duration;

public class CategoryNavBar {
    private WebDriver driver;
    private WebDriverWait wait;
    private ActionKeyword actions;

    private Header header;

    public CategoryNavBar(WebDriver driver) {
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new ActionKeyword(driver);
        this.header = new Header(driver);
    }

    public categoryPage navigateToCategory(String categoryXpath){
        By locator = By.xpath(categoryXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement option = driver.findElement(locator);
        option.getText();
        actions.clickElement(option);
        header.hoverFiverrBusiness(); // to make dropdown menu disappear
        return new categoryPage(driver);
    }
}
