package vtiger.OrganizationsTests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustryTest  extends BaseClass{

	@Test
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException
	{
		
		
		//-----Excel Sheet -> Test Date--------
		String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2);
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
		
		//Step 3 :- Launch the browser------RUNTIME POLYMORPHISM
		
		
		//Step 5 :- navigate to organizations
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		//driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("organization page is displayed",true);
		//System.out.println("organization page is displayed");
		
		//Step 6 : navigate to create organization 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("create organization page is displayed",true);
		//System.out.println("create organization page is displayed");
		
		//Step 7 :- Enter the mandatory fields 
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME, INDUSTRY);
		/*Step 8 :- choose the Industry
		
		WebElement ele = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(INDUSTRY, ele);
		System.out.println("indystry is selected");
		
		//Step 9 :- save 
		driver.findElement(By.name("button")).click();
		System.out.println("successfully saved");
		
		//Step 10 :- Logout
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, ele1);
		
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("successfully logout");
		
		driver.close();*/
		Reporter.log("organization is created",true);
		//System.out.println("organization is created");

	}

}
