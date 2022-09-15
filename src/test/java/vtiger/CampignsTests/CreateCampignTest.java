package vtiger.CampignsTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CampaignsPage;
import vtiger.ObjectRepository.CampignInfoPage;
import vtiger.ObjectRepository.CreateNewCampaignPage;
import vtiger.ObjectRepository.HomePage;

/**
 * 
 * @author Akshay P
 *
 */
public class CreateCampignTest extends BaseClass {
	
	@Test
	
	public void createCampignTest() throws IOException {
		
		
		String campaignname = eUtil.readDataFromExcel("Campaign", 1, 2);
		
		
		//navigate to campaigns
		HomePage hp = new HomePage(driver);
		hp.clickOnCampignsLink(driver);
		Reporter.log("campaigns page is displayed",true);
		//System.out.println("campaigns page is displayed");
		
		//navigate to create campign page
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCreateCampiagnLookupImg();
		Reporter.log("create campaign page is displayed", true);
		//System.out.println("create campaign page is displayed");
		
		//create campaign with mandatory fields
		CreateNewCampaignPage cnp = new CreateNewCampaignPage(driver);
		cnp.createNewCampign(campaignname);
		Reporter.log("campaign info page is displayed", true);
		//System.out.println("campaign info page is displayed");
		
		//validate
	    CampignInfoPage cip = new CampignInfoPage(driver);
	    String campaignHeader = cip.getCampaignHeader();
	    System.out.println(campaignHeader);
	    Assert.assertTrue(campaignHeader.contains(campaignname));
	  
	    Reporter.log("Campaign is created",true);
	}

}
