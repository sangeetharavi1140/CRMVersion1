package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaralUtility.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility {
	//element Declartion
	@FindBy(name="accountname") WebElement orgname;
	@FindBy(name="industry") WebElement industryType;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") WebElement savebtn;
	//element Initialization
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//element Utilization
	public WebElement getOrgname()
	{
		return orgname;
	}
	public WebElement getIndustrydd() {
		return industryType;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	//Provide Business Library
	public void CreateOrg(String Orgname)
	{
		orgname.sendKeys(Orgname);
		savebtn.click();}
	public void CreateOrg(String orgN,String industry)
	{
		orgname.sendKeys(orgN);
		handleDropDown(industry,industryType);
		savebtn.click();
	}

}
