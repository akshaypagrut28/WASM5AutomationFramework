package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implementation class to override all the methods present in Itestlistner interface
 * @author Akshay P
 *
 */
  public class ListnerImplementation implements ITestListener

 {

	ExtentReports reports;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName); //test is created which will initialize the individual test
		//Reporter.log(methodName+"=> Script execution is started", true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---->"+ "passed ");
		
		//Reporter.log(methodName+"=> Script is paased" , true);
	}

	public void onTestFailure(ITestResult result) 
	{
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		//this will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//this will capture the current test method name
		String methodName = result.getMethod().getMethodName();
		
		//this will append method name with date for screenshot
		String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
		//this will log in report and console
		test.log(Status.FAIL, methodName+"---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//Reporter.log(methodName+"=> is failed because =>"+msg, true);
		
		//this will capture the screenshot and provide the screen shot name and save it in file
		try 
		{
			String path = wUtil.takeScreenshot(BaseClass.sdriver, screenShotName);
			
			test.addScreenCaptureFromBase64String(path); //navigate to screenshot path and attach it to file
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		//this will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//this will capture the current  test method name
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---> skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//this will log in report and console
		//Reporter.log(methodName+"=> Script is Skipped because => "+msg, true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//Start of suite Execution
		/*Configure the extent reports*/
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemDateInFormat()+".html");
	    htmlreport.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
	    htmlreport.config().setTheme(Theme.DARK);
	    htmlreport.config().setReportName("Vtiger Execution Report");
	    
	    reports = new ExtentReports();
	    reports.attachReporter(htmlreport);
	    reports.setSystemInfo("Base-Browser", "Chrome");
	    reports.setSystemInfo("Base-platform", "Windows");
	    reports.setSystemInfo("Base-URL", "http://localhost:8888");
	    reports.setSystemInfo("Reporter Name", "Akshay");
	}

	public void onFinish(ITestContext context)
	{
		//End of Suite execution
		reports.flush(); //consolidate all the test script execution and dump the status into report 
	}
      
	
 }
