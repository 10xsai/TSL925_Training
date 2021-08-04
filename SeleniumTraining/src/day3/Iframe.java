package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/gdsvs/OneDrive/Documents/LTI%20Training/TSL/CoreJava/SeleniumTraining/demo.html");
		
		driver.switchTo().frame("front");
		driver.findElement(By.name("user_name_entry_field")).clear();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.name("q")).sendKeys("LTI");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.className("dummy")));
		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
		
		
		Thread.sleep(2000);
		driver.quit();
	}
}
