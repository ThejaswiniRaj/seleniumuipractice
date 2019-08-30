package com.ecommerce.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class headlessbrowser {
	@Test
	public void headlessbrowsertesting()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
	HtmlUnitDriver unitdriver = new HtmlUnitDriver();
	unitdriver.get("http://automationpractice.com/index.php");
	String title=unitdriver.getTitle();
	System.out.println("title of home page is:"+ title);
	
	}
	@Test
	public void headlessusingchromeoptions()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://www.google.ca/");
		 String title=driver.getTitle();
		 String url=driver.getCurrentUrl();
		 System.out.println("current url is " + url);
		 System.out.println("title is  " + title);
		 
	}
}
