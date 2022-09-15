package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampignInfoPage {
	//Declaration
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement campignHeadertxt;
	
	//Initialization
	public CampignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCampignHeadertxt() {
		return campignHeadertxt;
	}
	
	//Generic Library
	public String getCampaignHeader() 
	{
		return campignHeadertxt.getText();
	}
	
}
