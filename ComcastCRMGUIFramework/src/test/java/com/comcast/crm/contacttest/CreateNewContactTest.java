package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.ContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactPageInfo;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;
@Listeners(com.comcast.crm.listnerutility.ListImpClass.class)
public class CreateNewContactTest extends BaseClass {

	@Test(groups={"smokeTest"})
	public  void CreateContactTest() throws IOException {
		
  String LastName =exc.getDataFromExcel("Contact", 1, 2)+jv.getRandomNumber();

           HomePage homepage=new HomePage(driver); 
	     homepage.getContactModuleLink().click();

	    ContactPage contactpage=new ContactPage(driver);
	    contactpage.getContactPlus().click();
	      
	       
	    CreateNewContactPage createContact=new CreateNewContactPage(driver);
	    createContact.createNewContact(LastName);
	    
	    CreateNewContactPageInfo head=new CreateNewContactPageInfo(driver);
	   String header= head.getheader().getText();
	  boolean status=(header.contains(LastName));
	  Assert.assertEquals(status,true);
	   
	   
	            /*  if(header.contains(LastName))
	              {
	            	  System.out.println("Contact Created");	
	              }
	              else
	              {
	            	  System.out.println("Contact not Created");
	              }*/
	}     
	              
	     @Test(groups={"regressionTest"})
	     public void CreateContactWithSupportDateTest() throws IOException {

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
	      	    String atuallastname=op.getLastnameApproval().getText();
	      	    
	      	    Assert.assertEquals(atuallastname, LastName);
	        /* if(header.equals(LastName))
	         {
	       	  System.out.println("Contact Created");
	       	  }
	         else
	         {
	       	  System.out.println("Contact not Created");
	         }*/
	       String Actualstart=op.getStart().getText();


	       Assert.assertEquals(Actualstart,StartDate);

	      	       	  /* if(start.equals(StartDate))
	      	              {
	      	            	  System.out.println(StartDate+" "+" Date Created");
	      	            	  }
	      	              else
	      	              {
	      	            	  System.out.println(" Date  not Created");
	      	              }*/
	              }
    @Test(groups={"regressionTest"})
    public void CreateContactWithOrgnasationTest() throws IOException {

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
  boolean status1=(header.contains(OrgnaisationName));
  Assert.assertEquals(status1, true);
	/*if(header.contains(OrgnaisationName))
	   {
		   System.out.println(OrgnaisationName+" "+"Created");
	   }
	   else
	   {
		   System.out.println("OrganisationName Not Created");
	   }
    */
	
    homepage.getContactModuleLink().click();

   ContactPage contactpage=new ContactPage(driver);
   contactpage.getContactPlus().click();
     
      
   CreateNewContactPage createContact=new CreateNewContactPage(driver);
   createContact.createnewContact(ContactlastNamee);
   
   createContact.switchToWindow(OrgnaisationName,driver, "module=Accounts");
   createContact.switchToParentWindow(driver,"module=Contacts&action");
      
   
		createContact.getSave().click();
		 
		 String lastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		 Assert.assertEquals(lastName, ContactlastNamee);
		 /*
		 if(lastName.equals(ContactlastNamee))
		 {
			 System.out.println(ContactlastNamee+" "+"LAST NAME IS CREATED");
		 }
		 else
		 {
			 System.out.println(ContactlastNamee+" "+"LAST NAME IS not CREATED");
		 }*/

    }
    	
    }
	       