package utils.ActionKeyword;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Base.BaseSetup.driver;

public class ActionKeyword {
    private WebDriver driver;

    public ActionKeyword(WebDriver driver) {
        this.driver = driver;
    }
    //phím chọn hết rồi nhấn xóa
    public static CharSequence keyPress_Delete() {
        return Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; // CHUỖI tổ hợp Ctrl+A rồi Delete
    }
    //Scroll toàn trang xuống cuối
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    //Scroll đến 1 phần tử cụ thể
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //Scroll theo pixel
    public void scrollByPixel(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    //Scroll lên đầu trang
    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }
    //scroll trong một div cụ thể (not toàn bộ trang)
    public void scrollInsideElement(WebElement scrollableDiv, int yOffset) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[1];", scrollableDiv, yOffset);
    }
    //mô phỏng thao tác giữ phím
    public void keyDownExample(WebElement element, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(element, key).perform();
    }
    //chuột trái
    public void clickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }
    //Hover chuột (di chuyển chuột đến element)
    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
    //Right Click (chuột phải - context menu)
    public void rightClick(WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }
    //Double Click (nhấp đúp)
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }
    //Drag and Drop (kéo và thả)
    public void dragAndDrop(WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }
    //Click and Hold (giữ chuột trái)
    public void clickAndHold(WebElement element) {
        new Actions(driver).clickAndHold(element).perform();
    }
    //Kéo từ điểm A đến điểm B (offset)
    public void dragByOffset(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }
    //Nhấn và giữ phím (keyDown)
    public void holdKey(WebElement element, Keys key) {
        new Actions(driver)
                .click(element)
                .keyDown(key)
                .perform();
    }
    //Thả phím (keyUp)
    public void releaseKey(WebElement element, Keys key) {
        new Actions(driver)
                .click(element)
                .keyUp(key)
                .perform();
    }
    //phím enter
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }
    //phím tab
    public void pressTab(WebElement element) {
        element.sendKeys(Keys.TAB);
    }
    //Nhập chữ in hoa bằng SHIFT
    public void typeUppercase(WebElement element, String text) {
        new Actions(driver)
                .click(element)
                .keyDown(Keys.SHIFT)
                .sendKeys(text)
                .keyUp(Keys.SHIFT)
                .perform();
    }
    //tổ hợp phím: Ctrl + A, Ctrl + C, Ctrl + V,...
    public void pressShortcut(WebElement element, Keys modifierKey, String key) {
        new Actions(driver)
                .click(element)
                .keyDown(modifierKey)
                .sendKeys(key)
                .keyUp(modifierKey)
                .perform();
    }
    //trong hàm main ví dụ bên dưới
    // Gửi phím Enter
//    ActionKeyword keyboard = new ActionKeyword(driver);
//    keyboard.pressEnter(input);
//
//    // Gửi tổ hợp Ctrl + A
//    keyboard.pressShortcut(input, Keys.CONTROL, "a");
//
//    // Gửi tổ hợp Ctrl + C
//    keyboard.pressShortcut(input, Keys.CONTROL, "c");
//
//    // In hoa chữ
//    keyboard.typeWithShift(input, "abc"); // Kết quả: ABC
}
