package com.actiTime.test;

import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;


public class TC01Test extends BaseTest{
	
	@Test(priority=1)
	public void testTC01() throws InterruptedException
	{
				//user name
				String un = ExcelData.getData(File_Path, "Sheet1", 1, 0);
				
				//password
				String pwd = ExcelData.getData(File_Path, "Sheet1", 1, 1);
				
				
				//login page title
				String loginTitle = ExcelData.getData(File_Path, "Sheet1", 1, 2);
						
				
				//EnterTimeTrackPage title
				String enterTimeTitle = ExcelData.getData(File_Path, "Sheet1", 1, 4);
				
				
				Thread.sleep(2000);
				LoginPage lp=new LoginPage(driver);
				//verify login page title
				lp.verifyingTitle(loginTitle);
				
				//enter valid user name
				lp.enterUserName(un);
				

				//enter valid password
				lp.enterPassword(pwd);
				
				//click on login
				lp.clickOnLogin();
				System.out.println("click on login");
				
				
				EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
				//verify enter time track page title
				ep.verifyingTitle(enterTimeTitle);
				
				//click on logout
				ep.clickOnLogOut();
				System.out.println("click on logout");
				
				
	}

}
