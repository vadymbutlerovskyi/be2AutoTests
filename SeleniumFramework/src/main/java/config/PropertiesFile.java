package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import tests.BaseTest;

public class PropertiesFile {

	static Properties prop = new Properties();

	public static void getProperties() {
		try {
			String propPath = System.getProperty("user.dir") + "/src/main/java/config/config.properties";
			InputStream input = new FileInputStream(propPath);
			prop.load(input);
			BaseTest.browser = prop.getProperty("browser");
			BaseTest.headless = prop.getProperty("headless");
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
