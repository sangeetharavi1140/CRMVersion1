package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//element Declaration
	@FindBy(xpath="//img[@title='Create Contact...']") private WebElement contactLookupimg;
	//element Initialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//element Utilaization
	public WebElement getCreateConactimg()
	{
		return contactLookupimg;
	}

}
