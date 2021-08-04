package day6;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

public class ReadingCSV {
	@Test
	public void f() throws Exception {
        CSVReader cs = new CSVReader(new FileReader("C:\\Users\\gdsvs\\OneDrive\\Documents\\data.csv"));

 

        List<String[]> allData = cs.readAll();

 

        System.out.println(allData.get(0)[0]);
        System.out.println(allData.get(0)[1]);

 

        for (int i = 0; i < allData.size(); i++) {
            String[] row=allData.get(i); // getting row
            
            System.out.println(row[0]);   // userName
            System.out.println(row[1]);   //password
        }
    }
}
