package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class frameEx {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://demoqa.com/frames");

		System.out.println("---Normal Page---");
		Locator text = page.locator("//div[contains(text(),'Sample Iframe')]");

		System.out.println(text.innerText());
		
		System.out.println("---Frame Page---");
		text = page.frameLocator("#frame1").locator("#sampleHeading");
		System.out.println(text.innerText());
		
		
		System.out.println("-------Find Frames on Site-------");
		
		Locator frame = page.locator("iframe");
		System.out.println(frame.count());
		
		for(int i =0; i<frame.count();i++)
		{
			System.out.println(frame.nth(i).getAttribute("id"));
		}
		
		

		page.close();
		browser.close();
		playwright.close();

	}

}
