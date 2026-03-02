package firstpackage;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class TestGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			    try (Playwright playwright = Playwright.create()) {
			      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
			        .setHeadless(false));
			      BrowserContext context = browser.newContext();
			      Page page = context.newPage();
			      page.navigate("https://demoqa.com/automation-practice-form");
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("SWAPNIL");
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("ROKADE");
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).fill("swap@gmail.com");
			      page.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile Number")).click();
			      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile Number")).fill("1234567890");
			      page.locator(".subjects-auto-complete__value-container").click();
			      page.locator("#subjectsInput").fill("te");
			      page.getByText("Computer Science", new Page.GetByTextOptions().setExact(true)).click();
			      page.getByText("Sports").click();
			      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
			    }

	}

}
