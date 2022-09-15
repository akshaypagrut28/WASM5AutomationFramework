package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatNewOpportunityPage extends WebDriverUtility
{
	
	//Declaration 
	@FindBy (name = "potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy (name = "related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy (xpath = "//input[@name='related_to']/following-sibling::img[@alt='Select']")
	private WebElement relatedToLookupImg;
	
	@FindBy (name = "search_text")
	private WebElement searchBoxTxtEdt;
	
	@FindBy (name = "search")
	private WebElement searchNowBtn;
	
	@FindBy (name = "sales_stage")
	private WebElement salesStageDropDown;
	
	@FindBy (name = "closingdate")
	private WebElement expClosingDateEdt;
	
	@FindBy (id = "jscal_trigger_closingdate")
	private WebElement expClosingDateCalenderImg;
	
	@FindBy (xpath = "//input[@name='campaignid']/following-sibling::img[@alt='Select']")
	private WebElement campaignSourceLookupImg;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization 
	public CreatNewOpportunityPage (WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getRelatedToDropDown() {
		return relatedToDropDown;
	}

	public WebElement getRelatedToLookupImg() {
		return relatedToLookupImg;
	}

	public WebElement getSearchBoxTxtEdt() {
		return searchBoxTxtEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getExpClosingDateEdt() {
		return expClosingDateEdt;
	}

	public WebElement getExpClosingDateCalenderImg() {
		return expClosingDateCalenderImg;
	}

	public WebElement getCapmignSourceLookupImg() {
		return campaignSourceLookupImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	public void createNewOpportunityWithCampaign(WebDriver driver, String opportunityName, String campignname , String ORGNAME) 
	{
		opportunityNameEdt.sendKeys(opportunityName);
		relatedToLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchBoxTxtEdt.sendKeys(ORGNAME);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Potentials");
		campaignSourceLookupImg.click();
		switchToWindow(driver, "Campaigns");
		searchBoxTxtEdt.sendKeys(campignname);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+campignname+"']")).click();
		switchToWindow(driver, "Potentials");
		saveBtn.click();
		
	}

}
