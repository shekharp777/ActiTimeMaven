package com.actiTime.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.actiTime.generic.BasePage;

public class ListBoxPage extends BasePage {

	//declaration
	@FindBy(id="slv")
	private WebElement lBox;
	
	
	//Initialization
	public ListBoxPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
			
	}
	
	//Utilization
	public void clickOnListbox()
	{
		
		selectByIndex(lBox,2);
		selectByValue(lBox,"d");
		SelectByVisibleText(lBox,"sev Poori");
		
		VerifyListboxSortedOrder(lBox);
		VerifyDuplicateListbox(lBox);
		displayDuplicateListbox(lBox);	
		
	}
	

	
}
