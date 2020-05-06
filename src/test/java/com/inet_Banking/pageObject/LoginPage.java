package com.inet_Banking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement usName;

	@FindBy(name = "password")
	WebElement pswd;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	// User ID : mngr257610
	// Password : Yvuqusu

	@FindBy(how = How.XPATH, using = "//li//a[text()='Log out']")
	WebElement logOutBtn;

	public void setUsername(String username) {

		usName.sendKeys(username);
	}

	public void setPassword(String password) {
		pswd.sendKeys(password);
	}

	public void clickSubmit() {

		loginBtn.click();
	}

	public void clickLogout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", logOutBtn);

	}

}
