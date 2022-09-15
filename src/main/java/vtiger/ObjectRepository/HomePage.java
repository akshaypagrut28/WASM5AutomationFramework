package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Rule 1 :- Create a seperate class for ever page
	//Rule 2 :- Identify the element by using (@findBy , @fimdBys , @findAll)
	//Declaration
	
	@FindBy (linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy (linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy (linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy (linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy (linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindAll ({@FindBy (linkText = "Sign Out"), @FindBy (xpath = "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signOutLnk;
	
	@FindBy (xpath = "//a[text()='More']")
	private WebElement moreLnk;
	
	@FindBy (name = "Vendors")
	private WebElement vendorsLnk;
	
	@FindBy (name = "Campaigns")
	private WebElement campaignsLink;
	
	
	//Rule 3 :- Create a constructor to initialize 
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 :- Provide getters to access the elements 
		//Utilization
		
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getVendorsLnk() {
		return vendorsLnk;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	//Business Library
	/**
	 * this method will perform sign out operation
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver) 
	{
		mouseHoverOn(driver, administratorImg);
		signOutLnk.click();
	}
	
	/**
	 * this method will click on organizations
	 */
	public void clickOnOrgLink() 
	{
		OrganizationsLnk.click();
		
	}
	
	/**
	 * this method will click on contacts
	 */
	public void clickOnContLnk() 
	{
		ContactsLnk.click();
		
	}
	
	/**
	 * this method will click on opportunities link
	 */
	public void clickOnOppoLnk() 
	{
		
		OpportunitiesLnk.click();
	}
	
	/**
	 * this method will click on products link
	 */
	public void clickOnProdLnk() 
	{
		
		ProductsLnk.click();
	}
	
	/**
	 * this method will click on leads link
	 */
	public void clickOnLeadsLnk() 
	{
		
		LeadsLnk.click();
	}
	
	/**
	 * this method will click on vendors link
	 * @param driver
	 */
	
	public void clickOnVendorsLnk(WebDriver driver) {
		
		mouseHoverOn(driver, moreLnk);
		vendorsLnk.click();
		
	}
	
	/**
	 * this method will click on campaigns link
	 * @param driver
	 */
	public void clickOnCampignsLink(WebDriver driver) {
		
		mouseHoverOn(driver, moreLnk);
		campaignsLink.click();
	}
	
}
