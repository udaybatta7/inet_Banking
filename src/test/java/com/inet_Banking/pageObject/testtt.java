package com.inet_Banking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.inet_Banking.Utilities.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testtt {
	@Test
	public static void testingJS() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://play.google.com/store?hl=en");
		Thread.sleep(3000);
		WebElement gmail = d.findElement(By.xpath("//a[@class='LkLjZd ScJHi t2Y9uc xjAeve nMZKrb  id-track-click ']"));
		JavaScriptUtil.drawBorder(d, gmail);
		JavaScriptUtil.flash(d, gmail);

//		Actions actions = new Actions(d);
//		actions.moveToElement(gmail).perform();
		System.out.println("moved");

	}

}