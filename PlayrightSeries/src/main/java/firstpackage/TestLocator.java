package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class TestLocator {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1792,934));
		
		Page page = browserContext.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		
		page.locator("#firstName").fill("Swapnil");
		
		page.locator("[id='lastName']").fill("Rokade");
		
		page.locator("id=userEmail").fill("s@gmail.com");
		
		page.type("id=userNumber", "8888888888",new TypeOptions().setDelay(100));
		
//		page.click("text=Submit");
		page.click("button:has-text('Submit')");
		
		String text = page.locator("//*[@id='hobbiesWrapper']/div[2]/div[1]/label").innerText();
		System.out.println(text);
		
		
		Thread.sleep(3000);
		page.close();
		playwright.close();
		

	}

}
