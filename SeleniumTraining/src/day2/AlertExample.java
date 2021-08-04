package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AlertExample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		
		Alert ac = driver.switchTo().alert();
		
		String txt = ac.getText();
		System.out.println(txt);
		
		ac.sendKeys("LTI");
		ac.dismiss();
	}
}
