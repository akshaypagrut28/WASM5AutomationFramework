package vtiger.ContactsTests;

import org.testng.annotations.Test;
import java.io.IOException;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class CreateContactWithMandFieldTest  extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws IOException{
		
	

	String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
	//Launch the browser
	
	//navigate to contacts link 
	HomePage hp = new HomePage(driver);
	hp.clickOnContLnk();
	
	//navigate to create new contacts 
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnCreateNewContImg();
	
	//Create contact with mandatory fields 
	CreateNewContactPage cnp = new CreateNewContactPage(driver);
	cnp.createNewContact(LASTNAME);
	
	
	}
}
