package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//element Declartion
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement infoHeader;
	//element Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//element Utilization
	public String getConInfoHead()
	{
	return	infoHeader.getText();
		
	}

}
