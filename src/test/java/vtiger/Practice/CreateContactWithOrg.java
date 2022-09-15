package vtiger.Practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {

	public static void main(String[] args) {
		        // Step 1 : Launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("http://localhost:8888/");
				System.out.println("Welcome Page is Displayed");
				//Step 2 : Login to App
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				System.out.println("Home page is displayed");
				//Step 3 : navigate to contact link 
				driver.findElement(By.linkText("Contacts")).click();
				System.out.println("Contacts page is displayed");
				//Step 4 : click on create contact lookup image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				System.out.println("Create contact page is displayed");
				//Step 5 : enter the mandatory field
				driver.findElement(By.name("lastname")).sendKeys("Akshay");
				//step 6 : Choose any existing organization 
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				String parentwidid = driver.getWindowHandle();
				Set<String> allwindid = driver.getWindowHandles();
				for (String id : allwindid )
				{
					driver.switchTo().window(id);
				}
				driver.findElement(By.linkText("Test Yantra")).click();
				driver.switchTo().window(parentwidid);
				//Step 7 : Save 
				driver.findElement(By.name("button")).click();
				System.out.println("contact is successfully created");
				//Step 8 : Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				Actions action = new Actions(driver);
				action.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Successfully logout from Application");
				
				driver.close();
				System.out.println("Contact is created");

	}

}
