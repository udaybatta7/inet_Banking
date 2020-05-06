package com.inet_Banking.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import framework.CommonMethods;

public class ExtentReportsNG {
	// static CommonMethods cm = new CommonMethods();
	static ExtentReports extent;
	static ExtentHtmlReporter Reporter;

	public static ExtentReports extentReportsGenerator() {

		String path = System.getProperty("user.dir") + "/ExtentReports/testReport" + CommonMethods.getTimeStamp()
				+ ".html";
		Reporter = new ExtentHtmlReporter(path);
		Reporter.config().setDocumentTitle("Test-Automation");
		Reporter.config().setReportName("Google");
		Reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Uday");
		return extent;
	}

}
