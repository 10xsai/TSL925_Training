package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.magneticautomation.in/p/dropdown.html");
		Select fromPort = new Select(driver.findElement(By.name("multi")));
		
		System.out.println("Multi Select is " + fromPort.isMultiple());
		
		fromPort.selectByVisibleText("One");
		Thread.sleep(2000);
		fromPort.selectByValue("4");
		Thread.sleep(2000);
		fromPort.deselectByVisibleText("Three");
		Thread.sleep(2000);
		fromPort.deselectAll();
	}
}
