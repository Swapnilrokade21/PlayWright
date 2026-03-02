package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class MouseResizer {
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");
		
		Locator slider = page.locator("#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se");

		double startX = slider.boundingBox().x + slider.boundingBox().width/2;
		double startY = slider.boundingBox().y +slider.boundingBox().height/2;
		Thread.sleep(3000);
		
		page.mouse().move(startX, startY);
		page.mouse().down();
		
		page.mouse().move(startX+400, startY+400);
		page.mouse().up();
				
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();	
		
	}

}
