package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class contains all generic method related to webdriver actions
 * @author Akshay P
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method will used to 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will wait for 20 seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void waitForElementsToLoadInDOM(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	/**
	 * this method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**'
	 * this method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will wait for the particular element to perform click operation
	 * if the element is not interactive it will wait for 1 second 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
		
		int count = 0;
		while(count<10) {
			try 
			{
				element.click();
				break;
			}
			catch(Exception e) 
			{
				Thread.sleep(200);
				count++;
			}
		}
		
	}
	
	/**
	 * this method will handle the drop down by select class using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index) {
		
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	/**
	 * this method will handle drop down by select class using visible text
	 * @param element
	 * @param text
	 */
	public void handleDropdown(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);		
	}
	
	/**
	 * this method will handle drop down by select class using value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value , WebElement element) 
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method will perform mouse hover action on a particular element
	 * @param driver
	 * @param target
	 */
	public void mouseHoverOn(WebDriver driver, WebElement target)
	{
		
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	/**
	 * this method will perform mouse hover action over the offset
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(WebDriver driver, int x , int y ) 
	{
		
		Actions a = new Actions(driver);
		a.moveByOffset(x, y).perform();
		
	}
	
	/**
	 * this method will perform right click on the page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) {
		
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * this method will perform right click on a particular element
	 * @param target
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver , WebElement element ) {
		
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * this method will perform double click over a page
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver)
	{
		
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * this method will perform double click over a particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver , WebElement element) {
		
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * this method will perform drag and drop operation from source to target element
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropOn(WebDriver driver, WebElement source , WebElement target) {
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	/**
	 * this method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will used to dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will get the text from alert popup and return to caller
	 * @param driver
	 */
	public String getTextInAlert(WebDriver driver) {
		
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * this method will switch to the window with respect to the window title
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle) {
		
		//step 1 : get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//step 2 : iterate through all windowIds
		Iterator<String> it = windowIds.iterator();
		
		//Step 3 : navigate inside windows 
		while(it.hasNext()) {
			
			//capture all the window Ids
			String winId = it.next();
			
			//switch to the window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			
			if(currentTitle.contains(partialTitle)) {
				break;
			}
			
		}
		
	}
	
	/**
	 * this method is used for switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method is used for switch to frame based in id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver, String idOrName) {
		
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * this method is used for switch to frame based on webelement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver , WebElement element) {
		
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will take screen shot and return the destination path
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, String ScreenShotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\ScreenShots\\"+ScreenShotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();   //used for reporting in listeners
	}
	
	/**
	 * this method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)", "");
	}
	
	/**
	 * this method will scroll until the particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver , WebElement element) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("argument(0).scrollIntoView()", element);
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
