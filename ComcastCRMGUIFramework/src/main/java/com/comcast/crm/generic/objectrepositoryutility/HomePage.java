package com.comcast.crm.generic.objectrepositoryutility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	 public HomePage(WebDriver driver)
	 {
		  
		  PageFactory.initElements(driver,this);
		  this.driver=driver;
	 }
	 @FindBy(linkText="Organizations")
	 private WebElement OrganisationModuleLink;
	 
	public WebElement getOrganisationModuleLink() {
		return OrganisationModuleLink;
	}
	@FindBy(linkText="Contacts")
	 private WebElement ContactModuleLink;
	
	public WebElement getContactModuleLink() {
		return ContactModuleLink;
	}

	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Image;
	
	public WebElement getImage() {
		return Image;
	}

	@FindBy(linkText="Sign Out")
	private WebElement signout;

public WebElement getSignout() {
		return signout;
	}

 @FindBy(linkText="More")
 private WebElement MoreLink;
 
 public WebElement getGetMoreLink() {
		return MoreLink;
	}
 
 
 
	/*
	 * public void navigateToCampaignLink() { Actions act=new Actions(driver);
	 * act.moveToElement(MoreLink).build().perform(); campaignLink.click(); }
	 */
public void appSignOut() {
	Image.click();
	signout.click();
}








}
