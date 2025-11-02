package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

public class ReadCruiseDetailsFromExcel {

    public static List<String> readExcelWords() throws IOException {
        List<String> listWords = new ArrayList<>();
        String excelFilePath = System.getProperty("user.dir")
                + File.separator + "TestData"
                + File.separator + "Cruise_User_Details.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    listWords.add(cell.getStringCellValue());
                }
            }
        }

        workbook.close();
        inputStream.close();
        return listWords;
    }
}