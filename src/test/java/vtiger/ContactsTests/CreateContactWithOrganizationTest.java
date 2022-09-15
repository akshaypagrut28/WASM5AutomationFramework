package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createContWithOrgTest() throws IOException{
		
		

		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		//navigate to organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//navigate to create new organization img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		//create new organization with mandatory fields
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME);
		
		//validate 
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		//navigate to contacts link
		hp.clickOnContLnk();
		
		//navigate to create new contact img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContImg();
		
		//create new contact with organization name
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME, ORGNAME, driver);
		
		//validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContHeader();
		System.out.println(contactHeader);
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		Reporter.log("Contact is created",true);
		
	}

}
