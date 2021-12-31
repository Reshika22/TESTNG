package week5.day1;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./Excel/data.xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int lastRowNum = ws.getLastRowNum();
		int numberOfRows = ws.getPhysicalNumberOfRows();
		short lastCellNum = ws.getRow(0).getLastCellNum();
		int numberOfCells = ws.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i < numberOfRows; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				
				XSSFRow row = ws.getRow(i);
				XSSFCell cell = row.getCell(j);
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);
			}
			
		}
		System.out.println("Last Row Number: " + lastRowNum);
		System.out.println("Number of Rows: " + numberOfRows);
		System.out.println("Last Column Number: "+lastCellNum);
		System.out.println("Number of Columns: "+numberOfCells);
		wb.close();

	}

}
