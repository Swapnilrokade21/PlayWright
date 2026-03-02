package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class frameEx2 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://testing.qaautomationlabs.com/iframe.php");

		System.out.println("---------Frame 1---------");

		// Locate iframe1 by its "name" attribute
		FrameLocator frame1 = page.frameLocator("[name='iframe1']");

		// Inside iframe1, locate the <h4> element containing text "I am iFrame 1"
		Locator text1 = frame1.locator("//h4[contains(text(),'I am iFrame 1')]");

		// Print the inner text of the <h4> element
		System.out.println(text1.innerText());

		// Inside iframe1, locate the button containing text "Click" and click it
		frame1.locator("//button[contains(text(),'Click')]").click();

		// After clicking, read the message displayed on the main page (outside iframe)
		String text = page.locator("//p[@id='message']").innerText();

		// Optional: wait for 2 seconds to visually see changes (not necessary in
		// automation)
		page.waitForTimeout(2000);

		// Print the message displayed after clicking the button in frame 1
		System.out.println("frame 1 = " + text);

		// ---------------- Frame 2 ----------------
		System.out.println("---------Frame 2---------");

		// Locate iframe2 by its "name" attribute
		FrameLocator frame2 = page.frameLocator("[name='iframe2']");

		// Inside iframe2, locate the <h4> element with exact text "I am IFrame 2"
		Locator text2 = frame2.locator("//h4[text()='I am IFrame 2']");

		// Print the inner text of the <h4> element
		System.out.println(text2.innerText());

		// Inside iframe2, locate the button containing text "Click" and click it
		frame2.locator("//button[contains(text(),'Click')]").click();

		// Read the message displayed on the main page after clicking the button in
		// frame 2
		String text3 = page.locator("//p[@id='message']").innerText();

		// Optional: wait for 2 seconds
		page.waitForTimeout(2000);

		// Print the message displayed after clicking the button in frame 2
		System.out.println("frame 2 = " + text3);

		page.close();
		browser.close();
		playwright.close();
	}
}
