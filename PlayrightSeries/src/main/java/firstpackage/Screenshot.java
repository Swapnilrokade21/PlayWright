package firstpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class Screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://demoqa.com/droppable");
		
		ScreenshotOptions screen = new ScreenshotOptions();
		
//PAGE FULL Screenshot using object
		page.screenshot(screen.setPath(Paths.get("/Users/swapnil.rokade/Desktop/PageScreenshot1.png")));
		page.goBack();
//PAGE FULL Screenshot 
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("/Users/swapnil.rokade/Desktop/PageScreenshot2.png")));
		page.goForward();
//ELEMENT FULL Screenshot
		page.locator("#draggable").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("/Users/swapnil.rokade/Desktop/ElementScreenshot1.png")));
		
//ELEMENT FULL Screenshot using Object
		Locator.ScreenshotOptions elementScreen = new Locator.ScreenshotOptions();
		page.locator("#droppable").first().screenshot(elementScreen.setPath(Paths.get("/Users/swapnil.rokade/Desktop/ElementScreenshot2.png")));
		
//Full Page Screenshot
		page.screenshot(new ScreenshotOptions()
		        .setPath(Paths.get("/Users/swapnil.rokade/Desktop/fullpage.png"))
		        .setFullPage(true));

		

		
	}

}
