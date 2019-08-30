package com.ecommerce.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicwebsearch {
	WebDriver driver;

	@BeforeMethod
	public void init()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.get("https://www.google.ca/");

}
	@Test
	public void dynaicgooglesearch()
	{
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("testng");
		List<WebElement> lstsearch=driver.findElements(By.xpath("//*[@role='listbox']/child::li//descendant::div[@class='sbl1']"));
		for( WebElement e:lstsearch)
		{
			
			System.out.println("suggestions are:"+ e.getText());
			String suggestions= e.getText();
			if(suggestions.equalsIgnoreCase("testng maven dependency"))
			{
				e.click();
				
			}
		}
		
	}
}
