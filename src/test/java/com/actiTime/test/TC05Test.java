package com.actiTime.test;


import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.generic.GenericUtils;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.UserListPage;

public class TC05Test extends BaseTest {
	
	@Test(priority=2)
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
				Reporter.log("UserName :"+un,true);
				
				//enter password
				lp.enterPassword(pwd);
				Reporter.log("Password :"+pwd,true);
				
				//click login button
				lp.clickOnLogin();
				Reporter.log("click on login button",true);
				
				
				Thread.sleep(3000);
				//click user menu
				EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
				ep.clickOnUser();
				Reporter.log("Click on UserMenu :",true);
				
				
				
				//click on add user
				UserListPage up=new UserListPage(driver);
				up.clickOnAddUser();
				Reporter.log("Click on Add user button :",true);
				
				Thread.sleep(2000);
				//enter user fn
				up.enterFirstName(fn);
				Reporter.log("Enter first name :"+fn,true);
				
				Thread.sleep(2000);
				//enter middle name
				up.enterMiddleName(mn);
				Reporter.log("Enter middle name :"+mn,true);
				
				Thread.sleep(2000);
				//enter lastname
				up.enterLastName(ln);
				Reporter.log("Enter last name :"+ln,true);
				
				
				Thread.sleep(2000);
				//enter email
				up.enterEmail(email);
				Reporter.log("Enter email id :"+email,true);
				
				
				Thread.sleep(2000);
				//enter user name id
				up.enterUserName(newUser);
				Reporter.log("Enter user name :"+newUser,true);
				
				
				Thread.sleep(2000);
				//enter new pass
				up.enterNewPassword(newPass);
				Reporter.log("Enter password :"+newPass,true);
				
				
				Thread.sleep(2000);
				//enter confirm pass
				up.enterConfirmPassword(newPassCopy);
				Reporter.log("Enter confirm password :"+newPassCopy,true);
				
				
				
				//click on time zone
				up.clickOnTimeZone();
				
				
				//click on time zone london
				up.clickOnTimeZoneLondon();
				
				Thread.sleep(3000);
				up.clickOnDate();
				Reporter.log("Click on Date picker :",true);
				
					
				Thread.sleep(3000);
				//scroll the page
				// GenericUtils.scrollVertical(driver);
				 GenericUtils.scrollByVisibleElement(up.getWorkScheduleCB(), driver);
				 Reporter.log("scroll the page :",true);
					
				
				
				Thread.sleep(2000);
				//click on work schedule
				up.clickOnCorporateSett();
				Reporter.log("clickOnCorporateSett :",true);
				
				
				Thread.sleep(2000);
				//clear the work schedule
				up.clearWorkSchedule();
				Reporter.log("clearWorkSchedule :",true);
								
				Thread.sleep(2000);
				//enter the work schedule
				up.enterWorkSchedule(ws);
				Reporter.log("enterWorkSchedule :"+ws,true);
				
				
				 
				 
				Thread.sleep(2000);
				//click on enter time track cb
				up.clickOnEnterTimeTrack();
				Reporter.log("clickOnEnterTimeTrack :",true);
				
				
				
				Thread.sleep(2000);
				//click on manage cust and project
				up.clickOnManageCustProject();
				Reporter.log("clickOnManageCustProject :",true);
				

				
				
//		  Thread.sleep(2000); 
//		  //click on create user btn 
//		  up.clickOnCreateUser();
//				Reporter.log("clickOnCreateUser :",true);
				
				
		
		  Thread.sleep(3000); 
		  //click on cancel 
		  up.clickOnCancel();
		  Reporter.log("clickOnCancel :",true);
			
		  
		  //click on ok javascript pop up
		  GenericUtils.JavaScriptPopUp(driver);
		  Reporter.log("JavaScriptPopUp :",true);
			
				
				Thread.sleep(2000);
				//search the created user
				up.searchUserName(sn);
				 Reporter.log("searchUserName :"+sn,true);
					
			
				Thread.sleep(2000);
				//verify title
				up.verifyTitle(eTitle);
				 Reporter.log("verifyTitle :"+eTitle,true);
					
				
				Thread.sleep(2000);
				//click on logout btn
				ep.clickOnLogOut();
				Reporter.log("clickOnLogOut :",true);
				
				
				
	}

}
