package firstpackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertC {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		page.onDialog(dialog -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Type: " + dialog.type() + " | Message: " + dialog.message());

			if (dialog.type().equals("prompt")) {
				dialog.accept("Swapnil");
			} else {
				dialog.accept();
			}
		}

		);

		page.locator("#confirmBtn").click();
		System.out.println(page.locator("#demo").innerText());
		page.locator("#alertBtn").click();
		System.out.println(page.locator("#demo").innerText());
		page.locator("#promptBtn").click();
		System.out.println(page.locator("#demo").innerText());
		page.waitForTimeout(2000);

		page.close();
		browser.close();
		playwright.close();

	}

}
