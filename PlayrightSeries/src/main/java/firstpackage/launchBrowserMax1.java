package firstpackage;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class launchBrowserMax1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page = context.newPage();
		
		page.navigate("https://www.way2automation.com/");
		System.out.println(page.title());
		
		page.close();
		playwright.close();
	}

}
