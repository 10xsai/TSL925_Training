package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "http://demo.frontaccounting.eu/";
		String username = "demouser";
		String password = "password";
		System.setProperty("webdriver.chrome.driver", 
				"D:\\win\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("user_name_entry_field")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("SubmitUser")).click();
		driver.findElement(By.linkText("  Logout")).click();
		System.out.println();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
