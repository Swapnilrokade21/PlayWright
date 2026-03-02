package firstpackage;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class launchBrowserMaximise {
	public static void main(String[] args) throws InterruptedException {

		// Get size of screen using JAVA
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		System.out.println(width + "---" + height);

		Playwright playwright = Playwright.create(); // Create a session
//	Browser browser = playwright.chromium().launch();    //headless
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // without
																											// headless

		// set Size of laptop screen
//	BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1792,934));
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
		Page page = browserContext.newPage();
		page.navigate("https://www.way2automation.com/");
		System.out.println(page.title());

		Thread.sleep(3000); // Not required just add to see the browser as playwright is very fast
		page.close(); // close page
		playwright.close(); // close session

	}
}
