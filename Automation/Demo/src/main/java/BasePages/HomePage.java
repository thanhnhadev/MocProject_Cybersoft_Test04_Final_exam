package BasePages;

import BasePages.Components.CategoryNavBar;
import Locator.Locator_CMS;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;

import java.time.Duration;

import static Base.BaseSetup.sleep;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ActionKeyword actions;

    private CategoryNavBar categoryNavBar;

    private By Search_Bar= By.xpath(Locator_CMS.Search_Body);
    private By btnSearching= By.xpath(Locator_CMS.getBtnSearching_Body);
    private By inputSearch = By.xpath(Locator_CMS.inputSearch);
    private By btnSearch = By.xpath(Locator_CMS.btnSearch);
    private By resultSearch = By.xpath(Locator_CMS.resultSearch);

    // locator cho heading "Popular professional services" (phần cố định trên Homepage)
    private final By popularProfessionalServicesTitle =
            By.xpath(Locator_CMS.popularProfessionalServiceHeading);

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.categoryNavBar = new CategoryNavBar(driver);
        this.actions = new ActionKeyword(driver);
    }

    public HomePage open() {
        driver.get(ConfigData.base_url);
        LogUtils.info("Opened Homepage: " + ConfigData.base_url);
        sleep(2);
        return this;
    }

    public categoryPage navigateToCategoryPage(String categoryXpath) {
        LogUtils.info("Starting navigation to category page from Homepage:");

        // scroll down a little bit to see the category nav bar exists
        WebElement heading = driver.findElement(popularProfessionalServicesTitle);
        actions.scrollToElement(heading);
        sleep(2);
        LogUtils.info("Scrolled to Popular professional services heading. Category nav bar visible.");

        categoryPage page = categoryNavBar.navigateToCategory(categoryXpath);

        // scroll lên top sau khi load
        actions.scrollToTop();
        sleep(2);

        LogUtils.info("Clicked on category. Waiting for page load...");
        return page;
    }

    public void btnSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearching));
        driver.findElement(btnSearch).click();
        LogUtils.info("click search");
    }

    //kiểm tra có kết quả service available > 0
    public int  testHasService() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultSearch));
        new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resultElement = driver.findElement(resultSearch);
        System.out.println("resultElement.getText() " + resultElement.getText());
        String text =resultElement.getText();
        String number = text.split(" ")[0]; // lấy từ đầu tiên trước dấu cách// lấy từ đầu tiên trước dấu cách
        int  serviceCount =  Integer.parseInt(number);
        return  serviceCount;
    }

    // click key word popular
    public void clickPopularKeyWord(String text) {
        String keyWord = "//div[normalize-space()='" + text + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyWord)));
        LogUtils.info("Tìm thấy element Popular KeyWord");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resultElement = driver.findElement(By.xpath(keyWord));
        resultElement.click();
        LogUtils.info("Clicked Popular KeyWord");
    }

    public WebElement clickElement(String xpath, String text) {
        String keyWord = String.format(xpath, text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyWord)));
        LogUtils.info("Tìm thấy KeyWord");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(keyWord)));
        LogUtils.info("Clicked KeyWord");
        return element;
    }
}
