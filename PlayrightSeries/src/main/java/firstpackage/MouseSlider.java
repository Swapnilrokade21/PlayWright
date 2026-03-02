package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MouseSlider {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://demoqa.com/slider");
		
		Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

		// Move mouse pointer to the center of the slider (starting point)
		page.mouse().move(
		        slider.boundingBox().x + slider.boundingBox().width / 2,   // middle X position of slider
		        slider.boundingBox().y + slider.boundingBox().height / 2   // middle Y position of slider
		);

		// Press and hold left mouse button (start drag)
		page.mouse().down();

		// Drag slider to the right by 100 pixels (keep Y same to stay on slider line)
		page.mouse().move(
		        slider.boundingBox().x + 100,                              // move 100px right from slider start
		        slider.boundingBox().y + slider.boundingBox().height / 2   // keep same Y (center)
		);

		// Release mouse button (end drag)
		page.mouse().up();

		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();
	}

}
