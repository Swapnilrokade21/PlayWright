package parameterisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import utilities.ExcelReaderUtility;

public class ExcelDataProvider {

	private String path = "/Users/swapnil.rokade/Desktop/ExcelReader.xlsx";

	// ✅ 1️⃣ For String parameters (Id, Name, Number)
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws Exception {

		ExcelReaderUtility excel = new ExcelReaderUtility(path, "Sheet1");

		int rowCount = excel.getRowCount();
		List<Object[]> dataList = new ArrayList<>();

		for (int i = 1; i < rowCount; i++) { // Skip header row

			String id = excel.getCellData(i, 0);
			String name = excel.getCellData(i, 1);
			String number = excel.getCellData(i, 2);

			// ✅ Skip completely blank rows
			if ((id == null || id.trim().isEmpty()) && (name == null || name.trim().isEmpty())
					&& (number == null || number.trim().isEmpty())) {
				continue;
			}

			dataList.add(new Object[] { id, name, number });
		}

		excel.closeExcel();
		return dataList.toArray(new Object[0][]);
	}

	// ✅ 2️⃣ For Map parameters
	@DataProvider(name = "loginDataMap")
	public Object[][] getLoginDataMap() throws Exception {

		ExcelReaderUtility excel = new ExcelReaderUtility(path, "Sheet1");

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		List<Object[]> dataList = new ArrayList<>();

		for (int i = 1; i < rowCount; i++) {

			Map<String, String> rowMap = new HashMap<>();

			boolean isRowEmpty = true;

			for (int j = 0; j < colCount; j++) {

				String header = excel.getCellData(0, j);
				String value = excel.getCellData(i, j);

				if (value != null && !value.trim().isEmpty()) {
					isRowEmpty = false;
				}

				rowMap.put(header, value);
			}

			// ✅ Skip blank rows
			if (isRowEmpty) {
				continue;
			}

			dataList.add(new Object[] { rowMap });
		}

		excel.closeExcel();
		return dataList.toArray(new Object[0][]);
	}
}