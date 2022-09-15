package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	//Declaration
	
	@FindBy (name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy (name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy (name = "accounttype")
	private WebElement TypeDropDown;
	
	@FindBy (name = "button")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return TypeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * this method will create organization with org name
	 * @param orgname
	 */
	public void createNewOrg(String Orgname) 
	{
		OrgNameEdt.sendKeys(Orgname);
		SaveBtn.click();
	}
	/**
	 * this method will create organization with industry 
	 * @param Orgname
	 * @param IndustryType
	 */
	public void createNewOrg(String Orgname, String IndustryType ) 
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndustryType, IndustryDropDown);
		SaveBtn.click();
	}
	
	/**
	 * this method will create organization with industry and type
	 * @param Orgname
	 * @param IndustryType
	 * @param Tpye
	 */
	public void createNewOrg(String Orgname, String IndustryType, String Tpye) 
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndustryType, IndustryDropDown);
		handleDropDown(Tpye, TypeDropDown);
		SaveBtn.click();
	}

}
