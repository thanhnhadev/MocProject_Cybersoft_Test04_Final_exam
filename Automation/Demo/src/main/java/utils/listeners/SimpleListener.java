package utils.listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestNGListener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SimpleListener implements ITestNGListener {
    public void onTestStart(org.testng.ITestResult result) {
        /* compiled code */ }
    public void onTestSuccess(org.testng.ITestResult result) { /* compiled code
     */ }
    public void onTestFailure(org.testng.ITestResult result) {

    }
    public void onTestSkipped(org.testng.ITestResult result) { /* compiled code */
    }
    public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult
                                                               result) { /* compiled code */ }
    public void onTestFailedWithTimeout(org.testng.ITestResult result) { /*
compiled code */ }
    public void onStart(org.testng.ITestContext context) { /* compiled code */ }
    public void onFinish(org.testng.ITestContext context) { /* compiled code */ }
}
