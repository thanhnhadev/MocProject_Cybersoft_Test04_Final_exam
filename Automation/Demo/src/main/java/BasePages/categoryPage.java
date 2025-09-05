package BasePages;

import BasePages.Components.CategoryNavBar;
import static Base.BaseSetup.sleep;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;

import java.time.Duration;

public class categoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CategoryNavBar categoryNavBar;
    private ActionKeyword actions;

    private By xpathBtn = By.xpath(Locator_CMS.btnHowFiverrWorks);

    public categoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.categoryNavBar = new CategoryNavBar(driver);
        this.actions = new ActionKeyword(driver);
    }

    // verify if navigate correctly to the corresponding category page
    public boolean isAtCategoryPage(String categoryName) {
        String xpath = String.format(Locator_CMS.mostPopularHeading, categoryName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            LogUtils.info("Category page heading found: " + categoryName);
            return true;
        } catch (Exception e) {
            LogUtils.error("Category page heading not found for: " + categoryName);
            return false;
        }
    }

    // click "How Fiverr Works" button
    public void hoverClickFiverrButton() {
        WebElement howFiverrWorksBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(xpathBtn));
        actions.hover(howFiverrWorksBtn);
        sleep(2);
        actions.clickElement(howFiverrWorksBtn);
        sleep(2);

        LogUtils.info("Hover and click Fiverr button!");
    }

    // click a subcategory option
    public void clickSubcategoryOption(String categoryName, String subcategoryName) {
        String subcategoryXpath = String.format(Locator_CMS.subcategoryOption, categoryName, subcategoryName);
        WebElement subOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(subcategoryXpath))
        );
        actions.scrollToElement(subOption);
        sleep(2);
        wait.until(ExpectedConditions.elementToBeClickable(subOption)); // chờ clickable
        subOption.click();

        LogUtils.info("Clicked subcategory: " + subcategoryName + " in " + categoryName);
    }

}
