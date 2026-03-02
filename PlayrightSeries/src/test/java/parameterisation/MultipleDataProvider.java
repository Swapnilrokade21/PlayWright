package parameterisation;

import org.testng.annotations.DataProvider;

public class MultipleDataProvider {

	@DataProvider(name = "dp1")
	public Object[][] getdataLogin()
	{
		
		Object data[][] = new Object[2][2];
		
		data[0][0] = "Swapnil";
		data[0][1] = "@#QDASD";
		
		data[1][0] = "Surabhi";
		data[1][1] = "@#&#$#%";

		return data;
	}
	
	@DataProvider(name = "dp2")
	public Object[][] getdataRegister()
	{
		Object data[][] = new Object[2][3];
		
		data[0][0] = "Swapnil";
		data[0][1] = "Rokade";
		data[0][2] = "Swapnil@gmail.com";
		
		data[1][0] = "Surabhi";
		data[1][1] = "Rokade";
		data[1][2] = "Surabhi@gmail.com";
		return data;
		
	}
}
