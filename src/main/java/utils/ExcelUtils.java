package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple utility class to read test data from an Excel file.
 * This class uses the Apache POI library.
 */
public class ExcelUtils {

    // Define the path to the Excel file. This path is relative to the project's root directory.
    private static final String TEST_DATA_FILE_PATH = "src/test/resources/testdata/DataSource.xlsx";

    public static List<Object[]> getTestData(String sheetName) {
        // This List will hold all the rows of data we read from the Excel sheet.
        List<Object[]> testData = new ArrayList<>();
        
        // We use a FileInputStream to open and read the Excel file.
        try (FileInputStream fis = new FileInputStream(new File(TEST_DATA_FILE_PATH));
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the specific sheet from the workbook by its name.
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet with name '" + sheetName + "' not found in the Excel file.");
            }

            // Loop through each row in the sheet, starting from the second row (index 1) to skip the header row.
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                
                // Get the number of cells in the current row.
                int cellCount = row.getLastCellNum();
                // Create an Object array to hold the data for the current row.
                Object[] rowData = new Object[cellCount];
                
                // Loop through each cell in the current row.
                for (int j = 0; j < cellCount; j++) {
                    Cell cell = row.getCell(j);
                    // Read the value from the cell and add it to our rowData array.
                    // We format the cell as a String to handle both numbers and text easily.
                    rowData[j] = new DataFormatter().formatCellValue(cell);
                }
                // Add the completed row of data to our main list.
                testData.add(rowData);
            }

        } catch (IOException e) {
            // If the file can't be found or read, print an error message.
            e.printStackTrace();
        }

        // Return the complete list of test data.
        return testData;
    }
}
