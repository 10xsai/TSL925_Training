package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Writing {
	
	public static void main(String[] args) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xls"));		
		HSSFSheet sh = wb.getSheet("Sheet1");
		sh.getRow(0).getCell(0).setCellValue("lti");
		sh.getRow(0).createCell(0).setCellValue("lti");
		sh.getRow(4).createCell(2).setCellValue("lti");
		wb.write(new FileOutputStream("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book2.xls"))
	}
	
}
