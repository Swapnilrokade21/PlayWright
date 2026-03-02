package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name="bankManagerDP")
	public static Object[][] getDataSuite1(Method m) {

		System.out.println(m.getName());
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		String testcase = m.getName();
		return DataUtil.getData(testcase, excel);
	
	}
	
	@DataProvider(name="customerDP")
	public static Object[][] getDataSuite2(Method m) {

		System.out.println(m.getName());
		
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		String testcase = m.getName();
		return DataUtil.getData(testcase, excel);
	
	}

	@DataProvider(name = "addCustomerData")
	public Object getData() {
		//
		String sheetName = "addCustomer";

		ExcelReader excel = new ExcelReader("./src/test/resources/excel/addCustomerData.xlsx");

		int rowNum = excel.getRowCount(sheetName);
		int columnNum = excel.getColumnCount(sheetName);

		Object data[][] = new Object[rowNum - 1][columnNum];

		for (int i = 2; i <= rowNum; i++)
		{
			for(int j = 0; j<columnNum;j++)
			{
				data[i-2][j] =excel.getCellData(sheetName, j, i);
			}
		

		}

		return data;

	}



}
