package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;

public class CreateNewOrganistionTest extends BaseClass {
	@Test(groups={"smokeTest"})
	public void CreateNewOrgTest() throws IOException {

		String OrgnaisationName = exc.getDataFromExcel("ORg", 1, 2) + jv.getRandomNumber();

		HomePage homepage = new HomePage(driver);
		homepage.getOrganisationModuleLink().click();

		OrganisationPage Og = new OrganisationPage(driver);
		Og.getPlusIcon().click();

		CreateNewOrganistionPage og = new CreateNewOrganistionPage(driver);
		og.createNewOrganisation(OrgnaisationName);
		og.getSave();

		CreateNewOrganistionInfoPage oip = new CreateNewOrganistionInfoPage(driver);
		String header = oip.getHeader().getText();

		boolean Status1=(header.contains(OrgnaisationName)); 
		System.out.println( header);
		System.out.println(OrgnaisationName);
		
		 Assert.assertEquals(Status1, true);
	/*	{
			System.out.println(OrgnaisationName + " " + "Created");
		} else {
			System.out.println("OrganisationName Not Created");
		}*/
	}
	@Test(groups={"regressionTest"})
	 public void CreateOrgWithIndustrytypeTest() throws IOException {
		 


	    String OrgnaisationName=exc.getDataFromExcel("ORg", 4, 2).toString()+jv.getRandomNumber();
	    String Industryname=exc.getDataFromExcel("ORg", 4, 3).toString();
	    String type=exc.getDataFromExcel("ORg", 4, 4).toString();



	    HomePage Hp=new HomePage(driver);
		Hp.getOrganisationModuleLink().click();

		OrganisationPage Og=new OrganisationPage (driver);
		Og.getPlusIcon().click();	
		
		CreateNewOrganistionPage og=new CreateNewOrganistionPage(driver);
		og.createNewOrganisation(Industryname, OrgnaisationName, type);
		

		CreateNewOrganistionInfoPage oip=new CreateNewOrganistionInfoPage(driver);
		String header=oip.getHeader().getText();
		boolean Status2=(header.contains(OrgnaisationName)); 
		 Assert.assertEquals(Status2,true);
	/*if(header.contains(OrgnaisationName))
		   {
			   System.out.println(OrgnaisationName+" "+"Created");
		   }
		   else
		   {
			   System.out.println("OrganisationName Not Created");
		   }
*/
			 
	      String industryHeader=oip.getIndustryHeader().getText();
	      SoftAssert soft=new SoftAssert();
         soft.assertEquals(industryHeader,Industryname);
	        /*    if(industryHeader.equals(Industryname))
	            {
	            	System.out.println(Industryname+" SELECTED");
	            }
	            else
	            {
	            	System.out.println("NOT SELECTED");
	            }*/
	            String Typeheader=oip.getTypeHeader().getText();
	            soft.assertEquals(Typeheader, type);
	          /*  System.out.println(Typeheader);	            
	            if(Typeheader.equals(type))
	            {
	            	System.out.println(type+" SELECTED");
	            }
	            else
	            {
	            	System.out.println("NOT SELECTED");
	 */           }
	
	@Test(groups={"regressionTest"})
	public void CreateNewOrgWithPhoneNumberTest() throws IOException  {

    String OrgnaisationName=exc.getDataFromExcel("ORg", 7, 2)+jv.getRandomNumber();
		    String IndustryName=exc.getDataFromExcel("ORg", 4, 3).toString();
		    String PhoneNumber=exc.getDataFromExcel("ORg", 7, 3);
	              


   
		HomePage Hp=new HomePage(driver);
		Hp.getOrganisationModuleLink().click();

		OrganisationPage Og=new OrganisationPage (driver);
		Og.getPlusIcon().click();	
		


		
		CreateNewOrganistionPage ogg=new CreateNewOrganistionPage(driver);
		ogg.createNewOranisation(OrgnaisationName, PhoneNumber, IndustryName);

		CreateNewOrganistionInfoPage oip=new CreateNewOrganistionInfoPage(driver);
		String header=oip.getHeader().getText();
		boolean Status3=(header.contains(OrgnaisationName)); 
		 Assert.assertEquals(Status3, true);
	/*if(header.contains(OrgnaisationName))
		   {
			   System.out.println(OrgnaisationName+" "+"Created");
		   }
	             else
		   {
			   System.out.println("NOT CREated");
		   }
	*/
	String ActualPhonenumber=oip.getActualPhonenumber().getText();
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(ActualPhonenumber, PhoneNumber);
	/*if(ActualPhonenumber.equals(PhoneNumber))
		   {
			   System.out.println(PhoneNumber+" "+"Created");
		   }
		   else
		   {
			   System.out.println("Phone Number Not Created");
		   }
*/


		           
	 }
	}


