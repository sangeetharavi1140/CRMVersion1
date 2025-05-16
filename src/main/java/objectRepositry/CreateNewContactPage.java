package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaralUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	//element Declaration
	@FindBy(name="lastname") private WebElement lastName;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img") private WebElement createNewCon;
	@FindBy(id="search_txt") private WebElement searchTxt;
	@FindBy(name="search") private WebElement searchbtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	//element Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//element Utilaization
	public void createNewContact(String lname,String Orgname, WebDriver driver) throws Throwable
	{
		lastName.sendKeys(lname);
		createNewCon.click();
		switchtowindow( driver,"Accounts");
		searchTxt.sendKeys(Orgname);
		searchbtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchtowindow(driver,"Contacts");
		saveBtn.click();		
	}

}
