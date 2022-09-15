package vtiger.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductsPage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorsPage;

public class CreateProductWithVendorTest extends BaseClass {

	@Test
	public void createProductWithVendorTest() throws EncryptedDocumentException, IOException
	{
		
		
		String productName = eUtil.readDataFromExcel("Product", 4, 2);
		String vendorName = eUtil.readDataFromExcel("Product", 4, 3);
		
				
		//navigate to vendors 
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLnk(driver);
		Reporter.log("vendors page is displayed",true);
		//System.out.println("vendors page is displayed");
		
		//navigate to create create vendor page
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
		System.out.println(vendorHeader);
		Assert.assertTrue(vendorHeader.contains(vendorName));
		Reporter.log("vendor is created",true);
		
		//navigate to products link
		hp.clickOnProdLnk();
		Reporter.log("products page is displayed",true);
		//System.out.println("products page is displayed");
		
		//navigate to create product page
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductImg();
		Reporter.log("create new product page is displayed",true);
		//System.out.println("create new product page is displayed");
		
		//create product with vendor
		CreateNewProductPage cpp = new CreateNewProductPage(driver);
		cpp.createNewProduct(productName, vendorName, driver);
		Reporter.log("product information page is displayed",true);
		//System.out.println("product information page is displayed");
		
		//validate
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productHeader = pip.getprodHeaderText();
		System.out.println(productHeader);
		Assert.assertTrue(productHeader.contains(productName));
		Reporter.log("Product is created",true);
		
	}

}
