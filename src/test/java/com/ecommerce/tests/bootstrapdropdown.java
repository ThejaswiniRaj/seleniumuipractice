package com.ecommerce.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bootstrapdropdown {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
	}
	@Test
	public void bootstrap() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='menu1']")).click();
		List<WebElement> lstdropdown=driver.findElements(By.xpath("//*[@class='dropdown-menu']/child::li/child::a[@role='menuitem']"));
		for(WebElement e:lstdropdown)
		{
			System.out.println("values in the deopdown are:" + e.getText());
			String values=e.getText();
			Thread.sleep(5000);
			if(values.equalsIgnoreCase("html"))
			{
				e.click();
				break;
			}
			
		}
		
	}
}
	
	
	

