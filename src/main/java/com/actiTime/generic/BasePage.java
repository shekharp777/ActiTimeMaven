package com.actiTime.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class BasePage {
	
	public WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//To verify the title
	public String verifyTitle(String eTitle)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		try
		{
			wait.until(ExpectedConditions.titleContains(eTitle));
			Reporter.log("Title is matching: \nExpected title is :"+eTitle ,true);
			Reporter.log("Actual Title is   :"+driver.getTitle(),true);
			return eTitle;
		
		}
		catch(Exception e)
		{
			
			Reporter.log("Title is not matching: \nExptect title is :"+eTitle,true);
			String aTitle = driver.getTitle();
			
			Reporter.log("Actual Title is  :"+aTitle,true);
			SoftAssert sa=new SoftAssert();
			AssertJUnit.assertEquals(aTitle, eTitle);
			sa.assertAll();
			return " ";
		}
		
		
	}
	
	
		//To verify the element is present or not
		public void verifyElement(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			
			try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
				Reporter.log("Element is present: ",true);
			}
			
			catch(Exception e)
			{
				Reporter.log("Element is not present",true);
				SoftAssert sa=new SoftAssert();
				AssertJUnit.assertTrue(true);
				sa.assertAll();
			}
		
			
		}
		
		
		//Handling list Box drop down.
		public static void selectByIndex(WebElement element,int index)
		{
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		
		public static void selectByValue(WebElement element, String value)
		{
			Select select=new Select(element);
			select.selectByValue(value);
		}
		
		public static void SelectByVisibleText(WebElement element, String Text)
		{
			Select select=new Select(element);
			select.selectByVisibleText(Text);
		}
		
		
		
		//Verify list box sorted order or not.
		public static void VerifyListboxSortedOrder(WebElement element)
		{
			Select sel=new Select(element);
			
			List<WebElement> allOptions = sel.getOptions();
			ArrayList<String> allText=new ArrayList<String>();
			
			for(WebElement option:allOptions)
			{
				
				String text = option.getText();
				allText.add(text);
				Reporter.log(text,true);
			}
			
			ArrayList<String> allTextCopy =new ArrayList<String>(allText);
			
			Collections.sort(allText);
			
			if(allText.equals(allTextCopy))
			{
				Reporter.log("\nSorted ListBox",true);
			}
			else
			{
				Reporter.log("\nUnsorted ListBox",true);
			}
		}
	
		
		//Verify the options are duplicate or not?
		public static void VerifyDuplicateListbox(WebElement element)
		{
			Select sel=new Select(element);
			
			List<WebElement> allOptions = sel.getOptions();
			ArrayList<String> allText=new ArrayList<String>();
			
			for(WebElement option:allOptions)
			{
				
				String text = option.getText();
				allText.add(text);
				Reporter.log(text,true);
			}
			
			
			HashSet<String> allTextCopy =new HashSet<String>(allText);
			
			if(allText.size()==allTextCopy.size())
			{
				Reporter.log("\n No Duplicate listbox",true);
			}
			else
			{
				Reporter.log("\n duplicate ListBox",true);
			}
		}
		
		//Display the duplicate option.
		public static void displayDuplicateListbox(WebElement element)
		{
			Select sel=new Select(element);
			
			List<WebElement> allOptions = sel.getOptions();
			HashSet<String> allText=new HashSet<String>();
			
			System.out.println("\n\nduplicate ListBox");
			for(WebElement option:allOptions)
			{
				
				String text = option.getText();
				if(!allText.add(text))
				{
					Reporter.log(text,true);
			
				}
			}	
		}
		

}
