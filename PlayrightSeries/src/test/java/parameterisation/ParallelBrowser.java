package parameterisation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ParallelBrowser {
	Playwright playwright;
	Browser browser;
	Page page;
	BrowserContext context;
	
	@Parameters("browser")
	@BeforeMethod
	public void browser(String browserName)
	{
		 playwright = Playwright.create();
		
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
			 browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 }
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 }
		 
		  context = browser.newContext();
	      page = context.newPage();
		 
	}
	
	@Test
	public void test()
	{
		page.navigate("https://www.google.com/");
		System.out.println(page.title());
	}
	
	@AfterMethod
	public void closebrowser()
	{
		context.close();
		page.close();
		browser.close();
		playwright.close();
	}

}
