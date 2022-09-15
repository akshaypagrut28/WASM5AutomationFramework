package vtiger.ContactsTests;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
/**
 * 
 * @author Akshay P
 *
 */
public class CreateContactTest extends BaseClass{

	@Test
	public void createContactTest()  throws IOException{
		
		       
				
				//-----Excel Sheet -> Test Date--------
				String LASTNAME = eUtil.readDataFromExcel("Contact", 1 , 2);
				
				
		        //Step 5 :- navigate to contacts 
				HomePage hp = new HomePage(driver);
				hp.clickOnContLnk();
				Reporter.log("Contacts page is displayed", true);
				//System.out.println("Contacts page is displayed");
				
		        //Step 6 :- navigate to create contact
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateNewContImg();
				//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				Reporter.log("Create contact page is displayed", true);
				//System.out.println("Create contact page is displayed");
				
		       //Step 7 :- Enter the mandatory fields
				//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				CreateNewContactPage cnp = new CreateNewContactPage(driver);
				cnp.createNewContact(LASTNAME);
		        Reporter.log("contact is created", true);
				//System.out.println("contact is created");

	}
	
	@Test 
	public void demoRegRegreesion() {
		System.out.println("this is demo");
	}

}
