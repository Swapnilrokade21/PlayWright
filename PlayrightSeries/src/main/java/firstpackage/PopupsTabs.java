package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PopupsTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/browser-windows");
		
		Page popup = page.waitForPopup(()->{
			page.locator("#tabButton").click();
		});
		
	
		String text = popup.locator("#sampleHeading").innerText();   // print POP UP page element
		System.out.println(text);
		
		System.out.println(page.locator("#windowButtonWrapper").innerText());  // print first page element
		Thread.sleep(3000);
		
		page.close();
		browser.close();
		playwright.close();
		

	}

}
