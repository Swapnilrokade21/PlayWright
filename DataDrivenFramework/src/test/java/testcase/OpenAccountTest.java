package testcase;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Constants;
import utilities.DataProviders;
import utilities.ExcelReader;
import utilities.DataUtil;

public class OpenAccountTest extends BaseTest {

	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException
	{

	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("BankManagerSuite", "AddCustomerTest", data.get("Runmode"), excel);
	
	browser = getBrowser(data.get("browser"));
	navigate(browser, Constants.URL);
	
	click("bmlBtn_CSS");
	click("openaccount_CSS");
	Thread.sleep(1000);
	
	select("customer_CSS",data.get("customer"));
	Thread.sleep(1000);
	
	select("currency_CSS",data.get("currency"));
	Thread.sleep(1000);
	click("process_CSS");
	
	Thread.sleep(2000);
	
}
	
}
