package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HandlingLinks {
	public static void main(String[] args) {
		
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1792,934));
		
		Page page = browserContext.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		
		Locator links = page.locator("a");
		System.out.println(links.count()); 
		
		for(int i = 0; i <links.count(); i++)
		{
			System.out.println(links.nth(i).innerText()+"URL :"+links.nth(i).getAttribute("href"));
		}
		
		System.out.println("_________Page block links print_________________");
		
		Locator block = page.locator("#www-wikipedia-org > footer > nav");
		
		Locator blocklinks = block.locator("a");
		
		System.out.println(blocklinks.count());
		
		for(int i = 0; i< blocklinks.count();i++)
		{
			System.out.println(blocklinks.nth(i).innerText()+"URL: "+blocklinks.nth(i).getAttribute("href"));
		}
		
		page.close();
		playwright.close();
		
		
	}

}
