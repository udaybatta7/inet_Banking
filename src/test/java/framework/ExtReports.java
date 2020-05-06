package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtReports {
	static WebDriver driver;
	static ExtentHtmlReporter Reporter;

	static ExtentReports extent;

	@BeforeTest
	public void reports() {
		String path = System.getProperty("user.dir") + "/ExtentReports/testReport.html";
		ExtentHtmlReporter Reporter = new ExtentHtmlReporter(path);
		Reporter.config().setDocumentTitle("Test-Automation");
		Reporter.config().setReportName("Google");
		Reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Uday");
	}

	@Test
	public static void Google() {
		extent.createTest("Demo Test");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='q']"));
		Assert.assertTrue(false);
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
