package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import genaralUtility.BaseClass;
import genaralUtility.ExcelUtility;
import objectRepositry.ContactInfoPage;
import objectRepositry.ContactPage;
import objectRepositry.CreateNewContactPage;
import objectRepositry.HomePage;

public class CreateContactwithOrganizationEndtoEndTest extends BaseClass {
	@Test(groups= {"regression testing"})
	public void VerifycreateconwithorgTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getContactLnk().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateConactimg().click();
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ExcelUtility eutil=new ExcelUtility();
		String orgname = eutil.readDataFromExcelFile("contact", 4, 2);
		cnp.createNewContact("tim", orgname, driver);
		ContactInfoPage cip=new ContactInfoPage(driver);
		String infoHeader = cip.getConInfoHead();
		Assert.assertTrue(true,infoHeader);
	}
	

}
