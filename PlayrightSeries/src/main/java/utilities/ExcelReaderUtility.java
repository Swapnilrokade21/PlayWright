package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {

    private Workbook workbook;
    private Sheet sheet;

    // Constructor
    public ExcelReaderUtility(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get row count
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get column count (based on first row)
    public int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // Get cell data
    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        return formatter.formatCellValue(cell);
    }

    // Get cell data by column name
    public String getCellDataByColumnName(int rowNum, String colName) {
        int colIndex = -1;

        Row headerRow = sheet.getRow(0);

        for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
            if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) {
            throw new RuntimeException("Column name not found: " + colName);
        }

        return getCellData(rowNum, colIndex);
    }

    // Close workbook
    public void closeExcel() throws IOException {
        workbook.close();
    }
}
