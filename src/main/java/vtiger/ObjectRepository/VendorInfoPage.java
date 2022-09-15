package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	//Declaration
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderTxt;
	
	//Initialization
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getVendorHeaderTxt() {
		return vendorHeaderTxt;
	}
	
	//Business Library
	
	/**
	 * this method will return the vendor header text
	 * @return
	 */
	public String getVendorHeaderText() {
		
	      return vendorHeaderTxt.getText();
	}
	
	
}
