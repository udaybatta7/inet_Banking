package com.inet_Banking.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet_Banking.pageObject.LoginPage;

import framework.Base;

public class TC_LoginTestDDT_02 extends Base {

	public LoginPage lp;

	@Test(dataProvider = "testDataSet")
	public void logInDataProvider(String uName, String pasw) throws InterruptedException {

		lp = new LoginPage(driver);
		lp.setUsername(uName);
		lp.setPassword(pasw);
		lp.clickSubmit();

//		if (isAlertPresent() == true) {
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
//		} else {
//			Assert.assertTrue(true);
//			Thread.sleep(3000);
//			lp.clickLogout();
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
//		}

	}

	@DataProvider(name = "testDataSet")
	public Object[][] GetData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "mngr257610";
		data[0][1] = "Yvuqusu";
		data[1][0] = "mngr257610";
		data[1][1] = "Yvuqusu";
		return data;
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}

	}
}
