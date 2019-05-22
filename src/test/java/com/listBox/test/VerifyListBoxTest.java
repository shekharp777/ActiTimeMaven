package com.listBox.test;

import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.pages.ListBoxPage;

public class VerifyListBoxTest extends BaseTest {
	
	@Test(priority=1)
	public void testVerifyListBox()
	{
		ListBoxPage lb=new ListBoxPage(driver);
		lb.clickOnListbox();
		
		
	}

}
