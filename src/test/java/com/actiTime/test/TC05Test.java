package com.actiTime.test;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.generic.GenericUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.UserListPage;

public class TC05Test extends BaseTest {
	
	@Test(priority=5)
	public void testTC05() throws InterruptedException
	{
				//user name
				String un = ExcelData.getData(File_Path, "sheet5", 1, 1);
				
				//password
				String pwd= ExcelData.getData(File_Path, "sheet5", 1, 2);
				
				//Firstname
				String fn = ExcelData.getData(File_Path, "sheet5", 1, 3);
				
				//middle name
				String mn = ExcelData.getData(File_Path, "sheet5", 1, 4);
				
				//last name
				String ln = ExcelData.getData(File_Path, "sheet5", 1, 5);
				
				//email
				String email=ExcelData.getData(File_Path, "sheet5", 1, 6);
				
				//new user
				String newUser = ExcelData.getData(File_Path, "sheet5", 1, 7);
				
				//set new password
				String newPass = ExcelData.getData(File_Path, "sheet5", 1, 8);
				
				//set once again password
				String newPassCopy = ExcelData.getData(File_Path, "sheet5", 1, 9);
				
				//working schedule
				String ws = ExcelData.getData(File_Path, "sheet5", 1, 10);
				
				//search name
				String sn = ExcelData.getData(File_Path, "sheet5", 1, 11);
				
				//verify title
				String eTitle = ExcelData.getData(File_Path, "sheet5", 1, 12);
				
							
				//enter user name
				LoginPage lp=new LoginPage(driver);
				lp.enterUserName(un);
				
				//enter password
				lp.enterPassword(pwd);
				
				//click login button
				lp.clickOnLogin();
				Reporter.log("click on login btn",true);
				
				
				Thread.sleep(3000);
				//click user menu
				EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
				ep.clickOnUser();
				
				
				//click on add user
				UserListPage up=new UserListPage(driver);
				up.clickOnAddUser();
				
				Thread.sleep(2000);
				//enter user fn
				up.enterFirstName(fn);
				
				Thread.sleep(2000);
				//enter middle name
				up.enterMiddleName(mn);
				
				Thread.sleep(2000);
				//enter lastname
				up.enterLastName(ln);
				
				Thread.sleep(2000);
				//enter email
				up.enterEmail(email);
				
				Thread.sleep(2000);
				//enter user name id
				up.enterUserName(newUser);
				
				Thread.sleep(2000);
				//enter new pass
				up.enterNewPassword(newPass);
				
				Thread.sleep(2000);
				//enter confirm pass
				up.enterConfirmPassword(newPassCopy);
				
//				Thread.sleep(2000);
//				//click on time zone
//				up.clickOnTimeZone();
				
//				Thread.sleep(3000);
//				//click on time zone london
//				up.clickOnTimeZoneLondon();
				
				Thread.sleep(2000);
				//click on work schedule
				up.clickOnCorporateSett();
				
				Thread.sleep(2000);
				//clear the work schedule
				up.clearWorkSchedule();
				
				Thread.sleep(2000);
				//enter the work schedule
				up.enterWorkSchedule(ws);
				
				Thread.sleep(2000);
				//click on enter time track cb
				up.clickOnEnterTimeTrack();
				
				Thread.sleep(2000);
				//click on manage cust and project
				up.clickOnManageCustProject();
				
				Thread.sleep(3000);
				//scroll the page
//				up.scrollPage();
//				Reporter.log("scroll the page",true);
				
				
//		  Thread.sleep(2000); 
//		  //click on create user btn 
//		  up.clickOnCreateUser();
		
		  Thread.sleep(2000); 
		  //click on cancel 
		  up.clickOnCancel();
		  
		  //click on ok javascript pop up
		  GenericUtils gu=new GenericUtils();
		gu.JavaScriptPopUp(driver);
		 
				
				Thread.sleep(2000);
				//search the created user
				up.searchUserName(sn);
			
				Thread.sleep(2000);
				//verify title
				up.verifyTitle(eTitle);
				
				Thread.sleep(2000);
				//click on logout btn
				ep.clickOnLogOut();
				
				
	}

}
