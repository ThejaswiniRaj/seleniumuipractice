package com.ecommerce.tests;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.baselayer.TestBase;
import com.ecommerce.baselayer.Utils;
import com.google.common.io.Files;

public class basicfunctions extends TestBase {
	Utils utils=new Utils();
	
	public basicfunctions()
	{
		super();
	}
	@BeforeMethod()
	public void init()
	{
		initialization();	
	}
	
	@Test
	public void xpath()
	{
		
		//driver.findElement(By.id("search_query_top")).sendKeys("shirts");
		//driver.findElement(By.name("submit_search")).click();
		List<WebElement> lst=driver.findElements(By.tagName("a"));
		System.out.println("size of list is:"+ lst.size());
		for(WebElement e:lst)
		{
			System.out.println("links in this page are:"+e.getText());
		}
	}
	@Test
	public void dropdown() throws Exception
	{
		driver.findElement(By.xpath("//*[@title='Women']")).click();
		Thread.sleep(5000);
		WebElement sortby=driver.findElement(By.id("selectProductSort"));
		Select s=new Select(sortby);
		s.selectByIndex(3);
		Thread.sleep(5000);
		
	}
	@Test
	public void mouseover() throws Exception
	{
		//Women
		Actions act=new Actions(driver);
		WebElement mouseover=driver.findElement(By.xpath("//*[@title='Women']"));
		act.moveToElement(mouseover).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@title='Blouses']")).click();
		
		Thread.sleep(3000);
		//utils.screenshotcapture(driver, "automationpractice");
		
		////*[@class='compare-form'][1]
		WebDriverWait wait =new WebDriverWait(driver,5 );
		WebElement element=driver.findElement(By.xpath("//*[@class='compare-form'][1]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	@Test
	public void isdisplayed()
	{
		boolean result=driver.findElement(By.xpath("//*[@class='bx-next']")).isDisplayed();
		System.out.println("result is:" + result);
	}
	
	
	

}
