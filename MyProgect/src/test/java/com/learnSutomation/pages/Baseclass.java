package com.learnSutomation.pages;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.soap.AttachmentPart;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnSutomation.utilitys.BrowserFactory;
import com.learnSutomation.utilitys.ConfigDataprovider;
import com.learnSutomation.utilitys.ExcelDataPovider;
import com.learnSutomation.utilitys.HelperCalss;

public class Baseclass {

	public WebDriver driver;
	public ExcelDataPovider execl;
	public ConfigDataprovider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() throws IOException {
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		execl = new ExcelDataPovider();
		config = new ConfigDataprovider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File("/home/somasekhar/Documents/workPlace/MyProgect/Reports/FreeCRM_"
						+ HelperCalss.getTimeStamp() + ".html"));

		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done - Test can be started", true);

	}

	@BeforeClass
	public void setUp() {

		// taking browser data and URL info from the propertues file in the config
		// folder.
		driver = BrowserFactory.startApplycations(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Settigs done test can be started", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end ", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			HelperCalss.captureScreenShot(driver);

		}

		report.flush();
		
		Reporter.log("Test complited >>> Reports genarated", true);
	}
	

}
