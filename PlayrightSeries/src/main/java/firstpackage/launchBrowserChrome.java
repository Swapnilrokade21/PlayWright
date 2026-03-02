package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;


public class launchBrowserChrome {
	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create(); // Create a session
//		Browser browser = playwright.chromium().launch();    //headless

//Launch Chrome

		Browser browser = playwright.chromium().launch(
			    new BrowserType.LaunchOptions()
			        .setHeadless(false)
			        .setExecutablePath(
			            Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")
			        )
			);
					
//Launch FireFox
//		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)); 

		Page page = browser.newPage();
		page.navigate("https://www.way2automation.com/");
		System.out.println(page.title());

		Thread.sleep(3000); // Not required just add to see the browser as playwright is very fast
//		page.close(); // close page
//		playwright.close(); // close session

	}
}
