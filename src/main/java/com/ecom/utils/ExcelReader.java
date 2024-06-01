package com.ecom.utils;

import com.ecom.constants.FrameConstants;
import com.ecom.exceptions.InValidExcelPathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Utility class for reading data from Excel sheets.
 *
 * <p>This class provides a method to read data from a specified Excel sheet and return it as a list of maps,
 * where each map represents a row with column names as keys.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * List<Map<String, String>> data = ExcelReader.getSheetData("Sheet1");
 * }
 * </pre>
 */
public final class ExcelReader {

    /**
     * Private constructor to prevent instantiation.
     */
    private ExcelReader() {
    }

    /**
     * Reads data from the specified Excel sheet.
     *
     * <p>This method reads the Excel file located at the path specified by {@link FrameConstants#getExcelPath()},
     * extracts data from the sheet with the given name, and returns it as a list of maps. Each map represents a row,
     * with column headers as keys and cell values as values.</p>
     *
     * @param sheetName the name of the sheet to read data from.
     * @return a list of maps, where each map represents a row of data with column headers as keys.
     * @throws InValidExcelPathException if there is an issue reading the Excel file.
     */
    public static List<Map<String, String>> getSheetData(String sheetName) {
        ArrayList<Map<String, String>> list = null;

        try (final FileInputStream fs = new FileInputStream(FrameConstants.getExcelPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum(); // 0-based
            int colNum = sheet.getRow(0).getLastCellNum(); // 1-based
            Map<String, String> hm = null;
            list = new ArrayList<>();
            for (int i = 1; i <= rowNum; i++) {
                hm = new HashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    hm.put(key, value);
                }
                list.add(hm);
            }
        } catch (IOException e) {
            throw new InValidExcelPathException("Please check the path of the Excel file: " + FrameConstants.getExcelPath(), e);
        }
        return list;
    }
}