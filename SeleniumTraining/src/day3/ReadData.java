package day3;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadData {
	
	public static void main(String[] args) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xls"));		
		HSSFSheet sh = wb.getSheet("Sheet1");
		for (int i = 0; i <= sh.getLastRowNum() ; i++) {
			String pwd = sh.getRow(i).getCell(1).toString();
			System.out.println(pwd);
		}
		
	}
	
}
