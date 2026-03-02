package rough;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;

import base.BaseTest;

public class LogInTest extends BaseTest {

	@Test(priority =1)
	public void searhPlaywright() throws InterruptedException {
		Browser browser = getBrowser("chrome");
		navigate(browser, "https://www.google.com/");
		fill("searchBox", "Playwright");
		Thread.sleep(2000);
	}

	@Test(priority =2)
	public void searhJava() throws InterruptedException
	{
		Browser browser = getBrowser("firefox");
		navigate(browser, "https://www.google.com/");
		fill("searchBox","java");
		Thread.sleep(2000);
		
	}
}
