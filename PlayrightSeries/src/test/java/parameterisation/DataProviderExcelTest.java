package parameterisation;
import java.util.Map;

import org.testng.annotations.Test;

public class DataProviderExcelTest {


	    @Test(priority = 1,dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	    public void doLogin(String Id, String Name,String Number) {

	        System.out.println(Id + " ::: " + Name+" ::: "+Number);
	        
	        

	    }
	    @Test(priority = 2)
	    public void test()
	    {
	    	System.out.println("________________________________");
	    }
	    
	    @Test(priority = 3,dataProvider = "loginDataMap", dataProviderClass = ExcelDataProvider.class)
	    public void doLogin(Map<String, String> data) {

	        System.out.println(
	            data.get("ID") + " ::: " +
	            data.get("Name") 
	   
	        );
	    }
	}

