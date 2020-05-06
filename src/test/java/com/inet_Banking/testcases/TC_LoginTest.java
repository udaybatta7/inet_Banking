package com.inet_Banking.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inet_Banking.pageObject.LoginPage;

import framework.Base;
import framework.CommonMethods;
import framework.ListenersClass;
import framework.Utility;

@Listeners(ListenersClass.class)
public class TC_LoginTest extends Base {
	public LoginPage lp;

	@Test

	public void loginTest() throws FileNotFoundException {
		CommonMethods.lanchBrowser();
		lp = new LoginPage(driver);

		lp.setUsername(Utility.getValue("uName"));

		lp.setPassword(Utility.getValue("pswd"));

		lp.clickSubmit();

		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);

		} else {
			Assert.assertFalse(false);

		}

	}

	private String getPsw() {
		// TODO Auto-generated method stub
		return null;
	}

}
