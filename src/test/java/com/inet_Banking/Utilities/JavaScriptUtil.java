package com.inet_Banking.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	public static void flash(WebDriver driver, WebElement element) {
		String bgc = element.getCssValue("backgroundColor");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 500; i++) {

			// js.executeScript("arguments[0].setAttribute('style', 'background: blue;');",
			// element);
			// js.executeScript("arguments[0].setAttribute('style', 'background: bgc; ');",
			// element);
			changeColour(driver, element, "rgb(0,200,0)");
			changeColour(driver, element, bgc);
		}
	}

	public static void changeColour(WebDriver driver, WebElement element, String color) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'background: " + color + "; ');", element);
	}

	public static void drawBorder(WebDriver driver, WebElement element) {
		String bgr = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style', 'background: " + bgr + "; border: 4px solid red;');",
				element);
	}

	public static String getTitleJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		String title = js.executeScript("return document.title").toString();
		return title;
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public static void scrollDownByHeight(WebDriver driver, int height) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollBy(0," + height + ")", "");

	}

	public static void scrollOnElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void refreshBrowserWithJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go()");

	}

	public static void clickElementByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click;", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

}
