package firstpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.TypeOptions;

public class VideoCapture {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//Video Creation
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("/Users/swapnil.rokade/Desktop/")));
				
		Page page = context.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		page.locator("#firstName").type("Swapnil",new TypeOptions().setDelay(100));   
		page.locator("#userEmail").type("Swapnil@gmail.com",new TypeOptions().setDelay(100));
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		/*
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
		*/
	}

}
