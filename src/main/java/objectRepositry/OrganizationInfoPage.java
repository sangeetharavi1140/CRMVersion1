package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	//element Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']") WebElement orginfo;
	//element Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//element Utilization
	public WebElement getorginfo()
	{
		return orginfo;
		
	}
	public String getorgInfomation()
	{
		return orginfo.getText();
	}
	

}
