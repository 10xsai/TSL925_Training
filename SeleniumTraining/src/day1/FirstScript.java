package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", 
				"D:\\win\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev");
		
		driver.findElement(By.id("gsc-i-id1")).sendKeys("LTI");
		driver.findElement(By.linkText("Downloads")).click();
		
		System.out.println();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
