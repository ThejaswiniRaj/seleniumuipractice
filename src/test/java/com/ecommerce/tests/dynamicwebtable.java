package com.ecommerce.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicwebtable {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		
	}
	@Test
	public void tablevalue()
	{
		WebElement webtable=driver.findElement(By.xpath("//*[@id='task-table']/child::tbody"));
		driver.findElement(By.xpath("//*[@id='task-table-filter']")).sendKeys("wire");
		List<WebElement> lstrows=	webtable.findElements(By.tagName("tr"));
		System.out.println("no.of rows are:" +lstrows.size());
		List<WebElement> lstcols=lstrows.get(0).findElements(By.tagName("td"));
		System.out.println("no.of cols are:" +lstcols.size());
		for(int i=1;i<=lstrows.size();i++)
		{
			for(int j=1;j<=lstcols.size();j++)
			{
				if(lstcols.get(2).getText().equalsIgnoreCase("John Smith"))
				{
				System.out.println("using iterator:" +driver.findElement(By.xpath("//*[@id='task-table']/child::tbody/tr["+i+"]/td["+j+"]")).getText());
				
				}
			}
		}
		
	}
	@Test
	public void customxpath()
	{
		driver.findElement(By.xpath("//*[@id='task-table-filter']")).sendKeys("wire");
		System.out.println("using customxpath:" +driver.findElement(By.xpath("//*[@id='task-table']/child::tbody/child::tr/child::td[2]")).getText());
		
	}
	
	
	

}
