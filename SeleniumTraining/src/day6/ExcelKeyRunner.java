package day6;

import org.testng.annotations.Test;

import day4.Base;
import fm.Excel;
import fm.KeyWords;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;

public class ExcelKeyRunner extends Base {

  @Test(dataProvider = "dp")
  public void runKeyTest(String action, String locatorType, String locatorValue, String data) {
	  KeyWords kw = new KeyWords(driver);
	  switch(action) {
	  	case "getURL":
	  		kw.getURL(data);
	  		break;
	  	case "click":
	  		kw.click(locatorType, locatorValue);
	  		break;
	  	case "type":
	  		kw.type(locatorType, locatorValue, data);
	  		break;
	  	case "selectFromDropDown":
	  		kw.selectFromDropDown(locatorType, locatorValue, data);
	  		break;
	  	case "getSnap":
	  		kw.getSnap(data);
	  		break;
	  	default:
	  		System.out.println("Invalid action");
	  		break;
	  }
  }

  @DataProvider
  public Object[][] dp() throws FileNotFoundException, IOException {
	  	Excel ex = new Excel("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xls");
	  	Object data[][] = new Object[6][4];
	  	for (int i = 1; i <= 6; i++) {
	  		data[i-1][0] = ex.readData("Sheet5", i, 0);
	  		data[i-1][1] = ex.readData("Sheet5", i, 1);
	  		data[i-1][2] = ex.readData("Sheet5", i, 2);
	  		data[i-1][3] = ex.readData("Sheet5", i, 3);
	  	}
	  	return data;
  }
  
}
