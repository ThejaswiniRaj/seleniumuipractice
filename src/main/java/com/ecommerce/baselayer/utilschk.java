package com.ecommerce.baselayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class utilschk {
	public List<HashMap<String, String>> readexcelintohashmap() throws IOException
	{
		String path="C:\\jansi_javafiles_2\\seleniumui_practice\\Resources\\TestData1.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook book=new XSSFWorkbook(file);
		Sheet sheet=book.getSheet("Sheet1");
		int lastrow_num=sheet.getLastRowNum();
		int lastcol_num=sheet.getRow(0).getLastCellNum();
		
		
		//Object[][] array=new Object[lastrow_num][1];
		List<HashMap<String,String>>lst=new ArrayList();
		
		
		for(int i=0;i<lastrow_num;i++)
		{ 
			//create hashmap inside for loop for row,only then new hashmap will be created for each row,orelse,same hashmap will be added repeatedly in arry or list
			HashMap<String,String> hm=new HashMap<String, String>();
			for(int j=0;j<lastcol_num;j++)
			{
				//key-->0th row and coln gets incremented,value-->1st row and col gets incremented from 0
				hm.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
				
				
				}
			lst.add(hm);
			
			//since we have to pass array in data provider,assign hashmap to object arry with 2d
			//it has multiple rows(each row is a hashmap,but only one column)
			
			
			
			}
		return lst;
		
		}
	public Object[][] hashmapintoarray(List<HashMap<String, String>> lst) throws IOException
	{
		Object[][] array=new Object[lst.size()][1];
		for(int i=0;i<lst.size();i++)
		{
			array[i][0]=lst.get(i);
		}
		return array;
	}
	@Test
	public void hashintoarraytest() throws IOException

	{
		List<HashMap<String, String>> lst=readexcelintohashmap();
		Object[][] array=hashmapintoarray(lst);
		
	
		for(int i=0;i<array.length;i++)
		{
		System.out.println("value of email:" + array[i][0].toString());
		}
		
	}

}
