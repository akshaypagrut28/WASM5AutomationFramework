package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	
	 
	@Test (dataProvider = "OrgData")
	public void createMultipleOrgTest(String orgname , String industrytype) throws IOException 
	    {
		//read necessary data
				
				
				String org = orgname+jUtil.getRandomNumber();
				
				
				//navigate to organization page
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				Reporter.log("Organizations page is displayed");
				//System.out.println("Organizations page is displayed");
				
				//navigate to create organization page
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateNewOrgImg();
				Reporter.log("create organization page is displayed");
				//System.out.println("create organization page is displayed");
				
				//create multiple organization with industry type
				CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
				cop.createNewOrg(org, industrytype);
				
				//validate 
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrgHeader();
				Assert.assertTrue(orgHeader.contains(org));
				Reporter.log("organization is created");
		
		}
	
	@DataProvider (name = "OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
	}

}
