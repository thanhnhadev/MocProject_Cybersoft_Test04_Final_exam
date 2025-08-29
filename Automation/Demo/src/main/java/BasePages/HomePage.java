package BasePages;

import Locator.Locator_CMS;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ActionKeyword.ActionKeyword;
import utils.Constants.ConfigData;
import utils.Logs.LogUtils;

import java.time.Duration;

import static Base.BaseSetup.driver;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By GraphicsDesign= By.xpath(Locator_CMS.GraphicsDesign);
    private By DigitalMarketing= By.xpath(Locator_CMS.DigitalMarketing);
    private By WritingTranslation= By.xpath(Locator_CMS.WritingTranslation);
    private By Video_Animation= By.xpath(Locator_CMS.Video_Animation);
    private By Music_Audio= By.xpath(Locator_CMS.Music_Audio);
    private By Testing= By.xpath(Locator_CMS.Testing);
    private By Search_Bar= By.xpath(Locator_CMS.Search_Body);
    private By btnSearching= By.xpath(Locator_CMS.getBtnSearching_Body);
    private By inputSearch = By.xpath(Locator_CMS.inputSearch);
    private By btnSearch = By.xpath(Locator_CMS.btnSearch);
    private By resultSearch = By.xpath(Locator_CMS.resultSearch);

    public HomePage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void nav_GraphicsDesign(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(GraphicsDesign));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(GraphicsDesign);
        option.getText();
        //Mouse hover option
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void nav_WritingTranslation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(WritingTranslation));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(WritingTranslation);
        option.getText();
        //Mouse hover menuOption
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void nav_DigitalMarketing(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DigitalMarketing));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(DigitalMarketing);
        option.getText();
        //Mouse hover menuOption
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void nav_Video_Animation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Video_Animation));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(Video_Animation);
        option.getText();
        //Mouse hover option
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void nav_Music_Audio(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Music_Audio));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(Music_Audio);
        option.getText();
        //Mouse hover option
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void nav_Testing(String content){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Testing));
        //Instantiate Action Class
        ActionKeyword actions = new ActionKeyword(driver);
        //Retrieve WebElement  to perform mouse hover
        WebElement option = driver.findElement(Testing);
        option.getText();
        //Mouse hover option
        actions.hover(option);
        LogUtils.info("nav:"+option);
    }
    public void Search_Bar(String content){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Search_Bar));
        String title= driver.findElement(Search_Bar).getText();
        driver.findElement(Search_Bar).sendKeys(content);
        LogUtils.info("header:"+title);
        this.btnSearch();
    }
    public void btnSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearching));
        driver.findElement(btnSearch).click();
        LogUtils.info("click search");
    }

   public String checkResultSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultSearch));
        new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resultElement = driver.findElement(resultSearch);
        System.out.println("resultElement.getText() " + resultElement.getText());
        return resultElement.getText();
    }

    public Integer extractNumber(String text) {
        String number = text.split(" ")[0]; // lấy từ đầu tiên trước dấu cách// lấy từ đầu tiên trước dấu cách
        return Integer.parseInt(number);
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

    public WebElement catagoriesMenu(String text) {
        String keyWord = String.format("//p[normalize-space()='%s']", text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyWord)));
        LogUtils.info("Tìm thấy element Popular KeyWord");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(keyWord)));
        return element;
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
