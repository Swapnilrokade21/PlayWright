package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.TypeOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Keyboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		page.locator("#firstName").type("Swapnil",new TypeOptions().setDelay(100));   
		page.locator("#userEmail").type("Swapnil@gmail.com",new TypeOptions().setDelay(100));

		page.keyboard().press("Meta+A");   //"Control+A" for windows
		Thread.sleep(1000);
		
		page.keyboard().press("Meta+X");
		Thread.sleep(1000);
		
		page.keyboard().press("Meta+V");   
		Thread.sleep(1000);
		
		page.keyboard().down("Shift");
		for(int i =0; i<=6; i++)
		{
			page.keyboard().press("ArrowLeft");
			Thread.sleep(500);
		}
		
		Thread.sleep(2000);
		page.keyboard().press("ArrowRight");
		page.keyboard().up("Shift");
		page.keyboard().press("ArrowRight");
		
		page.keyboard().press("Enter");
		Thread.sleep(1000);
		page.goBack();
		Thread.sleep(1000);
		page.goForward();
		
		page.locator("#userEmail").click();   // focus input
		page.keyboard().type("test@gmail.com");

		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();
		

		
	}

}
