//package secondPackage;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//
//public class TestLog4J {
//
//	public static void main(String[] args) throws IOException, InterruptedException {
//		
//Logger log = Logger.getLogger(TestLog4J.class);
//PropertyConfigurator.configure("./src/test/resources/Properties/log4j.properties");
//		
//		Playwright playwright = Playwright.create();
//		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page page = browser.newPage();
//		page.navigate("https://practicetestautomation.com/practice-test-login/");
//		
//log.info("Website Open");
//		
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("./src/test/resources/Properties/locators.properties");
//		prop.load(fis);
//log.info("Properties File Loaded");
//		
//		page.locator(prop.getProperty("UserNameLocator")).fill(prop.getProperty("Username"));
//		page.locator(prop.getProperty("PasswordLocator")).fill(prop.getProperty("Password"));
//		page.locator(prop.getProperty("loginButton")).click();
//log.error("Log in Site");
//
//		page.locator("#loop-container > div > article > div.post-content > div > div > div > a").click();
//		Thread.sleep(3000);
//log.warn("Log Out from Site");
//// OR 	
////		again login by prop.get
//		page.locator((String) prop.get("UserNameLocator")).fill((String) prop.get("Username"));
//		page.locator((String) prop.get("PasswordLocator")).fill((String) prop.get("Password"));
//		page.locator((String) prop.get("loginButton")).click();
//log.info("Again Log in to Site");
//		
//		
//		
//		
//		
//	}
//
//}
