package com.ecommerce.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.baselayer.TestBase;
import com.ecommerce.baselayer.Utils;
import com.ecommerce.baselayer.utilschk;

public class readdatafromexcel extends TestBase {
	
	
	String path="C:\\jansi_javafiles_2\\seleniumui_practice\\Resources\\TestData.xlsx";
	
	String sheetname="Sheet1";
	
	
	public readdatafromexcel()
	{
		super();
	}
	@BeforeMethod()
	public void setup()
	
	{
		initialization();
	}
	
	@DataProvider
	public Object[][] readdatafromexcelutil() throws IOException
	{
		Utils util=new Utils();
		Object[][] data=util.readdatafromexcel(path,sheetname);
		return data;
	}
	
	@Test(dataProvider="readdatafromexcelutil")
	public void signin(String email,String password)
	
	{
		driver.findElement(By.xpath("//*[@class='login']")).click();;
		 driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);;
		driver.findElement(By.id("SubmitLogin")).click();
		
		}
	//read data from excel and store in hashmap
	@DataProvider
	public  Object[][] readexcelintohashmap() throws IOException
	{
		Utils util=new Utils();
		 Object[][] array=util.readexcelintohashmap();
		 //Object[] array= util.hashmapintoarray(lstdata);
		return array;
	}

	
	
	@Test(dataProvider="readexcelintohashmap")
	//here data provider returns 2d object array,but instead of passing arguments,we can access the array through passing hashmap
	public void getdatafromhashmap(HashMap<String,String>hashmap) throws IOException, InterruptedException
	{
		
		System.out.println(hashmap.get("email"));
		driver.findElement(By.xpath("//*[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys(hashmap.get("email"));
		
		
		 Thread.sleep(5000);
		driver.findElement(By.id("passwd")).sendKeys(hashmap.get("password"));
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	//read data from excel and store in list of hashmap
	@DataProvider
	public  Object[][]  readexcelintolist() throws IOException
	{
		utilschk utilchk=new utilschk();
		List<HashMap<String, String>>  lst=utilchk.readexcelintohashmap();
		Object[][] arraylist=utilchk.hashmapintoarray(lst);
		return arraylist;
		 
	}

	
	
	@Test(dataProvider="readexcelintolist")
	//here data provider returns 2d object array,but instead of passing arguments,we can access the array through passing hashmap
	public void getdatafromarraylist(HashMap<String,String>hashmaplist) throws IOException, InterruptedException
	{
		
		//System.out.println(hashmap.get("email"));
		driver.findElement(By.xpath("//*[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys(hashmaplist.get("email"));
		
		
		 Thread.sleep(5000);
		driver.findElement(By.id("passwd")).sendKeys(hashmaplist.get("password"));
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	
}