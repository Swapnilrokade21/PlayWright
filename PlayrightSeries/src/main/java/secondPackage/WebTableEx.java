package secondPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;
import java.util.regex.Pattern;

public class WebTableEx {

	public static void main(String[] args) {
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://testautomationpractice.blogspot.com/");
		
		//Row COunt
		int rowCount = page.locator("[name='BookTable']>tbody>tr").count();
		System.out.println("Row Count: "+rowCount);
		
		//Column Count
		int colCount = page.locator("[name='BookTable']>tbody>tr:nth-child(2)>td").count(); 
		System.out.println("Column Count: "+colCount);
	
		//another way by "TH" Column Count
		int colCount1 = page.locator("[name='BookTable']>tbody>tr>th").count();
		System.out.println("Column Count: "+colCount1);
		
		assertThat(page.locator("[name='BookTable']>tbody>tr:nth-child(2)>td:nth-child(1)"))
											.hasText(Pattern.compile("learn selenium",Pattern.CASE_INSENSITIVE)); // equal ignore case
//											.hasText("Learn Selenium");  // it will check exact match if not get it fail
		
		//Print Table
		List<String> table = page.locator("[name='BookTable']>tbody").allInnerTexts();
		
		for(String i: table)
		{
			System.out.println(i);
		}
		System.out.println("-------------------------------");
		// Print Table with Lambda expression
		page.locator("[name='BookTable']>tbody").allInnerTexts().forEach(text -> {
			System.out.println(text);
		});

		page.close();
		browser.close();
		playwright.close();
	}

}
