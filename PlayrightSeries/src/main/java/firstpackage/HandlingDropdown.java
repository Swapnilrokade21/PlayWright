package firstpackage;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class HandlingDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1792,934));
		
		Page page = browserContext.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		
		//select by value
		page.selectOption("select","hi");
		Thread.sleep(3000);
		//select by text
		page.selectOption("select", new SelectOption().setLabel("Eesti"));		
		Thread.sleep(3000);
		//select by index
		page.selectOption("select", new SelectOption().setIndex(2));
		Thread.sleep(3000);
		
		/*
		//get all values from dropdown list
		Locator value = page.locator("select > option");
		int count = value.count();
		System.out.println(count);
		
		for(int i = 0; i < count ; i++)
		{
			System.out.println(value.nth(i).innerText()+" @@ "+value.nth(i).getAttribute("lang"));
			
		}
		*/
		
		//get all values from dropdown list from Query method
		
		List<ElementHandle>	values =page.querySelectorAll("select > option");
		System.out.println(values.size());
		
		for(ElementHandle val: values)
		{
			System.out.println(val.innerText()+ "    "+val.getAttribute("lang"));
		}
		
		
	}

}
