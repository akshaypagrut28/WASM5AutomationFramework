package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//Rule 1 :- Create seperate class for each page 
	//Rule 2 :- Identify all the elements by using (@findBy, @findBys, @findAll)
	//Declaration
	@FindBy (xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgLookupImg;
	
	//Rule 3 :- Create a constructor to initialize the element
	//Initialization
	public OrganizationsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 :- provide getters method to accessing the elements
	//Utilization
	public WebElement getCreateNewOrgLookupImg() {
		return createNewOrgLookupImg;
	}
	
	//Business library 
	/**
	 * this method will click on create new organizations look up image
	 */
	public void clickOnCreateNewOrgImg() {
		
		createNewOrgLookupImg.click();
		
	}
	

}
