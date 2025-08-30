package BasePages.Components;

import BasePages.categoryPage;
import Locator.Locator_CMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import utils.Logs.LogUtils;

import java.time.Duration;

public class CategoryNavBar {
    private WebDriver driver;
    private WebDriverWait wait;
    private ActionKeyword actions;

    // category
//    private By GraphicsDesign= By.xpath(Locator_CMS.GraphicsDesign);
//    private By DigitalMarketing= By.xpath(Locator_CMS.DigitalMarketing);
//    private By WritingTranslation= By.xpath(Locator_CMS.WritingTranslation);
//    private By Video_Animation= By.xpath(Locator_CMS.Video_Animation);
//    private By Music_Audio= By.xpath(Locator_CMS.Music_Audio);
//    private By Testing= By.xpath(Locator_CMS.Testing);

    // subcategory
    private By LogoDesign_submenu = By.xpath(Locator_CMS.LogoDesign);

    public CategoryNavBar(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new ActionKeyword(driver);
    }

    public categoryPage navigateToCategory(String categoryXpath){
        By locator = By.xpath(categoryXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement option = driver.findElement(locator);
        option.getText();
        actions.clickElement(option);

        LogUtils.info("Navigated to category: " + categoryXpath);
        return new categoryPage(driver);
    }

//    public void nav_GraphicsDesign_LogoDesign(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(GraphicsDesign));
//        ActionKeyword actions = new ActionKeyword(driver);
//        WebElement option = driver.findElement(GraphicsDesign);
//        option.getText();
//        actions.hover(option);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoDesign_submenu));
//        WebElement submenu_item = driver.findElement(LogoDesign_submenu);
//        submenu_item.getText();
//        actions.clickElement(submenu_item);
//    }
}
