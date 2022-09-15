package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	//Declaration
	@FindBy (xpath = "//img[@alt='Create Product...']")
	private WebElement createNewProductImg;
	
	//Initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateNewProductImg() {
		return createNewProductImg;
	}
	
	//Business Library
	/**
	 * this method will click on create new product look up image
	 */
	public void clickOnCreateProductImg() {
		
		createNewProductImg.click();
	}
	
	
	
}
