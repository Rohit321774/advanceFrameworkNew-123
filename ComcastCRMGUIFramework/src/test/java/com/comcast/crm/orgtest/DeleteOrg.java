package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganistionPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganisationPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DeleteOrg extends BaseClass {
	@Test
	public void Deleteorg() throws IOException {



	    String OrgnaisationName=exc.getDataFromExcel("ORg", 10, 2)+jv.getRandomNumber();


   
		HomePage Hp=new HomePage(driver);
		Hp.getOrganisationModuleLink().click();

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
		
		//back to OrganisationModule
		Hp.getOrganisationModuleLink().click();
		OrganisationPage og1=new OrganisationPage(driver);
		og1.getsearch().sendKeys(OrgnaisationName);
		wb.selectByText(og1.getsearchDD(),"Organization Name");
		og1.getsearcBtn().click();

driver.findElement(By.xpath("//a[text()='"+OrgnaisationName+"']/../../td[8]/a[text()='del']")).click();
		
	}
}
