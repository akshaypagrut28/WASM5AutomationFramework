package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProvidePractice {
	
	@Test(dataProvider = "OrgName")
	public void addProductToCart(String orgname , String industrytype) {
		
		System.out.println(orgname+"-"+industrytype);
		
	}

	/*@DataProvider 
	public Object[][] getData(){
		Object[][] d = new Object[4][5];
		d[0][0]="Realme";
		d[0][1]="M13";
		d[0][2]=15000;
		d[0][3]="Battery";
		d[0][4]=15;
		
		d[1][0]="Oppo";
		d[1][1]="015";
		d[1][2]=20000;
		d[1][3]="Camera";
		d[1][4]=20;
		
		d[2][0]="Redmi";
		d[2][1]="3sprime";
		d[2][2]=9000;
		d[2][3]="Security";
		d[2][4]=10;
		
		d[3][0]="iphone";
		d[3][1]="13";
		d[3][2]=25000;
		d[3][3]="Camera";
		d[3][4]=5;
		return d;
	}*/
	
	@DataProvider(name = "OrgName") 
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eutil = new ExcelFileUtility();
		Object[][] data=eutil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
	
	
}
