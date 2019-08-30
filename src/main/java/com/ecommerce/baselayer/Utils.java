package com.ecommerce.baselayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.poi.*;
public class Utils {
	
	
public void screenshotcapture(WebDriver driver,String filename)
{
	try {
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\jansi_javafiles_2\\seleniumui_practice\\src\\"+filename+".png"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public Object[][] readdatafromexcel(String path,String sheetname) throws IOException 
{
	//creates stream btw java code and file
	FileInputStream file=new FileInputStream(path);
	Workbook book=new XSSFWorkbook(file);
	Sheet sheet=book.getSheet(sheetname);
	int lastrow_num=sheet.getLastRowNum();
	int lastcol_num=sheet.getRow(0).getLastCellNum();
	
	//define an object array with index 
	Object[][] data=new Object[lastrow_num][lastcol_num];
	
	//iterate rows and cols to get from row(1st index) and coln (0th index)
	for(int i=0;i<lastrow_num;i++)
	{
		for(int j=0;j<lastcol_num;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
		
	}
	
	
return data;
	
	
}

public Object[][] readexcelintohashmap() throws IOException
{
	String path="C:\\jansi_javafiles_2\\seleniumui_practice\\Resources\\TestData1.xlsx";
	FileInputStream file=new FileInputStream(path);
	Workbook book=new XSSFWorkbook(file);
	Sheet sheet=book.getSheet("Sheet1");
	int lastrow_num=sheet.getLastRowNum();
	int lastcol_num=sheet.getRow(0).getLastCellNum();
	
	
	Object[][] array=new Object[lastrow_num][1];
	
	
	for(int i=0;i<lastrow_num;i++)
	{ 
		//create hashmap inside for loop for row,only then new hashmap will be created for each row,orelse,same hashmap will be added repeatedly in arry or list
		HashMap<String,String> hm=new HashMap<String, String>();
		for(int j=0;j<lastcol_num;j++)
		{
			//key-->0th row and coln gets incremented,value-->1st row and col gets incremented from 0
			hm.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
			
			
			}
		
		//since we have to pass array in data provider,assign hashmap to object arry with 2d
		//it has multiple rows(each row is a hashmap,but only one column)
		array[i][0]=hm;
		
		
		}
	return array;
	
	}

/*public Object[] hashmapintoarray(List<HashMap<String, String>> lst) throws IOException
{
	Object[] array=new Object[lst.size()];
	for(int i=0;i<lst.size();i++)
	{
		array[i]=lst.get(i);
	}
	return array;
}
@Test
public void hashintoarraytest() throws IOException

{
	List<HashMap<String, String>> lst=readexcelintohashmap();
	List<HashMap<String, String>> lst=readexcelintohashmap();
	
	Object[] array=hashmapintoarray(lst);
	for(int i=0;i<array.length;i++)
	{
	System.out.println("value of email:" + array[i].toString());
	}
	
}*/



}
