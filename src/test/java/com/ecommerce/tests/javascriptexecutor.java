package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javascriptexecutor {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	@BeforeMethod
	public void init()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\jansi_webdrivers\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.get("http://automationpractice.com/index.php");
		  js=(JavascriptExecutor) driver;
		
	}
	@Test
	public void textbox()
	{
		
		driver.manage().window().maximize();
		//entering text in textbox
		WebElement searchbox=driver.findElement(By.xpath("//*[@id='search_query_top']"));
		
		js.executeScript("arguments[0].value='tshirts'",searchbox);
		
		//getting value or text of webelement
		WebElement gettext=driver.findElement(By.xpath("//*[@title='View my shopping cart']"));
		String text=(String)js.executeScript("return arguments[0].text", gettext);
		System.out.println("text is:"+text);
		
		//scrolling until a webelement can be viewed
		WebElement scroll=driver.findElement(By.xpath("//*[@id='icon-credit-card']"));
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		
		//zooming the body of the page
		
		/*WebElement body=driver.findElement(By.xpath("//*[@id='index']"));
		js.executeScript("arguments[0].style.zoom='10'",body);*/
	}

	public void changecolor()
	{
		
	
		WebElement women =driver.findElement(By.xpath("//*[@title='Women']"));
		js.executeScript("arguments[0].style.backgroundColor='rgb(255,255,0)'", women);
		
	}
	
	
	@Test
	public void check_javascripts()
	{
		changecolor();
	}

}
