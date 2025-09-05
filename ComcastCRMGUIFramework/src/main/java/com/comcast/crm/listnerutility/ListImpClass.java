package com.comcast.crm.listnerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener {
	WebDriver driver;
 public	ExtentReports report;
  ExtentTest test; 
	@Override
	public void onStart(ISuite context)
	{

		 System.out.println("Report Configuration");
		 String Time= new Date().toString().replace(" ","_").replace(":","_");
		 ExtentSparkReporter spark=new  ExtentSparkReporter("./AdvanceReport/report.html"+"_"+Time);
		 
		  spark.config().setDocumentTitle("CRM APPLICATION");
		  spark.config().setReportName("CRM");
		  spark.config().setTheme(Theme.DARK);
		   
		   report=new ExtentReports();
		    report.attachReporter(spark);
		    report.setSystemInfo("WINDOW", "OS");
		    report.setSystemInfo("Browser", "Chrome");
		    report.setSystemInfo("Version", "10.2.2");
		    
	}

	@Override
	public void onFinish(ISuite context) 
	{
		System.out.println("Report BackUp");
		 
              report.flush();
	}

	@Override
	public void onTestStart(ITestResult result)
	{
         test=report.createTest(result.getMethod().getMethodName());
		 test.log(Status.INFO,result.getMethod().getMethodName()+"STARTED");
   
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,result.getMethod().getMethodName()+"THIS TEST Execution IS Success");

	}
	@Override
	public void onTestFailure(ITestResult result) 
	{  
		test.log(Status.FAIL,result.getMethod().getMethodName()+"THIS TEST Execution IS FALIED");

		 String MethodName=result.getMethod().getMethodName();
		 String Time= new Date().toString().replace(" ","_").replace(":","_");
		 TakesScreenshot tks = (TakesScreenshot) BaseClass.Sdriver;
		    String filepath=tks.getScreenshotAs(OutputType.BASE64);
		      
		    test.addScreenCaptureFromBase64String(filepath,MethodName+" "+Time);
		     
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{

       test.log(Status.SKIP,result.getMethod().getMethodName()+" "+"");

	}



	

}
