package secondPackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadLoop {

	public static void main(String[] args) throws Exception {

		String path = "/Users/swapnil.rokade/Desktop/ExcelReader.xlsx";
		FileInputStream file = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");

		DataFormatter formatter = new DataFormatter();

		int rowCount = sheet.getLastRowNum();
		
		System.out.println("rowCount :"+rowCount);

		for (int i = 0; i <= rowCount; i++) { 

			Row row = sheet.getRow(i);

			if (row == null)
				continue;

			String id = formatter.formatCellValue(row.getCell(0));
			String name = formatter.formatCellValue(row.getCell(1));
			String mobile = formatter.formatCellValue(row.getCell(2));

			if (id == null || id.trim().isEmpty())
				continue;

			System.out.println(id + " | " + name + " | " + mobile);
		}

		workbook.close();
		file.close();
	}
}
