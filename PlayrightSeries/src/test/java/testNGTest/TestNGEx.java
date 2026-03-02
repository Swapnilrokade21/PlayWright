package testNGTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


 class TestNGEx {

	    @Test
	    public void test1() throws InterruptedException {
	        System.out.println("TestNG Working Fine");
	    	Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			
			page.navigate("https://demoqa.com");
	    }
	}

