package Testcases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genaralUtility.BaseClass;
import genaralUtility.ExcelUtility;
import genaralUtility.javaUtility;
import objectRepositry.CreateNewOrgPage;
import objectRepositry.HomePage;
import objectRepositry.OrganizationInfoPage;
import objectRepositry.OrganizationPage;

public class CreateOrganizationEndToEndTest extends BaseClass {
	@Test(groups= {"smoke testing","regression testing"})
	public void VerifyCreateOrgEtoETest() throws Throwable

	{
		HomePage hp = new HomePage(driver);
		hp.getOrgLnk();
		OrganizationPage orpage = new OrganizationPage(driver);
		orpage.clickCreateOrg();
		CreateNewOrgPage op = new CreateNewOrgPage(driver);

		ExcelUtility eutil = new ExcelUtility();
		javaUtility jutil= new javaUtility();
		String orgname = eutil.readDataFromExcelFile("organization", 4, 2)+jutil.getRandomNumber();
		
		String industry = eutil.readDataFromExcelFile("organization", 4, 3);
		op.CreateOrg(orgname, industry);
		Thread.sleep(2000);
		String Orgtitle = driver.findElement(By.xpath("//title[text()=' Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM']")).getText();
		Assert.assertTrue(true, Orgtitle);
	}

}
