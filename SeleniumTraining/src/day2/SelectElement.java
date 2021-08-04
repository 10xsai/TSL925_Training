package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		WebElement E = driver.findElement(By.name("fromPort"));
		Select fromPort = new Select(E);
		
		fromPort.selectByVisibleText("Portland");
		Thread.sleep(2000);
		fromPort.selectByIndex(6);
		Thread.sleep(2000);
		fromPort.selectByValue("Boston");
		
		System.out.println("Multi Select is " + fromPort.isMultiple());
	}
}
