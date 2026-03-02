package firstpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NonIncognitoModeLaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
//		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		//chromium
//		BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),new LaunchPersistentContextOptions().setHeadless(false));
		
		
		//Chrome
		BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),new LaunchPersistentContextOptions().setHeadless(false)
				.setExecutablePath(Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")));
		


 		Page page = browserContext.newPage();
 		
 		page.navigate("https://www.way2automation.com/");
		System.out.println(page.title());
		
		page.close();
		playwright.close();

	}

}
