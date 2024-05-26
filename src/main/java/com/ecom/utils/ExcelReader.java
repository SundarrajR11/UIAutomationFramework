package com.ecom.utils;

import com.ecom.constants.FrameConstants;
import com.ecom.exceptions.InValidExcelPathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class ExcelReader {
    private ExcelReader(){

    }
    public static List<Map<String,String>> getSheetData(String sheetName) {
        ArrayList<Map<String,String>> list =null;

        // Use Try with resources when variable class implements AutoCloseable interface
        // Hence need to close using finally block

        try(final FileInputStream  fs = new FileInputStream(FrameConstants.getExcelPath());) {
           XSSFWorkbook workbook= new XSSFWorkbook(fs);
           XSSFSheet sheet=workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum(); // as it's 0-based
            int colNum=sheet.getRow(0).getLastCellNum(); // her It's 1-based
            Map<String,String> hm=null;
            list = new ArrayList<>();
            for (int i = 1; i <=rowNum; i++) {
                hm= new HashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value=sheet.getRow(i).getCell(j).getStringCellValue();
                    hm.put(key,value);
                }
                list.add(hm);
            }

        }
        catch (IOException e){
           throw new InValidExcelPathException("Please the check the path of excel file.",e);
        }
    return list;
    }
}
