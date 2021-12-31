package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcelRead {

	public static String[][] readData(String fileName) throws IOException{
		XSSFWorkbook wb = new XSSFWorkbook("./Excel/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int numberOfRows = ws.getPhysicalNumberOfRows();
		short lastCellNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[numberOfRows-1][lastCellNum];
		for (int i = 1; i < numberOfRows; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				
				XSSFRow row = ws.getRow(i);
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				
			}
			
		}
		
		System.out.println("Number of Rows: " + numberOfRows);
		System.out.println("Last Column Number: "+lastCellNum);
		wb.close();
		System.out.println("data size: " + data.length + "," + data[0].length);
		return data;
	}

}
