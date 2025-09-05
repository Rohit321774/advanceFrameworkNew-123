package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public  void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void toLoadPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void getElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void browseToNewTab(WebDriver driver,String PartialUrl) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{ String windowid=it.next();
		 driver.switchTo().window(windowid);
		 
		 String ActualUrl=driver.getCurrentUrl();
		 if(ActualUrl.contains(PartialUrl))
		 {
			 break;
		 }
			 
		}
	}
		
	public void browseBackToParentWindow(WebDriver driver,String ParentUrl) {
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> it1=set1.iterator();
		while(it1.hasNext())
		{ String windowid=it1.next();
		 driver.switchTo().window(windowid);
		 
		 String ActualUrl1=driver.getCurrentUrl();
		 if(ActualUrl1.contains(ParentUrl))
		 {
			 break;
		 }
			 
		}
	}
		public void switchToFrame(WebDriver driver1,int index) {
			driver1.switchTo().frame(index);
		}
	
	     public void switchToFrame(WebDriver driver,String name) {
	    	 driver.switchTo().frame(name);
	     }
	     public void switchToFrame(WebDriver driver,WebElement element) {
	    	 driver.switchTo().frame(element);
	     }
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void switchToAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
			public void selectByText(WebElement element,String text) {
				Select sel=new Select(element);
				sel.selectByVisibleText(text);
			}
		

			public void selectByIndex(WebElement element,int index) {
				Select sel=new Select(element);
				sel.selectByIndex(index);
			}
			public void selectByValue(WebElement element,String value) {
				Select sel=new Select(element);
				sel.selectByValue(value);
			}
			
			public void moveToElement(WebDriver driver,WebElement Element) {
				Actions act=new Actions(driver);
				act.moveToElement(Element).perform();
			}
			public void doubleClick(WebDriver driver,WebElement element) {
				Actions act=new Actions(driver);
				act.doubleClick(element).perform();
			}
		
		
}
