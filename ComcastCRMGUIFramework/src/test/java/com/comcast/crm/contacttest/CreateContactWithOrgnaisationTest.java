package com.comcast.crm.contacttest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.ContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;

public class CreateContactWithOrgnaisationTest extends BaseClass {
	@Test
	public void CreateContactWithOrgTest() throws IOException {



		     String OrgnaisationName=exc.getDataFromExcel("Contact", 7, 2)+jv.getRandomNumber();
	                  String ContactlastNamee=exc.getDataFromExcel("Contact", 7, 3)+jv.getRandomNumber();
	                  


		HomePage homepage=new HomePage(driver);
		homepage.getOrganisationModuleLink().click();

		OrganisationPage Og=new OrganisationPage (driver);
		Og.getPlusIcon().click();	
		
		CreateNewOrganistionPage og=new CreateNewOrganistionPage(driver);
		og.createNewOrganisation(OrgnaisationName);
		og.getSave();
		

		CreateNewOrganistionInfoPage oip=new CreateNewOrganistionInfoPage(driver);
		String header=oip.getHeader().getText();

		if(header.contains(OrgnaisationName))
		   {
			   System.out.println(OrgnaisationName+" "+"Created");
		   }
		   else
		   {
			   System.out.println("OrganisationName Not Created");
		   }
     //navigate to Contact module
		
	     homepage.getContactModuleLink().click();

	    ContactPage contactpage=new ContactPage(driver);
	    contactpage.getContactPlus().click();
	      
	       
	    CreateNewContactPage createContact=new CreateNewContactPage(driver);
	    createContact.createnewContact(ContactlastNamee);
	    
	    createContact.switchToWindow(OrgnaisationName,driver, "module=Accounts");
	    createContact.switchToParentWindow(driver,"module=Contacts&action");
	       
	    
			createContact.getSave().click();
			 
			 String lastName=driver.findElement(By.id("dtlview_Last Name")).getText();
			 if(lastName.equals(ContactlastNamee))
			 {
				 System.out.println(ContactlastNamee+" "+"LAST NAME IS CREATED");
			 }
			 else
			 {
				 System.out.println(ContactlastNamee+" "+"LAST NAME IS not CREATED");
			 }
	}
}

