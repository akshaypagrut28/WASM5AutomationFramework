package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryAndType {

	public static void main(String[] args) throws InterruptedException {
		 // Step 1 : Launch The Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		System.out.println("Welcome Page is Displayed");
		//Step 2 : Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Home page is displayed");
		//Step 3: navigate to Organization link
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println("Organization page is displayed");
		//Step 4 : click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		System.out.println("Create organization page is displayed");
		//Step 5 : Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Redmi");
		//Step 6 : Choose Electronics in the Industry DropDown List
		WebElement industry = driver.findElement(By.name("industry"));
		Select s = new Select(industry);
		s.selectByValue("Electronics");
		System.out.println("Electronics is selected");
		//Step 7 : Choose Investor in Type DropDown List
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(type);
		s1.selectByValue("Investor");
		System.out.println("Investor is selected");
		//Step 8 : Save
		driver.findElement(By.name("button")).click();
		System.out.println("Organization is successfully created");
		//Step 9 : Logout
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Successfully logout from Application");
		
		driver.close();
		System.out.println("Organization is created");

	}

}
