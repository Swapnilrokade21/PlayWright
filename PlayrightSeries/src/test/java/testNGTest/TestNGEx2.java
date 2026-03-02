package testNGTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


 class TestNGEx2 {

	    @Test
	    public void test1() throws InterruptedException {
	        System.out.println("2TestNG Working Fine2");
	    	Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			
			page.navigate("https://google.com");
	    }
	}

