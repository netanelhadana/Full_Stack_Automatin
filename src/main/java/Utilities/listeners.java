package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener
{
    public void onStart(ITestContext execution)
    {
        System.out.println("-----------Starting Execution------------");
    }

    public void onFinish(ITestContext execution)
    {
        System.out.println("-----------Ending Execution------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {

    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("-----------Skipping Test: " + test.getName() + " ------------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("-----------Starting Test: " + test.getName() + " ------------");
    }

    public void onTestSuccess(ITestResult test)
    {
        System.out.println("-----------Test: " + test.getName() + " Passed ------------");
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("-----------Test: " + test.getName() + " Failed ------------");
        if (!Platform.equalsIgnoreCase("api"))
            saveScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
