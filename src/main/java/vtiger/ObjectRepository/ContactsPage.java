package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
	@FindBy (xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewContLookupImg;
	
	//Initialization 
	public ContactsPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateNewContLookupImg() {
		return createNewContLookupImg;
	}
	
	//Business Library
	
	/**
	 * this method will click on create new contacts lookup image
	 */
	public void clickOnCreateNewContImg() 
	{
		createNewContLookupImg.click();
		
	}
	
	
	

}
