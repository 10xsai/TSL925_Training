package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	private static Map<String, String> getCredentials() throws FileNotFoundException, IOException {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\gdsvs\\OneDrive\\Documents\\Book1.xlsx"));
		XSSFSheet sh = wb.getSheet("Sheet1");
		Map<String, String>  credentials = new TreeMap<String, String>();
		
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			String username = row.getCell(0).toString();
			String password = row.getCell(1).toString();
			credentials.put(username, password);
		}
		return credentials;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = null;
		String URL = "https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		
		Map<String, String> credentials = getCredentials();
		Set<String> kset = credentials.keySet();

		for (String username: kset) {
			String password = credentials.get(username);
			driver = new ChromeDriver();
			driver.get(URL);
			
			WebElement usernameElement = driver.findElement(By.id("txtUsername"));
			WebElement passwordElement = driver.findElement(By.id("txtPassword"));
			WebElement submitElement = driver.findElement(By.cssSelector("input[value='LOGIN']"));
			
			usernameElement.clear();
			usernameElement.sendKeys(username);
			passwordElement.clear();
			passwordElement.sendKeys(password);
			submitElement.click();
			try {
				driver.findElement(By.id("txtPassword"));
			}
			catch (Exception e) {
				System.out.println("logged in with " + username + " " + password);				
			}
			finally {
				driver.close();				
			}
			
		}
		
	}

}
