package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import com.tmb.exceptions.FrameworkException;
import com.tmb.exceptions.InvalidPathForExcellException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils() {}


    public static List<Map<String, String>> getTestDetails(String sheetName) {

        List<Map<String, String>> list = null;
//        FileInputStream fs = null;
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {

//         fs = new FileInputStream(FrameworkConstants.getExcelpath());
        XSSFWorkbook  workbook = new XSSFWorkbook(fs);

//        String sheetName = "RUNMANAGER";
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
            System.out.println(lastRowNum);
            int lastColNum = sheet.getRow(0).getLastCellNum();
            System.out.println(lastColNum);

            Map<String, String> map = null;
             list = new ArrayList<>();

            for(int i =1;i<=lastRowNum;i++) {
                map = new HashMap<>();//this can store some value
                for(int j=0;j<=lastColNum;j++) {

                    DataFormatter formatter = new DataFormatter();

                    String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                     System.out.println("key is "+key);

                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    System.out.println("value is "+value);

//                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
//                    String value = sheet.getRow(i).getCell(j).getStringCellValue();

                    map.put(key, value);

                }
                list.add(map);
                System.out.println(list);
            }

        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcellException("Some io exception on finding path of excel file");
        }catch (IOException e) {
            throw new FrameworkException("Some io exception happened while reading excel file");
        }
        return list;

    }
}
