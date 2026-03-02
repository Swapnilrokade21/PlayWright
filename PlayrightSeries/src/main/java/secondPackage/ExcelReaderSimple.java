package secondPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderSimple {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String path = "/Users/swapnil.rokade/Desktop/ExcelReader.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Row row =	sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		 String value = cell.getStringCellValue();
		 System.out.println(value);
	}

}
