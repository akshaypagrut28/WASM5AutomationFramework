package vtiger.ContactsTests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListnerImplementation.class)
public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContWithOrg() throws IOException{
		
		
		
		//-----Excel Sheet -> Test Data--------
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4 , 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		
		//Step 3 :- Launch the browser------RUNTIME POLYMORPHISM
		
		//Step 5 : navigate to Organizations
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("organizations page is displayed");
		//System.out.println("organizations page is displayed");
		
		//Step 6 :- navigate to create organization
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		Reporter.log("create organization page is displayed");
		//System.out.println("create organization page is displayed");
		
		//step 7 :- Create organization with mandatory fields and save
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		
		//validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		AssertJUnit.assertTrue(orgHeader.contains(ORGNAME));
        //Step 8 :- navigate to contacts 
		AssertJUnit.assertTrue(false);
		hp.clickOnContLnk();
		Reporter.log("Contacts page is displayed");
		//driver.findElement(By.linkText("Contacts")).click();
		//System.out.println("Contacts page is displayed");
		
        //Step 9 :- navigate to create contact
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContImg();
		Reporter.log("Create contact page is displayed");
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//System.out.println("Create contact page is displayed");
		
       //Step 10 :- Enter the mandatory fields
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME, ORGNAME, driver);
		//Step 11 : choose the organization 
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		
		/*switch the control to child window
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//switch the control back to parent window
		wUtil.switchToWindow(driver, "Contacts");
	    driver.findElement(By.name("button")).click();
	    System.out.println("sucessfully saved");*/
	    
	    String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    System.out.println(conHeader);
	    AssertJUnit.assertEquals(conHeader.contains(LASTNAME), true);
	    Reporter.log("Contact is created",true);
     
	}

}
