package testNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAnnotationFeuture {
	
	@Test(priority = 1)
	public void test1()
	{
		Assert.fail();
		System.out.println("test1 Passed");
	}
	
	@Test(priority = 1,dependsOnMethods = "test1")
	public void test2()
	{
		System.out.println("test2 Passed");
	}
	
	@Test(priority = 1,dependsOnMethods = "test1",alwaysRun = true)
	public void test3()
	{
		System.out.println("test3 Passed");
	}
	
	@Test(priority = 1,dependsOnMethods = {"test1","test3"})
	public void test4()
	{
		System.out.println("test4 Passed");
	}

}
