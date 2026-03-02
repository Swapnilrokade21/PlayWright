package testcase;


import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;

import base.BaseTest;
import extentlisteners.ExtentListeners;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class AddCustomer extends BaseTest {

	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "bankManagerDP")
	public void addCustomerTest(Hashtable<String,String> data)
			throws InterruptedException {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("BankManagerSuite", "AddCustomerTest", data.get("Runmode"), excel);
		
		browser = getBrowser(data.get("browser"));
		navigate(browser, Constants.URL);
		Thread.sleep(2000);
		click("bmlBtn_CSS");
	
		click("addCustBtn_CSS");
		
		fill("firstname_CSS", data.get("firstname"));
		
		fill("lastname_XPATH", data.get("lastname"));
		
		fill("postcode_CSS", data.get("postcode"));
		
		click("addbtn_CSS");
		

		getPage().onceDialog(dialog -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.accept();
			ExtentListeners.getExtent().info("Clicking on a alert " + dialog.message());

		});
	}

}
