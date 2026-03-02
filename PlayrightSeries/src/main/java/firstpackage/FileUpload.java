package firstpackage;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://demoqa.com/automation-practice-form");
		
		page.locator("[type='file']").setInputFiles(Paths.get("/Users/swapnil.rokade/Desktop/Test1.png"));
		Thread.sleep(3000);
		page.locator("#uploadPicture").setInputFiles(Paths.get("/Users/swapnil.rokade/Desktop/Test.png"));
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();
	}

}
