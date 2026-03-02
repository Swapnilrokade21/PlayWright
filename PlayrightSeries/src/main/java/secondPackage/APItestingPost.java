package secondPackage;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class APItestingPost {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		
		 APIRequestContext request = playwright.request().newContext(
			        new APIRequest.NewContextOptions()
			          .setIgnoreHTTPSErrors(true)
			      );

		 Map<String, Object> data = new HashMap<>();
		 data.put("Name", "Swap");
		 data.put("Surname", "Rokade");
		 data.put("name", "Swapnil");
		 data.put("id", 100);
		 
//		 data.put("body", "Its SwapnilPC Dont hack");
			
		APIResponse response = request.post("https://698f0df4aded595c2533b069.mockapi.io/Playwright",RequestOptions.create().setData(data));
	
		System.out.println(response.status());
		System.out.println(response.text());
		
		request.dispose();
		playwright.close();


	}

}
