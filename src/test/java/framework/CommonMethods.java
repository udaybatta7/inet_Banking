package framework;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods extends Base {

	static Utility ut = new Utility();

	public static void lanchBrowser() {

		String browser = ut.getValue("browsername");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser not matched");
		}
		driver.manage().window().maximize();
		implicityWait(20);
		driver.get(ut.getValue("url"));
		driver.getTitle();

	}

	public static String getTimeStamp() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//		Date date = new Date();
//		date.getTime();
		// System.out.println(timeStamp.getTime());

		// System.out.println(sdf.format(timeStamp));
		String currentTime = sdf.format(timeStamp);
		return currentTime;

	}

}
