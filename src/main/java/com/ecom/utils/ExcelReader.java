package com.ecom.utils;

import com.ecom.frameconstants.FrameConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelReader {
    private ExcelReader(){

    }
    public static List<Map<String,String>> getSheetData(String sheetName) {
        ArrayList<Map<String,String>> list =null;
        FileInputStream fs=null;
        try {
           fs = new FileInputStream(FrameConstants.getExcelPath());
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
            e.printStackTrace();
        }
        finally {
            try {
                if(Objects.nonNull(fs)){
                    fs.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    return list;
    }
}
