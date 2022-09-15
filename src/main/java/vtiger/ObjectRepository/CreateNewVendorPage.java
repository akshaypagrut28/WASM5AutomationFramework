package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	
	//Declaration
	@FindBy (name = "vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy (name = "button")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * this method will create new vendor
	 * @param vendorName
	 */
	public void createNewVendor(String vendorName) {
		
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
	}
	

}
