package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		
		page.locator("#input").fill("playwright");
//		page.locator("#input").type("playwright");
		
				
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();	
	}

}
