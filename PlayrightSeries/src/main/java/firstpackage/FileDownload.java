package firstpackage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.selenium.dev/downloads/");
		
		Download file= page.waitForDownload(() -> {
			page.locator("body > div > main > div.row.justify-content-center.px-5.pb-5 > div:nth-child(3) > div > div.card-body.px-0.text-center > p:nth-child(2) > a").click();
		});
		
//		file.saveAs(Paths.get("/Users/swapnil.rokade/Desktop/java.zip"));
		
		for(int i = 0;i<3;i++)
		{
			file.saveAs(Paths.get("/Users/swapnil.rokade/Desktop/java" +i+ ".zip"));
		}
	
		
		
	}

}
