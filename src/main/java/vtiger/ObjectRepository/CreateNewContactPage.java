package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	//Declaration
	@FindBy (name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy (xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookupImg;
	
	@FindBy (name = "button")
	private WebElement saveBtn;
	
	@FindBy (name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy (name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy (name = "search")
	private WebElement searchNowBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgNameLookupImg() {
		return orgNameLookupImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	//Business Library 
	/**
	 * this method will create contact with last name
	 * @param lastName
	 */
	public void createNewContact(String lastName) 
	{
		LastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	/**
	 * this method will create contact with lead source
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String lastName , String leadSource) 
	{
		LastNameEdt.sendKeys(lastName);
		handleDropDown(leadSource, leadSourceDropDown);
		saveBtn.click();
	}
	
	/**
	 * this method will create contact with organization
	 * @param lastName
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastName, String orgName, WebDriver driver) 
	{
		LastNameEdt.sendKeys(lastName);
		orgNameLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchTextEdt.sendKeys(orgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
}
