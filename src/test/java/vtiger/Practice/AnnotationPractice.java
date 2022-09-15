package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice {
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("before suite");
	}
	
	@BeforeClass 
	public void bcConfig() {
		System.out.println("before class");
	}
	
	@BeforeMethod 
	public void bmCongifg(){
		System.out.println("before method");
	}
	
	@AfterMethod 
	public void amConfig() {
		System.out.println("after method");
	}
	@AfterClass
	public void acConfig() {
		System.out.println("after class");
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("after suite");
	}
	
	@Test
	public void test() {
		System.out.println("test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("test 2");
	}

}
