package com.comcast.crm.contacttest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.ContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactPageInfo;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;



public class CreateContactWithSupportDateTest extends BaseClass{
	@Test
	public void CreateContactWithSupportTest() throws IOException {
		 
		String LastName=exc.getDataFromExcel("Contact", 4, 2)+jv.getRandomNumber();
            String StartDate=jv.getSystemDate();
            String End=jv.getRequireDate(30); 

 HomePage homepage=new HomePage(driver); 
	     homepage.getContactModuleLink().click();

	    ContactPage contactpage=new ContactPage(driver);
	    contactpage.getContactPlus().click();
	      
	     CreateNewContactPage createcontact=new  CreateNewContactPage(driver);
	    createcontact.createNewContact(LastName, StartDate, End);
	    
	    
	    CreateNewContactPageInfo op=new CreateNewContactPageInfo(driver);
	    String header=op.getLastnameApproval().getText();
   if(header.equals(LastName))
   {
 	  System.out.println("Contact Created");
 	  }
   else
   {
 	  System.out.println("Contact not Created");
   }
 String start=op.getStart().getText();
	       	   if(start.equals(StartDate))
	              {
	            	  System.out.println(StartDate+" "+" Date Created");
	            	  }
	              else
	              {
	            	  System.out.println(" Date  not Created");
	              }
	}
}
