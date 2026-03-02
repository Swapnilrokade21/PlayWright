package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;

import base.BaseTest;

public class BankManagerLogin extends BaseTest{
	
	@Test(priority =1)
	public void bankManagerLogin() 
	{
		Browser browser = getBrowser("chrome");
		navigate(browser, "https://www.way2automation.com/angularjs-protractor/banking/#/login");

		click("bmlBtn_CSS");
	
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"),"Bank manager not logged in");
		
	}



}
