package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {

	//Declaration
	@FindBy (name = "productname")
	private WebElement productNameEdt;
	
	@FindBy (xpath = "//img[@alt='Select']")
	private WebElement vendorNameLookupImg;
	
	@FindBy (name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy (name = "search")
	private WebElement searchNowtn;
	
	@FindBy (name = "button")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getProductName() {
		return productNameEdt;
	}

	public WebElement getVendorNameLookupImg() {
		return vendorNameLookupImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowtn() {
		return searchNowtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * this method will create product with product name
	 * @param productName
	 */
	public void createNewProduct(String productName) 
	{
		
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}
	
	/**
	 * this method will create product with vendor name
	 * @param productName
	 * @param vendorName
	 * @param driver
	 */
	public void createNewProduct(String productName, String vendorName, WebDriver driver)
	{
		productNameEdt.sendKeys(productName);
		vendorNameLookupImg.click();
		switchToWindow(driver, "Vendors");
		searchTextEdt.sendKeys(vendorName);
		searchNowtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		switchToWindow(driver, "Products");
		saveBtn.click();
	}
	
}
