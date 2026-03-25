package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    // Helper method to sleep
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] testData() {
    	
    	Object[][] obj = (Object[][]) new Object();
    	
    	return obj;
    }
    
    public static void excelToJSONConverter(String excelFile, String jsonFile) throws IOException {

        FileInputStream fis = new FileInputStream(new File(excelFile));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Map<String, String>> dataList = new ArrayList<>();

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> rowMap = new LinkedHashMap<>();

            for (int j = 0; j < colCount; j++) {
                String key = headerRow.getCell(j).getStringCellValue();
                Cell cell = currentRow.getCell(j);

                String value = getCellValue(cell);
                rowMap.put(key, value);
            }

            dataList.add(rowMap);
        }

        workbook.close();
        fis.close();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile),dataList);

        System.out.println("JSON File created at path : "+jsonFile);

    }
    
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }
    
}
