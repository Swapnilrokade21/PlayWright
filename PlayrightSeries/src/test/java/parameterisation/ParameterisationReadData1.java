package parameterisation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterisationReadData1 {

	@Test(dataProvider="getData")
	public void doLogin(String username, String password)
	{
		System.out.println(username+"::::"+password );
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "swapnil@gmail.com";
		data[0][1] = "swapnil";
		
		data[1][0] = "s@gmail.com";
		data[1][1] = "swap";
		
		data[2][0] = "swap@gmail.com";
		data[2][1] = "paws";
	
		return data;
	}
}
