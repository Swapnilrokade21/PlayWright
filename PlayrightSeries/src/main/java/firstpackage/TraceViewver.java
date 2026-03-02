package firstpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.Locator.TypeOptions;

public class TraceViewver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		
		context.tracing().start(
				new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true)
				);
				
		Page page = context.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		page.locator("#firstName").type("Swapnil",new TypeOptions().setDelay(100));   
		page.locator("#userEmail").type("Swapnil@gmail.com",new TypeOptions().setDelay(100));
		
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();

	}

}
