package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import extentlisteners.ExtentListeners;

public class BaseTest {

	private Playwright playwright;
	public Browser browser;
	public Page page;
	private static Properties OR = new Properties();
	private static FileInputStream fis;
	private Logger log = Logger.getLogger(this.getClass());

	// Thread Safe
	private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
	private static ThreadLocal<Browser> br = new ThreadLocal<>();
	private static ThreadLocal<Page> pg = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return pw.get();
	}

	public static Browser getBrowser() {
		return br.get();
	}

	public static Page getPage() {
		return pg.get();
	}

	@BeforeSuite
	public void setUp() throws FileNotFoundException {
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test Execution Start");
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		try {
			OR.load(fis);
			log.info("OR Properties fiel Loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@BeforeMethod
	public Browser getBrowser(String browserName) {
		playwright = Playwright.create();
		pw.set(playwright); // Thread safe

		switch (browserName) {
		case "chrome":
			log.info("Launching Chrome Browser");
			return getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		case "headless":
			log.info("Launching Headless Browser");
			return getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		case "firefox":
			log.info("Launching Firefox Browser");
			return getPlaywright().firefox()
					.launch(new BrowserType.LaunchOptions().setHeadless(false));
		case "webkit":
			log.info("Launching Safari Browser");
			return getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName);
		}
	}

	public void navigate(Browser browser, String url) {
		this.browser = browser;
		br.set(browser); // Thread safe
		page = getBrowser().newPage();
		pg.set(page); // Thread safe
		getPage().navigate(url);
		log.info("Navigate to: " + url);
	}

	@AfterMethod
	public void quit() {
		if(getBrowser() != null && getPage() !=null && getPlaywright()!=null)
		{
			getPage().close();
			getBrowser().close();
			getPlaywright().close();
		}
		
	}

	public void click(String locatorkey) {
		try {
			getPage().locator(OR.getProperty(locatorkey)).click();
			log.info("Clicking on an Element" + locatorkey);
			ExtentListeners.getExtent().info("Clicking on a element " + locatorkey);

		} catch (Throwable t) {
			log.error("Error while clicking on a element" + t.getMessage());
			ExtentListeners.getExtent().fail("Error while clicking on a element " + t.getMessage());
			Assert.fail(t.getMessage());
		}
	}

	public void fill(String locatorkey, String value) {
		try {
			getPage().locator(OR.getProperty(locatorkey)).fill(value);
			log.info("Typing in an Element" + locatorkey);
			ExtentListeners.getExtent().info("Typing in a element " + locatorkey + "value = " + value);

		} catch (Throwable t) {
			log.error("Error while typing in a element" + t.getMessage());
			ExtentListeners.getExtent().fail("Error while typing in a element " + t.getMessage());
			Assert.fail(t.getMessage());

		}
	}
	
	public void select(String locatorkey, String value) {
		try {
			getPage().selectOption(OR.getProperty(locatorkey), new SelectOption().setLabel(value));
			log.info("Selecting an option" + locatorkey);
			ExtentListeners.getExtent().info("Selecting an option " + locatorkey + "value = " + value);

		} catch (Throwable t) {
			log.error("Error while Selecting an option" + t.getMessage());
			ExtentListeners.getExtent().fail("Error while Selecting an option " + t.getMessage());
			Assert.fail(t.getMessage());

		}
	}

	public boolean isElementPresent(String locatorkey) {
		try {
			getPage().waitForSelector(OR.getProperty(locatorkey), new WaitForSelectorOptions().setTimeout(2000));
			log.info("Element is Present on page" + locatorkey);
			ExtentListeners.getExtent().info("TElement is Present on page " + locatorkey);
			return true;

		} catch (Throwable t) {
			log.error("Element is NOT Present on page" + t.getMessage());
			ExtentListeners.getExtent().fail("Element is NOT Present on page " + t.getMessage());
			Assert.fail(t.getMessage());
			return false;

		}

	}

}
