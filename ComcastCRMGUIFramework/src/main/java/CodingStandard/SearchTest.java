package CodingStandard;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;

/**
 * test class from contact module
 * @author Rohit
 * 
 */

public class SearchTest extends BaseClass {
	/**We can write Scenario also
	 * login>>navigate to Contact>>then Create new Contact
	 * 
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void searchcontactTest() throws InterruptedException {
		// login to the app
		 LoginPage lp=new LoginPage(driver);
		lp.loginToApp("Url","Username","Password");
		
	}
	

}
