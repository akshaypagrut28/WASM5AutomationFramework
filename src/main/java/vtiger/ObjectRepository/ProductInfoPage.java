package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	//Declaration
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderTxt;
	
	//Initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getProductHeaderTxt() {
		return productHeaderTxt;
	}
	
	//Business Library
	
	/**
	 * this method will return the product header text
	 * @return
	 */
	public String getprodHeaderText() {
		
		return productHeaderTxt.getText();
	}
	
	
}
