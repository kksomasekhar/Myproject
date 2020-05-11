package com.learnSutomation.utilitys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataprovider {

	Properties pro;
	
	public ConfigDataprovider() throws IOException {
		
		File src = new File("/home/somasekhar/Desktop/Myproject/MyProgect/config/Confi.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Unable to load config file >> "+ e.getMessage());
		}
	}
	
	
	public String getDatafromConfig(String keyTosearch) {
		return pro.getProperty(keyTosearch);
		
		
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL() {
		
		return pro.getProperty("qaURL");
		
	}
}
