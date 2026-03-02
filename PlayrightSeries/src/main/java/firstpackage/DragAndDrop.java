package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
		
		Locator drag = page.locator("#draggable");
		Locator drop = page.locator("#droppable");
		
		
		// finding middle
		double startDragX = drag.boundingBox().x + drag.boundingBox().width/2;
		double startDragY = drag.boundingBox().y + drag.boundingBox().height/2;
		double startDropX = drop.boundingBox().x + drop.boundingBox().width/2;
		double startDropY = drop.boundingBox().y + drop.boundingBox().height/2;
		
		Thread.sleep(3000);
		page.mouse().move(startDragX, startDragY);
		page.mouse().down();
		
		page.mouse().move(startDropX, startDropY);
		page.mouse().down();
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();	
		
	}

}
