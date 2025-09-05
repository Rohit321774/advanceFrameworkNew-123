package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listnerutility.ObjectClassUtility;

public class BaseClass {
	public DatabaseUtility db = new DatabaseUtility();
	public FileUtility file = new FileUtility();
	public ExcelUtility exc = new ExcelUtility();
	public JavaUtility jv = new JavaUtility();
	public WebDriverUtility wb = new WebDriverUtility();
	public   WebDriver driver = null;
	public   static WebDriver Sdriver = null;

	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void ConfigBS() throws SQLException {
		System.out.println("DataBase Connection, Report Configuration");
		db.getDatabaseConnectionOg();
	}
	
	 @Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void ConfigBC() throws IOException, InterruptedException {

		System.out.println("Launch Browser");
		String Browser = file.getDataFromPropertiesFile("Browser");
		if (Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		Sdriver=driver;
		ObjectClassUtility.setDriver(driver);
	}

	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void ConfigBM() throws IOException, InterruptedException {
		System.out.println("Login to the Application");
		String Url = file.getDataFromPropertiesFile("Url");
		String User = file.getDataFromPropertiesFile("Username");
		String Pass = file.getDataFromPropertiesFile("Password");

		LoginPage login = new LoginPage(driver);
		login.loginToApp(Url, User, Pass);

}

	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void ConfigAM() throws InterruptedException {
		System.out.println("Logout to the Application");
		HomePage homepage = new HomePage(driver);
	//	Thread.sleep(2000);
	
		homepage.appSignOut();
		

	}

	@AfterClass(groups={"smokeTest","regressionTest"})
	public void ConfigAC() {

		System.out.println("Close The Browser");
		driver.quit();
	}

	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void ConfigAS() throws SQLException {
		System.out.println("DataBase Connection close, Report Configuration,Report backUp");
		db.closeDatabase();
	}
}
