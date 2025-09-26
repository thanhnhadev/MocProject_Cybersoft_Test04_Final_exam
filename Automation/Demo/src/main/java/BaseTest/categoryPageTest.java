package BaseTest;

import Base.BaseSetup;
import BasePages.HomePage;
import BasePages.categoryPage;
import Locator.Locator_CMS;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class categoryPageTest extends BaseSetup {

    private HomePage homepage;
    private categoryPage categoryPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = new HomePage(driver).open();
        categoryPage = new categoryPage(driver);
    }

    @DataProvider(name = "categories")
    public Object[][] categories() {
        return new Object[][]{
                {"Graphics & Design"},
                {"Digital Marketing"}
        };
    }

    @DataProvider(name = "subcategories")
    public Object[][] subcategories() {
        return new Object[][]{
                // {category, subCategory}
                {"Graphics & Design", "Logo Design"},
                {"Digital Marketing", "Search Engine Optimization (SEO)"}
        };
    }

    @Test(priority = 1,testName = "Navigate to a Category page", dataProvider = "categories")
    public void testNavigateToCategoryPage(String categoryName) {
       navigateToCategory(categoryName);

        Assert.assertTrue(
                categoryPage.isAtCategoryPage(categoryName),
                "Not on " + categoryName + " page!"
        );
    }

    @Test(priority = 2,testName = "Hover and click Fiverr button", dataProvider = "categories")
    public void testHoverClickFiverrButton(String categoryName) {
        navigateToCategory(categoryName);
        categoryPage.hoverClickFiverrButton();
    }

    @Test(priority = 3,testName = "Click subcategory option", dataProvider = "subcategories")
    public void testClickSubcategory(String categoryName, String subCategory) {
        navigateToCategory(categoryName);
        categoryPage.clickSubcategoryOption(categoryName, subCategory);
    }

    // helper
    private void navigateToCategory(String categoryName) {
        final String categoryXpath = String.format(Locator_CMS.categoriesMenu, categoryName);
        categoryPage = homepage.navigateToCategoryPage(categoryXpath);
    }
}
