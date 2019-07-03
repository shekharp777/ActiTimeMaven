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
	
	//javascript Pop up dismiss method
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
