package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//Declaration
	@FindBy (xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOpportunityImg;
	
	//Initialization
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOpportunity() {
		return createOpportunityImg;
	}
	
	//Business library
	/**
	 * this method will click on create new opportunity lookup image
	 */
	public void clickOnCreateNewOppoImg() {
		createOpportunityImg.click();
		
	}
	
}
