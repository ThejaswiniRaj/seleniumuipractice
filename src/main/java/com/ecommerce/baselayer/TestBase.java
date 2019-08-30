package com.ecommerce.baselayer;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public TestBase()
	{
		String path="C:\\jansi_javafiles_2\\seleniumui_practice\\src\\config.properties";
		try
		{
		FileInputStream file=new FileInputStream(path);
		 prop=new Properties();
		prop.load(file);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		if((prop.getProperty("Browser")).equals("chrome"))
		{
			
			 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
			  driver=new ChromeDriver();
			  driver.get("http://automationpractice.com/index.php");
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			 
			
			 
			 
		
		
	}
	
	
}
}

