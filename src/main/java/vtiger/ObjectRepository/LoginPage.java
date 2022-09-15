package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	      
	//Rule 1 :- Create a seperate class for every page
	//Rule 2 :- Identify the elements by using @findBy, @findBys, @findAll 
	//Declaration 
	@FindBy (name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy (name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy (id = "submitButton")
	private WebElement loginBtn;
	
	//Rule 3 :- Create a constructor to initialize 
	//Initialization 
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 :- Provide getters to access the elements
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business library 
	
	/**This method will login to application with username and password
	 * @author Akshay P
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username , String password ) 
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

}
