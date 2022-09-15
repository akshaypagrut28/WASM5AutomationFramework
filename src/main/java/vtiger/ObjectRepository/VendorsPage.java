package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	//Declaration
	@FindBy (xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorLookupImg;

	//Initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateVendorLookupImg() {
		return createVendorLookupImg;
	}
	
	//Business Library
	/**
	 * this method will click on create vendor lookup image
	 */
	public void clickOnCreateVendorImg() {
		
		createVendorLookupImg.click();
		
	}
	
}
