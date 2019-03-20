package com.actiTime.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.LoginPage;

public class TC03Test extends BaseTest {
	
	@Test(priority=4)
	public void testTC03()
	{
		//version data
		String eVersion=ExcelData.getData(File_Path, "sheet3", 1, 0);
		
		LoginPage lp=new LoginPage(driver);
		
		lp.verifyVersion(eVersion);
		
		
	}
	

}
