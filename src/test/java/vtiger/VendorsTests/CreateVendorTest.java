package vtiger.VendorsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorsPage;

public class CreateVendorTest extends BaseClass {

	@Test
	public void createVendorTest() throws EncryptedDocumentException, IOException{
		
		
		
		String vendorName = eUtil.readDataFromExcel("Vendor", 1, 2);
		
	    //navigate to vendors link
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLnk(driver);
		Reporter.log("vendors page is displayed",true);
		//System.out.println("vendors page is displayed");
		
		//navigate to create vendor lookup image
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateVendorImg();
		Reporter.log("create vendor page is displayed",true);
		//System.out.println("create vendor page is displayed");
		
		//create vendor with mandatory fields 
		CreateNewVendorPage cnp = new CreateNewVendorPage(driver);
		cnp.createNewVendor(vendorName);
		Reporter.log("vendor information page is displayed",true);
		//System.out.println("vendor information page is displayed");
		
		//validate
		VendorInfoPage vip = new VendorInfoPage(driver);
		String vendorHeader = vip.getVendorHeaderText();
		Assert.assertTrue(vendorHeader.contains(vendorName));
		Reporter.log("Vendor is created",true);
		
	}

}
