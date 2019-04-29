package com.actiTime.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actiTime.generic.BasePage;

public class UserListPage extends BasePage {

	//declaration
	@FindBy(xpath="//div[.='Add User' and @class='buttonText']")
	private WebElement addUserBTN;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstNameTB;
	
	@FindBy(xpath="//input[@name='middleName']")
	private WebElement middleNameTB;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTB;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement newUserTB;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement newPassTB;
	
	@FindBy(xpath="//input[@name='passwordCopy']")
	private WebElement confirmPassTB;
	
	@FindBy(xpath="//button[@id='ext-gen139']")
	private WebElement timeZoneDD;
	
	@FindBy(xpath="//div[.='GMT +10:00']")
	private WebElement selectTimeZoneDD;
	
	@FindBy(xpath="//table[@cellspacing='4']//input[@type='checkbox']")
	private WebElement workScheduleCB;
	
	@FindBy(xpath="(//input[@type='text'])[12]")
	private WebElement clearWorkScheduleTB;
	
	@FindBy(xpath="(//input[@type='text'])[12]")
	private WebElement enterWorkScheduleTB;
	
	@FindBy(xpath="//input[@id='userDataLightBox_submitTimeTrackChBox']")
	private WebElement enterTimeTrackCB;
	
	@FindBy(xpath="//input[@id='userDataLightBox_manageCustomersProjectsChBox']")
	private WebElement manageCustProjectCB;
	
	@FindBy(xpath="//span[.='Create User']")
	private WebElement createUserBTN;
	
	@FindBy(xpath="//input[@placeholder='Start typing name']")
	private WebElement searchUserTB;

	@FindBy(xpath="//div[.='Cancel' and @class='greyButton cancelBtn']")
	private WebElement cancelBTN;
	
	@FindBy(xpath="//span[.='Create User']")
	private WebElement scrollElement;

	@FindBy(xpath="//button[@id='ext-gen149']")
	private WebElement dateBox;
	
	@FindBy(xpath="//table[@class='x-date-inner']//td")
	private List<WebElement> allDates;
	
	@FindBy(xpath="//span[.='pakale']")
	private WebElement selectUserToDelete;
	
	@FindBy(xpath="//button[@id='userDataLightBox_deleteBtn']")
	private WebElement deleteBTN;
	
	
	
	//initialization
	public UserListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	//click on add user button
	public void clickOnAddUser()
	{
		addUserBTN.click();
	}
	
	//enter fn
	public void enterFirstName(String fn)
	{
		firstNameTB.sendKeys(fn);
	}
			
	//enter mn
	public void enterMiddleName(String mn)
	{
		middleNameTB.sendKeys(mn);
	}
	
	public void enterLastName(String ln)
	{
		lastNameTB.sendKeys(ln);
	}
	
	public void enterEmail(String email)
	{
		emailTB.sendKeys(email);
	}
	
	public void enterUserName(String newUser)
	{
		newUserTB.sendKeys(newUser);
	}
	
	public void enterNewPassword(String newPass)
	{
		newPassTB.sendKeys(newPass);
	}
	
	public void enterConfirmPassword(String newPassCopy)
	{
		confirmPassTB.sendKeys(newPassCopy);
	}
	
	public void clickOnTimeZone() throws InterruptedException
	{
		
		Thread.sleep(2000);
		timeZoneDD.click();
	}
	
	public void clickOnTimeZoneLondon()
	{
		selectTimeZoneDD.click();
	}
	
	public void clickOnDate() throws InterruptedException
	{
		//Fill date as mm/dd/yyyy as 09/25/2013

		dateBox.click();
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("20"))
			{
				ele.click();
				break;
			}
			Reporter.log("Click on Date picker :",true);
		}

		
	}
	
	
	public void clickOnCorporateSett()
	{
		getWorkScheduleCB().click();
	}
	
	public void clearWorkSchedule()
	{
		clearWorkScheduleTB.clear();
	}
	

	public void enterWorkSchedule(String ws)
	{
		enterWorkScheduleTB.sendKeys(ws);
	}
	
	public void clickOnEnterTimeTrack()
	{
		enterTimeTrackCB.click();
	}
	

	
	public void clickOnManageCustProject()
	{
		manageCustProjectCB.click();
	}
	

	public void clickOnCreateUser()
	{
		createUserBTN.click();
	}
	
	
	
	public void clickOnCancel()
	{
		cancelBTN.click();
	}
	
	public void searchUserName(String sn)
	{
		searchUserTB.sendKeys(sn);
	}
	
	public void selectUser()
	{
		selectUserToDelete.click();
	}
	
	public void clickOnDeleteBTN()
	{
		deleteBTN.click();
	}
	
	public void clearSearchText()
	{
		searchUserTB.clear();
	}
	
	public void verifyingTitle(String eTitle)
	{
		verifyTitle(eTitle);	
		
	}


	
	//To access private variable we have to use getter setter method.
	public WebElement getWorkScheduleCB() {
		return workScheduleCB;
	}


	public void setWorkScheduleCB(WebElement workScheduleCB) {
		this.workScheduleCB = workScheduleCB;
	}
}
