package com.ecommerce.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class popups {
	WebDriver driver;
@BeforeMethod
public void init()
{
	 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
	 driver =new ChromeDriver();
	
}
@Test
public void alert() throws Exception
{
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Alert  alt=driver.switchTo().alert();
	alt.accept();
	
}
@Test
public void fileuploadpopup() throws Exception
{
	driver.get("https://html.com/input-type-file/");
	driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Raj\\Desktop\\TestNG\\Selenium_3_webdriver_tutorials\\Howtofind_brokenlinks_andimages.docx");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	
}
}
