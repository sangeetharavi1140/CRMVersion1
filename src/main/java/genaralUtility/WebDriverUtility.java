package genaralUtility;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	public void waitforPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void elementtoBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	public void elementtobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method handle the dropdown by using value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method handle the dropdown by using visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method click the particular element
	 * 
	 * @param driver
	 */
	public void clickElement(WebDriver driver) {
		Actions act = new Actions(driver);
		act.click().perform();
	}

	/**
	 * This method used to send the text where the cursor pointing
	 * 
	 * @param driver
	 * @param text
	 */
	public void writingIntotextField(WebDriver driver, String text) {
		Actions act = new Actions(driver);
		act.sendKeys(text).perform();
	}

	/**
	 * This method is used to send the text to particular element
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void writingIntoTextField(WebDriver driver, WebElement element, String text) {
		Actions act = new Actions(driver);
		act.sendKeys(element, text).perform();

	}

	/**
	 * This method used to move offset and click
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveToOffset(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}

	/**
	 * This method mouse over the particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will drap particular element from source and drop it in
	 * particular element
	 * 
	 * @param driver
	 * @param srcele
	 * @param dtnele
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcele, WebElement dtnele) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, dtnele).perform();
	}

	/**
	 * This method used to perform right click operation
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * this method used to perform rightclick operation on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method to perform doubleClick operation
	 * 
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method to perform doubleclick operation on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method to handling frame by using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method handle frames by using web element
	 * 
	 * @param element
	 * @param driver
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method handle frame by using nameorid
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * this method will switch to immediate parent
	 * 
	 * @param driver
	 */
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will switch to default content
	 * 
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method scroll down for 500 units
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * this method scroll down until a particular web  element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argments[0].scrollIntoView()", element);
	}

	/**
	 * This method accept the alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	/**
	 * This method will take the alerttext and send it to caller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/*
	 * This method is used to switch one window another window
	 */
	public void switchtowindow(WebDriver driver,String actTitle)
	{//capture all windowID
		Set<String> winId = driver.getWindowHandles();
		//navigate each window
		for(String win:winId)
		{
			@Nullable
			String title = driver.switchTo().window(win).getTitle();
			if(actTitle.equals(title))
			{
				break;
			}
		}
		
	}
	/*
	 * This method used to capture screenshot and store particular location
	 * 
	 * 
	 */
	public String captureScreenShot(WebDriver driver, String name)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File desfile=new File(".\\Screenshots\\"+name+".png");
		srcfile.renameTo(desfile);
		return desfile.getAbsolutePath();//used for extentreport
	}
}
