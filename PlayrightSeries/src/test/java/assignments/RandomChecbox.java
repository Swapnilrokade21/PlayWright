package assignments;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RandomChecbox {
	Playwright playwright;
	Browser browser;
	Page page;

	@BeforeMethod
	public void launchBrowser() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page = context.newPage();
		page.navigate("https://demoqa.com/automation-practice-form");
	}
	
	@Test
	public void testFlight()
	{
		Locator checkbox =  page.locator("label[for^='hobbies-checkbox']");
		
		int totalCount = checkbox.count();
		System.out.println("checkbox count = "+totalCount);
		
		Random random = new Random();
	    int idx = random.nextInt(totalCount);
	    System.out.println("Selecting Random index"+idx);
	    checkbox.nth(idx).click();
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();

	}

}
