package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganistionPage {
	WebDriver driver;
	public CreateNewOrganistionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement Orgname;
	
	@FindBy(name="industry")
	private WebElement  Industry;
	
	@FindBy(name="accounttype")
	private WebElement  Type;
	
	 public WebElement getIndustry() {
			return Industry;
		}

		public WebElement getType() {
			return Type;
		}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Save;
	
	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getSave() {
		return Save;
	}
	@FindBy(id="phone")
	 private WebElement Phonenumber;
	 
	 
	public void createNewOrganisation(String OrgnaisationName) {
		Orgname.sendKeys(OrgnaisationName);
		Save.click();
	}
	
	public WebElement getPhoneNumber() {
		return Phonenumber;
	}

	public void createNewOrganisation( String Industryname,String OrgnaisationName,String type)
	{Orgname.sendKeys(OrgnaisationName);
		Select sel=new Select(Industry);
	  sel.selectByValue(Industryname);
	  Select sel1=new Select(Type);
	  sel1.selectByValue(type);
	  Save.click();
	}	
	
	
	public void createNewOranisation(String OrgnaisationName,String PhoneNumber ,String Industryname)
	{
		Orgname.sendKeys(OrgnaisationName);
		Select sel=new Select(Industry);
	  sel.selectByValue(Industryname);


	  Phonenumber.sendKeys(PhoneNumber);
	  Save.click();
	}	
}