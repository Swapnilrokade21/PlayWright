package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NavigateMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.way2automation.com/");
		System.out.println(page.title());
		Thread.sleep(1000);
		
		page.navigate("https://www.flipkart.com/");
		System.out.println(page.title());
		Thread.sleep(1000);
		
		page.goBack();
		System.out.println(page.title());
		Thread.sleep(1000);
		
		page.reload();
		System.out.println(page.title());
		Thread.sleep(1000);
		
		page.goForward();
		System.out.println(page.title());
		
		Thread.sleep(1000);
		page.goBack(new Page.GoBackOptions().setTimeout(5000));
		Thread.sleep(1000);
		page.goForward(new Page.GoForwardOptions().setTimeout(5000));
		
		page.close();
		playwright.close();
		
		
	}

}
