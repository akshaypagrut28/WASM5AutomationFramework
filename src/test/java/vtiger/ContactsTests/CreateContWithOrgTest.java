package vtiger.ContactsTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListnerImplementation.class)
public class CreateContWithOrgTest extends BaseClass
{
    @Test
    public void createContactWithOrg() throws EncryptedDocumentException, IOException 
    {
    	
    	//read necessary data
    	String lastname = eUtil.readDataFromExcel("Contact", 4, 2);
    	String orgname = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
    	
    	//navigate to organizations link
    	HomePage hp = new HomePage(driver);
    	hp.clickOnOrgLink();
    	Reporter.log("----Organization page is displayed-----",true);
    	
    	//navigate to create organization look up image
    	OrganizationsPage op = new OrganizationsPage(driver);
    	op.clickOnCreateNewOrgImg();
    	Reporter.log("---create organization page is displayed-----",true);
    	
    	//create organization with mandatory fields
    	CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
    	cnp.createNewOrg(orgname);
    	Reporter.log("----organization is created----",true);
    	
    	//validate
    	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
    	String orgHeader = oip.getOrgHeader();
    	System.out.println(orgHeader);
    	Assert.assertTrue(orgHeader.contains(orgname));
    	
    	//navigate to contacts link
    	Assert.assertTrue(false);
    	hp.clickOnContLnk();
    	Reporter.log("------conatcts page is displayed----",true);
    	
    	//navigate to create contact lookup image
    	ContactsPage cp = new ContactsPage(driver);
    	cp.clickOnCreateNewContImg();
    	Reporter.log("----conatcts page is displayed------",true);
    	
    	//create new contact with organization name
    	CreateNewContactPage ccp = new CreateNewContactPage(driver);
    	ccp.createNewContact(lastname, orgname, driver);
    	Reporter.log("----contact is created----",true);
    	
    	//validate 
    	ContactInfoPage cip = new ContactInfoPage(driver);
    	String contactHeader = cip.getContHeader();
    	System.out.println(contactHeader);
    	Assert.assertTrue(contactHeader.contains(lastname));
    	Reporter.log("Contact is created",true);
    	
    }	
	
}
