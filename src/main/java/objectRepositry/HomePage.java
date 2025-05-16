package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaralUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	@FindBy(linkText="Organizations")  WebElement orgLnk; 
	@FindBy(xpath="//a[text()='Contacts']")  WebElement contactLnk;
	@FindBy(linkText="Products") WebElement productLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")  WebElement admistratorimg;
	@FindBy(xpath="//a[text()='Sign Out']")  WebElement signoutlnk;
	
//intialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public void getOrgLnk() {
		orgLnk.click();
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdmistratorimg() {
		return admistratorimg;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	//provide Business library
	/**
	 * This method will logout from application
	 * @param driver
	 */
	public void logoutApp(WebDriver driver)
	{
		moveToElement(driver,admistratorimg);
		signoutlnk.click();
	}

}
