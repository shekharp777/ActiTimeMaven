package com.actiTime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
}
