package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//element Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']") WebElement createOrglookup;
	//element Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//element Utilization
	public void clickCreateOrg()
	{
		createOrglookup.click();
	}

}
