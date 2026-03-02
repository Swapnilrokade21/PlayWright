package secondPackage;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class APItestingPost2 {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        APIRequestContext request = playwright.request().newContext(
                new APIRequest.NewContextOptions().setIgnoreHTTPSErrors(true)
        );

        for (int i = 1; i <= 10; i++) {

            Map<String, Object> data = new HashMap<>();
            data.put("name", "Swapnil" + i);
            data.put("surname", "Rokade" + i);
            data.put("phone", "99999999" + i);
            data.put("email", "swapnil" + i + "@gmail.com");

            APIResponse response = request.post(
                    "https://698f0df4aded595c2533b069.mockapi.io/Playwright",
                    RequestOptions.create().setData(data)
            );

            System.out.println("User " + i + " Status: " + response.status());
            System.out.println(response.text());
            System.out.println("---------------------------");
        }

        request.dispose();
        playwright.close();
    }
}
