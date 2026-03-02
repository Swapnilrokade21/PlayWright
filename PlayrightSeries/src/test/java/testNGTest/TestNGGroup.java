package testNGTest;

import org.testng.annotations.Test;

public class TestNGGroup {
	
	@Test(groups = {"smoke", "regression"})
	public void paymentTest() {
	    System.out.println("Smoke Payment Test");
	}

	@Test(groups = {"Functiaonl" })
	public void paymentTest1() {
	    System.out.println("Functional Payment Test1");
	}
}
