package vtiger.OrganizationsTests;


import java.io.IOException;
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

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws IOException, InterruptedException{
		/*WebDriver driver;
		//Step 1 :- Create object of all utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Generate Random number to avoid duplicate data
		int RANDOM = jUtil.getRandomNumber();
		
		// Step 2 :- Read the necessary data
		//-----PropertyFile->common data---
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");*/
		
	 //----Excel Sheet->---Test Data----
	 
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1 , 2);
	  
		//Step 3 :- Launch the browser----Runtime Polymorphism
		
	 /*if(BROWSER.equalsIgnoreCase("Chrome")) 
	 {
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  System.out.println("chrome browser launched successfully");
		  
	  }
	  else if(BROWSER.equalsIgnoreCase("firefox")) 
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  System.out.println("firefox browser launched successfully");
	  }
	  else 
	  {
		  WebDriverManager.chromedriver().setup();
		  System.out.println("invalid browser");
		  driver = new ChromeDriver();
		  System.out.println("chrome browser launched successfully");
		  
	  }
	  
	  wUtil.maximiseWindow(driver);
	  wUtil.waitForElementsToLoadInDOM(driver);
	  driver.get(URL);
	  System.out.println("Welcome Page is Displayed");
	  
		//Step 4 :- Login to App
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//Step 5 :- Navigate to Organizations 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		//driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Organization page is displayed",true);
		//System.out.println("Organization page is displayed");
		
		//Step 6 :- navigate to create organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("Create organization page is displayed",true);
		//System.out.println("Create organization page is displayed");
		
		//Step 7 :- create organization with mandatory fields
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		Reporter.log("Organization is created",true);
		System.out.println("Organization is created");
		

	}

}
