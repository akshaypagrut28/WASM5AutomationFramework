package vtiger.ProductsTests;

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
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductsPage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws IOException
	{
		
		String productName = eUtil.readDataFromExcel("Product", 1, 2);
		
				
		//navigate to products
		HomePage hp = new HomePage(driver);
		hp.clickOnProdLnk();
		Reporter.log("clicked on products link",true);
		//System.out.println("clicked on products link");
		
		//navigate to Create Products lookup image
	    ProductsPage pp = new ProductsPage(driver);
	    pp.clickOnCreateProductImg();
	    Reporter.log("click on create product lookup image",true);
	    //System.out.println("click on create product lookup image");
	    
	    //create a product with mandatory field
	    CreateNewProductPage cnp = new CreateNewProductPage(driver);
	    cnp.createNewProduct(productName);
	    
	    //validate
	    ProductInfoPage pip = new ProductInfoPage(driver);
	    String prodHeader = pip.getprodHeaderText();
	    System.out.println(prodHeader);
	    Assert.assertTrue(prodHeader.contains(productName));
	   Reporter.log("Product is created",true);
	    
	}

}
