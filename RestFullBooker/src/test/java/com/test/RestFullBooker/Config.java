package com.test.RestFullBooker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {

	public WebDriver driver;
	public Properties properties;

	public void initializeWendriver() throws IOException {
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"/Users/sagarliki/eclipse-workspace/RestFullBooker/resourse/data.property");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser");
		if (browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sagarliki/Downloads/chromedriver");
			if (browserName.contains("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
			}
			driver = new ChromeDriver();
		}
	}
	
	public WebDriver getInitializeWebDriver() throws NullPointerException {
		if(driver != null) {
			return driver;
		}else {
			throw new NullPointerException("driver is null");
		}
	}
}
