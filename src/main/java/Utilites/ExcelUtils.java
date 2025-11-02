package Utilites;



import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.*;

public class ExcelUtils {
    private String filePath;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtils(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    //  Get Row Count
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    //  Get Cell Data
    public String getCellData(int rowNum, int colNum) {
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }

    //  Set Cell Data
    public void setCellData(int rowNum, int colNum, String value) throws IOException {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);
        XSSFCell cell = row.getCell(colNum);
        if (cell == null) cell = row.createCell(colNum);
        cell.setCellValue(value);

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
    }

    //  Get All Data as List
    public List<List<String>> getAllData() {
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                rowData.add(row.getCell(j).getStringCellValue());
            }
            data.add(rowData);
        }
        return data;
    }

    //  Close Workbook
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}
