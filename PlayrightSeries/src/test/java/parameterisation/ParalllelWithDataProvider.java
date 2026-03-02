package parameterisation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.microsoft.playwright.*;

public class ParalllelWithDataProvider {

    @DataProvider(name = "browserData", parallel = true)
    public Object[][] getData() {
        return new Object[][] {
                {"chrome"},
                {"firefox"}
        };
    }

    @Test(dataProvider = "browserData")
    public void test(String browserName) {

        Playwright playwright = Playwright.create();
        Browser browser = null;

        // Launch browser safely
        if (browserName.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setChannel("chrome")   // Real Chrome
                            .setHeadless(false));
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false));
        }
        else {
            throw new RuntimeException("Invalid browser: " + browserName);
        }

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.google.com/");
        System.out.println(browserName + " Title: " + page.title());

        // Cleanup
        context.close();
        browser.close();
        playwright.close();
    }
}