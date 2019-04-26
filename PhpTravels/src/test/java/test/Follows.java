package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Follows {
	WebDriver driver;

	@Test
	@Parameters({"userid","password"})
	public void login(String usr, String pwd) {
		driver = new ChromeDriver();
		driver.get("");
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void links() throws IOException {
		
		try {
            FileInputStream file = new FileInputStream(new File("urls.xlsx"));
 
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        driver.get(cell.getStringCellValue());
                        break;
                    }
                }
                
            }
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
		
	}

