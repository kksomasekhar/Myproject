package com.learnSutomation.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnSutomation.pages.Baseclass;
import com.learnSutomation.pages.LoginPage;
import com.learnSutomation.utilitys.BrowserFactory;
import com.learnSutomation.utilitys.ExcelDataPovider;
import com.learnSutomation.utilitys.HelperCalss;

public class LoginTestCrm extends Baseclass{
	
	
	@Test 
	public void loginApp() throws InterruptedException, IOException {
		
		
		ExcelDataPovider excel = new ExcelDataPovider();
		
		logger=report.createTest("Login to CRM");
			
		LoginPage lpage= PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		
		lpage.loginCRM(excel.getStringData("LoginData", 0, 0), 	excel.getStringData("LoginData", 0, 1));
		
		logger.pass("Login done success");
			 
	
	} 
	
	
	//Filde test example. 
	
	/*@Test (priority=2)
	public void loginApp_1() throws InterruptedException, IOException {
		
		
		logger =report.createTest("Log Out");
		
		logger.fail("LogOut Failed");
	
	} */
}
