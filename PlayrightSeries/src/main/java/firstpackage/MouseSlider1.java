package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class MouseSlider1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/slider");
		
		Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

		BoundingBox box = slider.boundingBox();
		
		Double startX = box.x + box.width/2; // middle X position of slider
		Double startY = box.y + box.height/2; // middle Y position of slider
		 
		page.mouse().move(startX,startY);
		Thread.sleep(3000);
		// Press and hold left mouse button (start drag)
		page.mouse().down();

		// Drag slider to the right by 100 pixels (keep Y same to stay on slider line)
		page.mouse().move(startX + 100,startY);

		// Release mouse button (end drag)
		page.mouse().up();
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();	

	}

}
