package com.comcast.crm.orgtest;

import org.testng.Assert;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listnerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Execute the  create Invoice Test");
		String tilte=driver.getTitle();
		Assert.assertEquals( tilte,"login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test
	public void createInvoiceContactTest()
	{
		System.out.println("Execute the  create Invoice Contact Test");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

}
