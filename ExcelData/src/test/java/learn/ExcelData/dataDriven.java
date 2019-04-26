package learn.ExcelData;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fs = new FileInputStream("F:\\SELENIUM_NEW\\book.xlsx");
		XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
		
		int sheets = workbook1.getNumCellStyles();
		for(int i=0;i<sheets;i++) {
			
			if(workbook1.getSheetName(i).equalsIgnoreCase("testdata")) 
			{
			XSSFSheet sheet = workbook1.getSheetAt(i);
			Iterator<Row> row = sheet.iterator();
			Row firstrow = row.next();
			Iterator<Cell> cell = firstrow.cellIterator();
			int k=0;
			int column = 0;
			while(cell.hasNext()) 
			{
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases")) 
				{
					column=k;
				}
				k++;
			}
			System.out.println(column);
			
			}
		}
	}

}
