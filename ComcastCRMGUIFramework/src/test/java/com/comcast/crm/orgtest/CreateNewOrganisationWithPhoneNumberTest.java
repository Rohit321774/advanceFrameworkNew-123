package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;

public class CreateNewOrganisationWithPhoneNumberTest extends BaseClass{
	@Test
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
	if(header.contains(OrgnaisationName))
		   {
			   System.out.println(OrgnaisationName+" "+"Created");
		   }
	             else
		   {
			   System.out.println("NOT CREated");
		   }
	
	String ActualPhonenumber=oip.getActualPhonenumber().getText();
	if(ActualPhonenumber.equals(PhoneNumber))
		   {
			   System.out.println(PhoneNumber+" "+"Created");
		   }
		   else
		   {
			   System.out.println("Phone Number Not Created");
		   }



		           
	 }
	}