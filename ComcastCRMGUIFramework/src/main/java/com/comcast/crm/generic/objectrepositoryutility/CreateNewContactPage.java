package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {
	WebDriverUtility wb=new WebDriverUtility();
		WebDriver driver;
		public CreateNewContactPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(name="lastname")
		private WebElement lastname;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement Save;
		public WebElement getLastName() {
			return lastname;
		}
		 public WebElement getLastname() {
				return lastname;
			}			
	      
	      @FindBy(name="support_start_date")
	      private WebElement SupportDate;
	      
	      public WebElement getSupportDate() {
				return SupportDate;
			}
	      
	      @FindBy(name="support_end_date")
	      private WebElement EndDate;
	      
	      public WebElement getEndDate() {
				return EndDate;
			}
		
		public WebElement getSave() {
			return Save;
		}
      
	@FindBy(xpath="//img[@style='cursor:hand;cursor:pointer']")
	private WebElement plusSibling;
		
	      public WebElement getPlusSibling() {
		return plusSibling;
	}
	      @FindBy(id="1")
		  	private WebElement org;
	      public WebElement getorg() {
		      	return org;
		      }
	      
	      @FindBy(id="search_txt")
	  	private WebElement search;
	  		
	      public WebElement getsearch() {
		      	return search;
		      }
	      @FindBy(name="search_field")
	      private WebElement searchDD;
	      
	      public WebElement getsearchDD() {
	      	return searchDD;
	      }
	      @FindBy(name="search")
	      private WebElement searchBtn;

	      public WebElement getsearcBtn() {
	      	return searchBtn;
	      }
	      
	public void setPlusSibling(WebElement plusSibling) {
		this.plusSibling = plusSibling;
	}
		public void createnewContact(String ContactlastNamee)
	      {
	    	  lastname.sendKeys(ContactlastNamee);
	    	 
	      }
	      public void createNewContact(String LastName)
	      {
	    	  lastname.sendKeys(LastName);
	    	  Save.click();
	      }
	      
	     
	      public void createNewContact(String LastName,String StartDate,String End)
	      {
	    	  lastname.sendKeys(LastName);
	    	 SupportDate.clear();
	    	 SupportDate.sendKeys(StartDate);
	    	 EndDate.clear();
	    	 EndDate.sendKeys(End);
	    	 Save.click();
	      }

	      public void switchToWindow(String OrgnaisationName,WebDriver driver,String PartialUrl)
	      {
	    	   getPlusSibling().click();
	    	   wb.browseToNewTab(driver, PartialUrl);
	    	   search.sendKeys(OrgnaisationName);
	    	   searchBtn.click();
	    	   org.click();
	    	   
	    	   
	      }
	      public void switchToParentWindow(WebDriver driver,String ParentUrl) {
	    	  wb.browseToNewTab(driver, ParentUrl);
	      }



	      

	     

} 


