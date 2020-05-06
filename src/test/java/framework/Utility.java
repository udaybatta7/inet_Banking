package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility extends Base {

	public File file;
	public static Properties prop;
	public static String filePath = System.getProperty("user.dir") + "\\Configuration\\config.properties";

	public static void properties() {

		File file = new File(filePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			System.out.println("prop loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getValue(String key) {

		properties();
		System.out.println(prop.getProperty("uName"));

		return prop.getProperty(key);

	}

}
