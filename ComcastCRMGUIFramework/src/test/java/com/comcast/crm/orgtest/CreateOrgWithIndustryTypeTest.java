package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;

public class CreateOrgWithIndustryTypeTest extends BaseClass {
	@Test
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

	if(header.contains(OrgnaisationName))
	   {
		   System.out.println(OrgnaisationName+" "+"Created");
	   }
	   else
	   {
		   System.out.println("OrganisationName Not Created");
	   }

		 
      String industryHeader=oip.getIndustryHeader().getText();
            if(industryHeader.equals(Industryname))
            {
            	System.out.println(Industryname+" SELECTED");
            }
            else
            {
            	System.out.println("NOT SELECTED");
            }
            String Typeheader=oip.getTypeHeader().getText();
            if(Typeheader.equals(type))
            {
            	System.out.println(type+" SELECTED");
            }
            else
            {
            	System.out.println("NOT SELECTED");
            }



      

}
}