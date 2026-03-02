package secondPackage;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class JSONARrayHandleAPITESTING {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		
		 APIRequestContext request = playwright.request().newContext(
			        new APIRequest.NewContextOptions()
			          .setIgnoreHTTPSErrors(true)
			      );
		 
//		APIRequestContext request = playwright.request().newContext();  
			
		APIResponse response = request.get("https://gorest.co.in/public/v2/users");
//		APIResponse response = request.get("https://jsonplaceholder.typicode.com/users/1");
		
		System.out.println(response.status());
		
		String responseBody = response.text();
		System.out.println(responseBody);
		
		//Reading JSON ARRYA 
		
		JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();

		JsonObject firstUser = jsonArray.get(0).getAsJsonObject();

		String name = firstUser.get("name").getAsString();
		System.out.println("First user name: " + name);

		System.out.println("------------------------------");
		for(int i = 0; i<jsonArray.size();i++)
		{
			  JsonObject user = jsonArray.get(i).getAsJsonObject();

			    int id = user.get("id").getAsInt();
			    name = user.get("name").getAsString();
			    String email = user.get("email").getAsString();
			    String status = user.get("status").getAsString();

			    System.out.println(id + " | " + name + " | " + email + " | " + status);
		}
		
		playwright.close();

	}

}
