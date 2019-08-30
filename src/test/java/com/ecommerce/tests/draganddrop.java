package com.ecommerce.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class draganddrop {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		
	}
	@Test
	public void dragdrop() throws Exception
	{
		driver.get("https://jqueryui.com/droppable/");
		List<WebElement> lstframes=driver.findElements(By.tagName("iframe"));
		System.out.println("size:"+lstframes.size());
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		Thread.sleep(5000);
		
	
	}

}
