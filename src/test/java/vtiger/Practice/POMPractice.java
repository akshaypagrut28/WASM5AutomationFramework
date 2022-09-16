package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch the browser 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		/*lp.getUsernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();*/
		
		lp.loginToApp("admin", "admin");
		driver.close();

	}
	
	@Test 
	public void practice()
	{
		System.out.println("hiee");
	}

}
