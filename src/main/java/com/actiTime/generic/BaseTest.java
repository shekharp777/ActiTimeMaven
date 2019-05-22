package com.actiTime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	
	
	@Parameters("myBrowser")
	@BeforeMethod
	public void preCondition(String myBrowser)
	{
		if(myBrowser.equalsIgnoreCase("firefox"))
		{
		
			System.setProperty(gecko_key, gecko_value);
			driver= new FirefoxDriver();
				
		}
		else if(myBrowser.equalsIgnoreCase("chrome"))
		{
		System.setProperty(chrome_key,chrome_value);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(myBrowser.equalsIgnoreCase("ie"))
		{
		System.setProperty(ie_key,ie_value);
		driver= new InternetExplorerDriver();
		driver.manage().window().maximize();
		}
	
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("http://localhost/login.do");
		driver.get("file:///C:/Users/Shekhar/Desktop/HTMLforQspider/ListBox.html");
		
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status=res.getStatus();
		if(status==2)
		{
			String methodName=res.getName();
			GenericUtils.getScreenShot(driver,methodName);
			
		}
		
		driver.close();
	}

}
