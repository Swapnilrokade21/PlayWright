package parameterisation;

import org.testng.annotations.Test;

public class MultiplerDataProviderHandler {
	
	@Test(dataProvider = "dp1", dataProviderClass = MultipleDataProvider.class)
	public void login(String username, String pass)
	{
		System.out.println(username+":-----:"+pass);
	}

	@Test(dataProvider = "dp2", dataProviderClass = MultipleDataProvider.class)
	public void userRegistration(String fname, String lname, String email)
	{
		System.out.println(fname+":-----:"+lname+":-----:"+email);
	}

}
