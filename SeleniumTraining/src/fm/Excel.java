package fm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	Workbook wb;
	
	public Excel(String pathWithFileName) throws FileNotFoundException, IOException {
		try {
			if (pathWithFileName.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(pathWithFileName));			
			}
			else if (pathWithFileName.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(pathWithFileName));
			}			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String readData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).toString();
	}
	
	public int getLastRowNum(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
}
