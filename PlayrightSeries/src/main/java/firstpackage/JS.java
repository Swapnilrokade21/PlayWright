package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class JS {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page  = browser.newPage();
		page.navigate("https://google.com");
	
		
		String link = (String) page.evaluate("document.location.href");
		System.out.println(link);
		
		page.evaluate("()=>{"
				+ " const textarea = document.createElement('textarea');"     // CREATE the Element
				+ " document.body.append(textarea); "						 // Append the Element					
				+ " textarea.focus(); " 									 // focus
				+ "}");
		
		String text = "Hello";
		page.keyboard().type(text);
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();
				

	}

}
