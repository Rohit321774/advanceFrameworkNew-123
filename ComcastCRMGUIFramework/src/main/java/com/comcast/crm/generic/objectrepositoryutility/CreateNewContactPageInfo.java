package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPageInfo {
	WebDriver driver;
	public CreateNewContactPageInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="dtlview_Last ")
	private WebElement lastname;
	
	public WebElement getlastname() {
		return lastname;
	}
	
			@FindBy(id="dtlview_Last Name")
			private WebElement lastnameApproval;
	
	@FindBy(id="dtlview_Last Name")
			private WebElement header;
			
			public WebElement getLastnameApproval() {
		return lastnameApproval;
	}




			public WebElement  getheader() {
				return  header;
			}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement start;
	
	public WebElement getStart() {
		return start;
	}
		
	//	@FindBy(id="dtlview_Support End Date")
		//private WebElement Starthaeder;
		
	//	public WebElement getstateDate() {
		//	return Starthaeder;
	}


