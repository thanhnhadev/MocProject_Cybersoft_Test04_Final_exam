package BaseTest;

import Base.BaseSetup;
import BasePages.categoryPage;
import Locator.Locator_CMS;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class categoryPageTest extends BaseSetup {
    private categoryPage categoryPage;

    @BeforeMethod
    public void setUp() {
        categoryPage = new categoryPage(driver);
    }

    @Test(priority = 1,testName = "Navigate to Category page")
    // test nav from Homepage to a category page through Navigation Nav Bar
    public void testNavigateToCategoryPage() {
        categoryPage.navigateToCategoryPage(Locator_CMS.Testing); // change category xpath
        String categoryHeaderTxt = "Testing"; // change category header txt
        Assert.assertTrue(categoryPage.isAtGraphicsDesignPage(categoryHeaderTxt),
                "Not on" + categoryHeaderTxt + "page!");
    }
}
