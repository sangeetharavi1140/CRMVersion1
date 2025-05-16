package genaralUtility;

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

import objectRepositry.HomePage;
import objectRepositry.LoginPage;

public class BaseClass {
	WebDriverUtility wutil=new WebDriverUtility();
	ExcelUtility eutil=new ExcelUtility();
	javaUtility jutil=new javaUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	//public WebDriver driver=null;
public static WebDriver driver;
@BeforeSuite(alwaysRun=true)
public void bs()
{
	System.out.println("-----------DatabaseConnectivity Successful------");
	}
	@AfterSuite(alwaysRun=true)
	public void as()
	{
		System.out.println("--------------DatabaseConnectivity closed----------");
		
	}
	//@Parameters("browser")
	
	@BeforeClass(alwaysRun=true,groups= {"smoke testing","regression testing"})
	public void bc() throws Throwable
	{
		String Browser = putil.readDataFromProperyFile("browser");
		String URL=putil.readDataFromProperyFile("url");
		if(Browser.equalsIgnoreCase("chrome"))
		{ 
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("invalid browser value");
		}
		System.out.println("------Browser launched successfully------------");
	//wutil.waitforPageLoad(driver);
		driver.get(URL);
		wutil.maximizeWindow(driver);
	}
	@AfterClass(alwaysRun=true)
	public void ac()
	{System.out.println("--------------Browser closed successfully------------");
		driver.quit();
	}
	@BeforeMethod(alwaysRun=true)
	public void bm() throws Throwable
	{
		LoginPage lp=new LoginPage( driver);
		String UN = putil.readDataFromProperyFile("username");
		String Pwd = putil.readDataFromProperyFile("password");
		lp.appLogin(UN, Pwd);
		System.out.println("---------application login successful------------");
		
	}
	@AfterMethod(alwaysRun=true)
	public void am()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutApp(driver);
		System.out.println("----------logout successful------------");
	}

}
