package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {

	//Declaration
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement opportunityHeaderTxt;
	
	//Initialization
	public OpportunityInfoPage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOpportunityHeaderTxt() {
		return opportunityHeaderTxt;
	}
	
	//Business Library
	public String getOpportuHeader() 
	{
		return opportunityHeaderTxt.getText();
		
	}
	
	
}
