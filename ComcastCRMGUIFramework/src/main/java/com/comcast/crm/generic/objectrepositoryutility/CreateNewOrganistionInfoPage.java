package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganistionInfoPage {
		WebDriver driver;
		public CreateNewOrganistionInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement header;
		
		public WebElement getHeader() {
			return header;
		}
			
	@FindBy(xpath="//font[text()='Energy']")
	private WebElement industryHeader;
	
	public WebElement getIndustryHeader() {
		return industryHeader;
	}
	@FindBy(id="mouseArea_Phone")
	private WebElement TypeHeader;
	
	public WebElement getTypeHeader() {
		return TypeHeader;
	}
		@FindBy(id="dtlview_Phone")
		private WebElement ActualPhonenumber;
		
		public WebElement getActualPhonenumber() {
			return ActualPhonenumber;
		
		}


		
		
		

}
