package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
    //Declaration
	@FindBy (name = "campaignname")
	private WebElement campaignNameEdt;
	
	@FindBy (name = "button")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Generic Library
	public void createNewCampign(String campaignname)
	{
		campaignNameEdt.sendKeys(campaignname);
		saveBtn.click();
	}

}
