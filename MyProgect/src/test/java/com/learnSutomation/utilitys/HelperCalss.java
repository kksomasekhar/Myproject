package com.learnSutomation.utilitys;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.utils.FileUtil;

public class HelperCalss {

	// Screenshots, alerts, farmes, window, synck issues, javaScriptEditor

	public static void captureScreenShot(WebDriver driver) throws IOException { 

	/*File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty
				
				("/home/somasekhar/Documents/workPlace/MyProgect/ScreenShots/" + getTimeStamp() + ".png");

		try {

			FileUtils.copyFile(src, new File(screenShotPath));

			System.out.println("Screenshot captured");

		} catch (Exception e) {

			System.out.println("Unable to capture screenshot" + e.getMessage());

		}
		
		return screenShotPath;*/

		
		  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  
		  try {
		  
		  FileUtils.copyFile(src, new
		  File("/home/somasekhar/Documents/workPlace/MyProgect/ScreenShots/"+
		  getTimeStamp() +".png"));
		  
		  System.out.println("Screenshot captured");
		  
		  } catch (Exception e) {
		  
		  System.out.println("Unable to capture screenshot" + e.getMessage());
		  
		 }
		 

	}

	public static String getTimeStamp() {

		DateFormat customFromate = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

		Date currentDate = new Date();

		return customFromate.format(currentDate);

	}
}