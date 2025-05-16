package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Element Declaration
	@FindBy(name="user_name") WebElement usernametxt;
	@FindBy(name="user_password") WebElement userpwdtxt;
	@FindBy(id="submitButton") WebElement loginbtn;
	
	
	
	//Element Initalization
	public LoginPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver,this);
	}
	//element Utilization
	public void getUsername(String uname)
	{
		usernametxt.sendKeys(uname);
	}
	public void getPassword(String pwd)
	{
		usernametxt.sendKeys(pwd);
	}
	public void clickLoginBtn()
	{
		loginbtn.click();
	}
	//using Bussiness library for login action
	public void appLogin(String uname,String pwd)
	{
		usernametxt.sendKeys(uname);
		userpwdtxt.sendKeys(pwd);
		loginbtn.click();
	}
}
