package firstpackage;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleFileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		
		FrameLocator frame = page.frameLocator("#iframeResult");
		
		frame.locator("#files").setInputFiles(new Path[] {
				Paths.get("/Users/swapnil.rokade/Desktop/Test.png"),
				Paths.get("/Users/swapnil.rokade/Desktop/Test1.png"),
				Paths.get("/Users/swapnil.rokade/Desktop/Test3.png")
		});
		
		Thread.sleep(1000);
		frame.locator("[type='submit']").click();
		
		String s = frame.locator("body > div.w3-container.w3-large.w3-border").innerText();
		System.out.println(s);
		
	}

}
