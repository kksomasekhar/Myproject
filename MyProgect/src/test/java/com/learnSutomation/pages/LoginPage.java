package com.learnSutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
	}
	
	@FindBy(xpath ="//input[@name='email']") WebElement uname;
	
	@FindBy(xpath="//input[@name='password']") WebElement pname;
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com']") WebElement Main_loginButton;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginButton;
	
	
	
	public void loginCRM(String usernameApplycation, String passwordApplycation) throws InterruptedException {
		
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			

		}
		
		Main_loginButton.click();
		uname.sendKeys(usernameApplycation);
		pname.sendKeys(passwordApplycation);
		loginButton.click();
		
	}

}
