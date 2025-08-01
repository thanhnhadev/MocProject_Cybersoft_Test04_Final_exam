package utils.listeners;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Helper.PropertiesHelper;
import utils.Logs.LogUtils;
import utils.reports.AllureManager;
import utils.reports.CaptureReport;
import utils.reports.ExtentReportManager;
import utils.reports.ExtentTestManager;

public class TestListener implements ITestListener {
    public WebDriver driver;
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();
        LogUtils.info("#########");
        LogUtils.info("*****"+result.getName()+"***");
        CaptureReport.captureScreenshot(driver,result.getName());
        //Khởi tạo report (Extent và Allure)
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("End testing " + result.getName());

        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Running test case " + result.getName());

        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        CaptureReport.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
        //Allure Report
        AllureManager.saveTextLog(result.getName() + " is pass.");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        //Screenshot khi fail
        CaptureReport.captureScreenshot(driver,result.getName());
        LogUtils.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        //Allure Report
        AllureManager.saveTextLog(result.getName() + " is failed.");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is skipped.");
        LogUtils.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

}
