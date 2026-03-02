package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class basicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));

		Page page = browserContext.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		
		System.out.println(page.locator("body").innerText());
		
		
	
	
		

	}

}
