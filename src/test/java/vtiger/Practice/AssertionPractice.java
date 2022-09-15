package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
	@Test
	public void assertPracticeTest() {
		
		System.out.println("==Step 1 ==");
		System.out.println("== Step 2==");
        System.out.println("== Steo 3 ==");
        System.out.println("==Step 4 ==");
        Assert.assertEquals("A", "B");  // Hard assert- Mandatory field
        System.out.println("==Step 5 ==");
	}

	@Test
	public void assertPracticeTest2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("== assert 2 Step 1 ==");
		Assert.assertTrue(true); //Hard-Assert
		System.out.println("== assert 2 Step 2 ==");
		sa.assertEquals(0, 1);
		System.out.println("== assert 2 Step 3 ==");
		sa.assertAll();
		System.out.println("== assert 2 Step 4 ==");
		Assert.assertTrue(false);
		System.out.println("Done");
	}
}
