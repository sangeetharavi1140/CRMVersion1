package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import genaralUtility.BaseClass;
import genaralUtility.WebDriverUtility;
import objectRepositry.HomePage;

public class CreateOrganizationTest extends BaseClass{ 

	@Test(groups="smoke testing")
	public void createOrgVerifyTest() throws Throwable
	{
		
		
		HomePage hp=new HomePage( driver);
		hp.getOrgLnk();
	//	WebDriverUtility wutil=new WebDriverUtility();
		
		//Assert.fail();
		//wutil.captureScreenShot(driver);
		
	}
	
	
	
	
	
	
	
	
	
	//when test is fail then we run couple time to make pass using IRetryAnalyzer interface
	
/*	@Test(retryAnalyzer=RetryAnalyserImplementation.class)
	public void createOrgVerifyTest() throws Throwable
	{
		
		
		HomePage hp=new HomePage( driver);
		hp.getOrgLnk();
		Assert.fail();
		
	}*/

}
 