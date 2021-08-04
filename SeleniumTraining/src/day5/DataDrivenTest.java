package day5;

import org.testng.annotations.Test;

import day4.Base;
import fm.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataDrivenTest extends Base {

  @Test(dataProvider = "dp")
  public void f(String username, String password) {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys(username);;
	  driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys(password);;
	  driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
	  driver.findElement(By.id("welcome")).click();
	  WebDriverWait wt = new WebDriverWait(driver, 20);
	  wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
	  driver.findElement(By.linkText("Logout")).click();
  }

  @DataProvider
  public Object[][] dp() throws FileNotFoundException, IOException {
	  	Excel ex = new Excel("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xls");
	  	Object data[][] = new Object[ex.getLastRowNum("Sheet1")+1][2];
	  	for (int i = 0; i <= ex.getLastRowNum("Sheet1"); i++) {
	  		data[i][0] = ex.readData("Sheet1", i, 0);
	  		data[i][1] = ex.readData("Sheet1", i, 1);
	  		
	  	}
	  	return data;
  }
  
}
