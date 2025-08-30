package BasePages;

import BasePages.Components.CategoryNavBar;
import Locator.Locator_CMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Constants.ConfigData;
import utils.Logs.LogUtils;

import java.time.Duration;

import utils.ActionKeyword.ActionKeyword;

public class categoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CategoryNavBar categoryNavBar;
    private ActionKeyword actions;

    private By popularServices = By.xpath(Locator_CMS.popularServiceTitle);

    public categoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.categoryNavBar = new CategoryNavBar(driver);
        this.actions = new ActionKeyword(driver);
    }

//    public categoryPage navigateToCategoryPage() {
//        LogUtils.info("Starting navigation to category page from Homepage:");
//
//        driver.get(ConfigData.base_url);
//        LogUtils.info("Navigated to browse page: " + ConfigData.base_url);
//
//        // scroll down to see the category nav bar
//        WebElement heading = driver.findElement(popularServices);
//        actions.scrollToElement(heading);
//        LogUtils.info("Scrolled to Popular professional services section.");
//
//        categoryNavBar.navigateToCategory();
//        actions.scrollToTop();
//
//        LogUtils.info("Successfully navigated to Graphics & Design category");
//
//        return this;
//    }

    public categoryPage navigateToCategoryPage(String categoryXpath) {
        LogUtils.info("Starting navigation to category page from Homepage:");

        driver.get(ConfigData.base_url);
        LogUtils.info("Navigated to browse page: " + ConfigData.base_url);

        // scroll down to see the category nav bar
        WebElement heading = driver.findElement(popularServices);
        actions.scrollToElement(heading);
        LogUtils.info("Scrolled to Popular professional services section.");

        categoryNavBar.navigateToCategory(categoryXpath);
        actions.scrollToTop();

        LogUtils.info("Successfully navigated to Graphics & Design category");

        return this;
    }

    public boolean isAtGraphicsDesignPage(String categoryHeaderText) {
        String xpath = String.format("//h1[normalize-space()='Most popular in %s']", categoryHeaderText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))) != null;
    }

}
