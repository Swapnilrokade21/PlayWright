package assignments;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BookFLight {
	Playwright playwright;
	Browser browser;
	Page page;

	@BeforeMethod
	public void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = context.newPage();
		page.navigate("https://blazedemo.com/");
	}
	
	@Test
	public void testFlight()
	{
		System.out.println(page.title());
		page.selectOption("[name='fromPort']","Boston");
		page.selectOption("[name='toPort']", "Rome");
		
		page.locator("[type='submit']").click();
		
		List<String> list = page.locator("//html/body/div[2]/table/tbody/tr/td[3]").allInnerTexts();
		
		for(String l: list)
		{
			System.out.println("FLight Company : "+l);
		}
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();

	}

}
