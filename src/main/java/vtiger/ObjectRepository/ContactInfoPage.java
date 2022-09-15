package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	//Declaration 
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement contHeaderText;
	
	//Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContHeaderText() {
		return contHeaderText;
	}
	
	//Business Library
	/**
	 * this method will return the contact header
	 * @return
	 */
	public String getContHeader() 
	{
		String contHeader = contHeaderText.getText();
		return contHeader;
    }
	
}
