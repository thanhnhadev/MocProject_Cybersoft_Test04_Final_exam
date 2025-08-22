package BasePages;

import io.qameta.allure.Step;
import Locator.Locator_CMS;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants.ConfigData;

import java.time.Duration;

public class detailProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
//    private By btnContinue = By.cssSelector("button.submit");
    private By userID = By.xpath(Locator_CMS.email);
    private By passsWord = By.xpath(Locator_CMS.password);
    private  By btnLogin = By.xpath(Locator_CMS.btnLogin);
    private  By btnSignin = By.xpath(Locator_CMS.btnSignin);
    private By btnContinue = By.xpath(Locator_CMS.btnCountinue);
    private By toastHireSuccess = By.xpath("//*[contains(@class,'Toastify__toast--success') and contains(.,'Thuê công việc thành công')]");
    private By toastMsg = By.xpath("//div[@class= 'Toastify__toast-body']");


    public detailProductPage(WebDriver _driver){
        this.driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }



    @Step("Signin")
    public boolean login(){
        try{
            driver.get(ConfigData.demo5_url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(btnSignin).click();

        driver.findElement(userID).sendKeys("bao123@gmail.com");
        driver.findElement(passsWord).sendKeys("123123123");

//        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));

        driver.findElement(btnLogin).click();

        return false;
    }

    @Step("Join detail page 10")
    public void joinDetailPage(){
        try{
            driver.get(ConfigData.detailPage_url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Click Continue để thuê dịch vụ")
    public void clickContinueHire() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
        driver.findElement(btnContinue).click();

    }

    @Step("Kiểm tra toast 'Thuê công việc thành công !' hiển thị")
    public boolean isHireSuccessToastShown(){
        try {
            WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(toastMsg));
            return toast.getText().contains("Thuê công việc thành công");
        } catch (TimeoutException e) {
            System.out.println("❌ Không thấy toast hiển thị trong 5s");
            return false;
        }
    }

}
