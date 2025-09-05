package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/** 
 * test class for the login page
 * Contains login page WebElement and liberies
 * 
 * @author Rohit
 * 
 */
public class LoginPage {
	WebDriver driver;
	WebDriverUtility wb=new WebDriverUtility();
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}

	@FindBy(xpath="//input[@name='user_name']")
			private WebElement User;
	
	@FindBy(name="user_password")
	private WebElement Pass;
	
	@FindBy(id="submitButton")
	private WebElement loginButn;
	

	public WebElement getUsername() {
		return User;
	}




	public WebElement getPassword() {
		return Pass;
	}



	public WebElement getLoginButn() {
		return loginButn;
	}
//Business Urility
	/**
	 * @param Url
	 * @param Username
	 * @param Password
	 * @throws InterruptedException
	 */
public void loginToApp(String Url,String Username,String Password) throws InterruptedException

{
    driver.get(Url);
 wb.maximizeWindow(driver);
 wb.toLoadPage(driver);
	//Thread.sleep(5000);
	User.sendKeys(Username);
	Pass.sendKeys(Password);
	loginButn.click();
}
	
}

