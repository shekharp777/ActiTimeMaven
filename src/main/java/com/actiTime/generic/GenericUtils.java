package com.actiTime.generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils {

	//Failed method screen shot.
	public static void getScreenShot(WebDriver driver,String methodName)
	{
		try
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenshots/"+methodName+".png"));
			
		}
		catch(Exception e)
		{
			
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
			Reporter.log("No Duplicate listbox",true);
		}
		else
		{
			Reporter.log("duplicate ListBox",true);
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
	
	
	//javascrip Pop up accept method
	public static void JavaScriptPopUp(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		
		//to get text
		String text = a.getText();
		Reporter.log("Text :"+text,true);
		
	    //to click on ok
		a.accept();
	
	}
	
	//javascrip Pop up dismiss method
	public static void JavaScriptPopUpCancel(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		
		//to get text
		String text = a.getText();
		Reporter.log("Text :"+text,true);

		//to click on cancel
		a.dismiss();
	}
	
	public static void scrollVertical(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	public static void scrollByVisibleElement(WebElement element,WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
}
