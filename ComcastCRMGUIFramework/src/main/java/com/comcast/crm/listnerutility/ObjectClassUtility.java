package com.comcast.crm.listnerutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

// for parallel Execution with listerner without this it will be diffcult to execute it

public class ObjectClassUtility {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest) { 
		test.set(actTest);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver) { 
		driver.set(actDriver);
	}




	
}
