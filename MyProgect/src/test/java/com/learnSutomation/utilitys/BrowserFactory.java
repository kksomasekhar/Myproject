package com.learnSutomation.utilitys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplycations(WebDriver driver, String browserName, String appURL) {

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"/home/somasekhar/Documents/workPlace/MyProgect/Drivers/chromedriver");

			driver = new ChromeDriver();

		}

		else if (browserName.equals("fireFox")) {

		}

		else if (browserName.equals("safari")) {

		}

		else {

			System.out.println("we do not support this browser");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}

}
