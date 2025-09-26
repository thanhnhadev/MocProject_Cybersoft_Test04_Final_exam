package BaseTest;

import Base.BaseSetup;
import BasePages.HomePage;
import BasePages.categoryPage;
import BasePages.servicePage;
import Locator.Locator_CMS;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class servicePageTest extends BaseSetup {

    private HomePage homepage;
    private categoryPage categoryPage;
    private servicePage servicePage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = new HomePage(driver).open();
        categoryPage = new categoryPage(driver);
    }

    @Test(testName = "Test filtering functions")
    public void testFilteringFunctions() {
        navigateToServicePage();

        // DROPDOWN MENU FILTERING
        // not implementing these functions yet


        // TOGGLES FILTERING
        // turn on toggle btns
        servicePage.filterWithToggle("Pro services");
        servicePage.filterWithToggle("Local sellers");
        servicePage.filterWithToggle("Online sellers");
//
//        // turn off toggle btns
        servicePage.filterWithToggle("Pro services");
        servicePage.filterWithToggle("Local sellers");
        servicePage.filterWithToggle("Online sellers");


        // 'SORT BY' FILTERING
        servicePage.sortWithOption("Relevance");
        servicePage.sortWithOption("est Selling");
        servicePage.sortWithOption("New Arrivals");

    }

    // helper, flow: Homepage -> Category page -> Service page (subcategory)
    private void navigateToServicePage() {
        final String categoryXpath = String.format(Locator_CMS.categoriesMenu, "Graphics & Design");
        categoryPage = homepage.navigateToCategoryPage(categoryXpath);
        categoryPage.clickSubcategoryOption("Graphics & Design", "Logo Design");
        servicePage = new servicePage(driver);
    }

}
