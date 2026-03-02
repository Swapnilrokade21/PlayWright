package secondPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;;

public class AssertionTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		
		// Assertion on Page
		assertThat(page).hasURL("https://demoqa.com/automation-practice-form"); 		//PASS
		assertThat(page).hasTitle("DEMOQA");  										//PASS
		
		//Assertion on Locator
		assertThat(page.locator("#hobbies-checkbox-1")).isVisible();  //PASS
		
		page.locator("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
		
		assertThat(page.locator("#hobbies-checkbox-1")).isChecked();	//PASS
		
		assertThat(page.locator("#hobbies-checkbox-2")).isChecked();	//FAIL

		page.close();
		browser.close();
		playwright.close();
		
		
	}

}
