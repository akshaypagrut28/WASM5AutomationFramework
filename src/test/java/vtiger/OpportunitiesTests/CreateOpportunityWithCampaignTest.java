package vtiger.OpportunitiesTests;

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
import vtiger.ObjectRepository.CampaignsPage;
import vtiger.ObjectRepository.CampignInfoPage;
import vtiger.ObjectRepository.CreatNewOpportunityPage;
import vtiger.ObjectRepository.CreateNewCampaignPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OpportunitiesPage;
import vtiger.ObjectRepository.OpportunityInfoPage;

public class CreateOpportunityWithCampaignTest extends BaseClass
{
	@Test 
	public void createOpportunityWithCampaignTest() throws IOException 
	{
		
		String opportunityname = eUtil.readDataFromExcel("opportunity", 1, 2);
		String campaignname = eUtil.readDataFromExcel("opportunity", 1, 3);
				
		//navigate to campaigns
		HomePage hp = new HomePage(driver);
		hp.clickOnCampignsLink(driver);
		Reporter.log("campaigns page is displayed", true);
		//System.out.println("campaigns page is displayed");
		
		//navigate to create campign page
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampiagnLookupImg();
		Reporter.log("create campaign page is displayed", true);
		//System.out.println("create campaign page is displayed");
		
		//create campaign with mandatory fields
		CreateNewCampaignPage cnp = new CreateNewCampaignPage(driver);
		cnp.createNewCampign(campaignname);
		Reporter.log("campaign info page is displayed");
		//System.out.println("campaign info page is displayed");
		
		//validate
	    CampignInfoPage cip = new CampignInfoPage(driver);
	    String campaignHeader = cip.getCampaignHeader();
	    System.out.println(campaignHeader);
	    Assert.assertTrue(campaignHeader.contains(campaignname));
	    Reporter.log("campaign is created",true);
		
	    //navigate to opportunities page
	    hp.clickOnOppoLnk();
	    Reporter.log("opportunities page is displayed",true);
	   
	    // System.out.println("opportunities page is displayed");
	    
	    //navigate to create opportunity page
	    OpportunitiesPage op = new OpportunitiesPage(driver);
	    op.clickOnCreateNewOppoImg();
	    Reporter.log("create new opportunity page is displayed",true);
	    //System.out.println("create new opportunity page is displayed");
	    
	    //create new opportunity with campaign
	    CreatNewOpportunityPage cop = new CreatNewOpportunityPage(driver);
	    cop.createNewOpportunityWithCampaign(driver, opportunityname, campaignname, "Test Yantra");
	    
	    //validate 
	    OpportunityInfoPage oip = new OpportunityInfoPage(driver);
	   String opportunityHeader = oip.getOpportuHeader();
	    Assert.assertTrue(opportunityHeader.contains(opportunityname));
	    Reporter.log("opportunity is created", true);
	
	}

}
