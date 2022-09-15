package vtiger.Practice;

import org.testng.annotations.Test;

public class testNGPractice {
	
	@Test(priority = 1)
	public void createOrganizationTest() 
	{
		System.out.println("Test 1 :- organization is created");
	}

	@Test (priority = 2)
	public void modifyOrganizationTest() 
	{
		System.out.println("Test 2 :- organization is modified");
	}
	
	@Test (priority = 0)
	public void deleteOrganizationTest() 
	{
		System.out.println("test 3 :- organization is deleted");
	}
}
