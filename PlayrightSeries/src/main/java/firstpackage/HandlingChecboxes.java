package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingChecboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/checkbox");
		
		page.locator("//*[@id=\"tree-node\"]/ol/li/span/button").click();
		
		Locator checkbox1 = page.locator("[type='checkbox']");
		Locator checkbox = page.locator("span.rct-checkbox");
	
		System.out.println(checkbox.count());
		
		for(int i = 0; i < checkbox.count();i++)
		{
			System.out.println(checkbox1.nth(i).getAttribute("id"));
			checkbox.nth(i).click();
			Thread.sleep(5000);
		}
		
		page.close();
		playwright.close();


	}

}
