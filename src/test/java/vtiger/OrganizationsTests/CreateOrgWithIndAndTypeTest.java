package vtiger.OrganizationsTests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndAndTypeTest extends BaseClass{

	@Test
	public void createOrgWithIndustryAndType() throws EncryptedDocumentException, IOException
	  {
		
		//------Excel Sheet -> Common data-------
		String ORGNAME = eUtil.readDataFromExcel("Organization", 7, 2);
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 7, 3);
		String TYPE = eUtil.readDataFromExcel("Organization", 7, 4);
		
		
		
		//Step 5 :- navigate to organizations 
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		Reporter.log("organization page is displayed",true);
		//System.out.println("organization page is displayed");
		
		//Step 6 :- navigate to create organization 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Reporter.log("create organization page is displayed",true);
		//System.out.println("create organization page is displayed");
		//Step 7 :- enter the mandatory fields 
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME, INDUSTRY, TYPE);
		/*Step 8 :- choose the industry 
		WebElement element = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(INDUSTRY, element);
		System.out.println("industry is selected");
		
		//Step 9 :- choose the type
		WebElement element1 = driver.findElement(By.name("accounttype"));
		wUtil.handleDropDown(TYPE, element1);
		System.out.println("Type is selected");
		
		//Step 10 :- save 
		driver.findElement(By.name("button")).click();
		System.out.println("successfully saved");
		
		//Step 11 :- Logout
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
