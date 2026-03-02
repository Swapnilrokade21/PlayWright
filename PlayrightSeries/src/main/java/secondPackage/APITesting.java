package secondPackage;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class APITesting {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		 APIRequestContext request = playwright.request().newContext(
			        new APIRequest.NewContextOptions()
			          .setIgnoreHTTPSErrors(true)
			      );
		 
//		APIRequestContext request = playwright.request().newContext();  
			
//		APIResponse response = request.get("https://gorest.co.in/public/v2/users");
		APIResponse response = request.get("https://jsonplaceholder.typicode.com/users/1");
		
		System.out.println(response.status());
		
		String responseBody = response.text();
		System.out.println(responseBody);
		
		//Reading JSON Body 
		
		JsonObject jsonResponse =	JsonParser.parseString(responseBody).getAsJsonObject();
		
		String name = jsonResponse.get("name").getAsString();
		String phone = jsonResponse.get("phone").getAsString();
		
		System.out.println("name :- "+name);
		System.out.println("phone :- "+phone);
		

		for (String key : jsonResponse.keySet()) {
		    System.out.println(key + " : " + jsonResponse.get(key));
		}
		
		
		playwright.close();
		
		
		
	}

}
