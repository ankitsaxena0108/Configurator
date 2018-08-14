package com.prudential.cbi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.prudential.cbi.common.SeleniumProperties;

public class BaseTest {

	public static WebDriver driver = null;
	public static SeleniumProperties cbiProp = null;

	@BeforeSuite
	public void beforeMethod() throws InterruptedException {
		cbiProp = new SeleniumProperties();
		//
		if (cbiProp.get("browserdriver").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", cbiProp.get("browserdriver"));
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", cbiProp.get("browserdriver"));
			if (cbiProp.get("headlessMode").equals("true")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1200x600");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}

		}

		System.out.println("Browser Driver path :" + cbiProp.get("browserdriver"));

		driver.get(cbiProp.get("url"));

	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Executing aftersuite method");
		driver.quit();
		driver = null;

		try {
			TimeUnit.MILLISECONDS.sleep(Integer.valueOf(cbiProp.get("longtimedelay")));
		} catch (InterruptedException e3) {
		}

	}

}
