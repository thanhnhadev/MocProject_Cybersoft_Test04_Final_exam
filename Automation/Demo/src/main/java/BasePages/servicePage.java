package BasePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionKeyword.ActionKeyword;
import Locator.Locator_CMS;

import java.time.Duration;

import static Base.BaseSetup.sleep;

public class servicePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ActionKeyword actions;

    public servicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new ActionKeyword(driver);

    }
    public void filterWithToggle(String toggleLabel) {
        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(Locator_CMS.toggleButtonWithLabel, toggleLabel)))
        );
        sleep(2);
        actions.clickElement(toggle);
        sleep(2);
    }

    public void sortWithOption(String sortOption) {
        WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(Locator_CMS.sortDropdownMenu)
        ));
        actions.clickElement(sortDropdown);

        Select select = new Select(sortDropdown); // select for html
        select.selectByVisibleText(sortOption);
        sleep(2);
    }

}
