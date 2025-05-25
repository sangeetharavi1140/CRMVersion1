package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genaralUtility.ExcelUtility;
import objectRepositry.LoginPage;

public class MultiDataSetTest  {
	
	@Test(dataProvider="loginData")
	public void VerifyDataSetTest(String UN,String Pwd) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
		lp.appLogin(UN, Pwd);
		Assert.assertTrue(true);
		Thread.sleep(2000);
		driver.quit();
	
		
	}
@DataProvider (name="loginData")
public Object[][] logindataSet() throws Throwable, Throwable
{
	//String filePath=".\\src\\test\\resources\\createOrgtestdata.xlsx";
String filePath=	".\\src\\test\\resources\\createOrgtestdata.xlsx";
	ExcelUtility eutil=new ExcelUtility();
	Object data[][] = eutil.readMultipleDateFromExcel(filePath,"LoginDataSet");
	return  data;
	}
}
