package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	WebDriver driver;	
	public OrganisationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement PlusIcon;
	
	public WebElement getPlusIcon() {
		return PlusIcon;
		}
	
@FindBy(name="search_text")
private WebElement search;
public WebElement getsearch() {
	return search;
}

@FindBy(name="search_field")
private WebElement searchDD;
public WebElement getsearchDD() {
	return searchDD;
}

@FindBy(name="submit")
private WebElement searchBtn;

public WebElement getsearcBtn() {
	return searchBtn;
}
}
