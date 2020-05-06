package framework;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inet_Banking.Utilities.ExtentReportsNG;

public class ListenersClass extends Base implements ITestListener {

	ExtentReports extent = ExtentReportsNG.extentReportsGenerator();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		System.out.println("New Test Started" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Successfully Finished " + result.getName());
		System.out.println("Test Successfully Finished " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(captureScreenshot(result.getMethod().getMethodName()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captureScreenshot(result.getName());
		System.out.println("Test Failed  " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage" + result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("This is onStart method" + context.getOutputDirectory());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("This is onFinish method" + context.getPassedTests());
		System.out.println("This is onFinish method" + context.getFailedTests());
	}

}
