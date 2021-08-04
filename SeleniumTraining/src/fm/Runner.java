package fm;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Excel e = new Excel("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xls");
		System.out.println(e.readData("Sheet1", 1, 1));
		System.out.println(e.getLastRowNum("Sheet1"));
	}

}
