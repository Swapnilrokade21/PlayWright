package testNGTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void SofAssertion()
	{
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Soft Assert Begin");
		softAssert.assertEquals(false, true,"Value 1 != Value2");
		softAssert.assertEquals("String", "Char","String  != Char");
		System.out.println("Soft Assert End");
		
		System.out.println("Hard Assert Start");
		Assert.assertEquals(false, true,"Value 1 != Value2");
		Assert.assertEquals("String", "Char","String  != Char");
		System.out.println("Hard Assert End");
		
		softAssert.assertAll();
	}
	@Test
	public void SofAssertion1()
	{
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("Soft Assert Begin");
		softAssert.assertEquals(false, true,"Value 1 != Value2");
		softAssert.assertEquals("String", "Char","String  != Char");
		System.out.println("Soft Assert End");
		
		System.out.println("Hard Assert Start");
		Assert.assertEquals(false, true,"Value 1 != Value2");
		Assert.assertEquals("String", "Char","String  != Char");
		System.out.println("Hard Assert End");
		
		softAssert.assertAll();
	}

}
