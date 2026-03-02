package secondPackage;

import java.io.IOException;

import utilities.ExcelReaderUtility;

public class ExcelRead {

	public static void main(String[] args) throws Exception {

		ExcelReaderUtility excel = new ExcelReaderUtility("/Users/swapnil.rokade/Desktop/ExcelReader.xlsx", "Sheet1");

		int rows = excel.getRowCount();

		for (int i = 1; i < rows; i++) {

			String id = excel.getCellDataByColumnName(i, "ID");
			if (id == null || id.trim().isEmpty()) {
				continue;
			}
			String name = excel.getCellDataByColumnName(i, "Name");
			String mobile = excel.getCellDataByColumnName(i, "Mobile Number");

			System.out.println(id + " | " + name + " | " + mobile);
		}

		excel.closeExcel();
	}
}
