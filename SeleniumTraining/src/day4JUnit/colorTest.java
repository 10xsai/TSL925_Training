package day4JUnit;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class colorTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://blazedemo.com");
		WebElement E = driver.findElement(By.cssSelector("input[value='Find Flights']"));
		String bg = E.getCssValue("background-color");
		System.out.println(bg);
		
		String hexColor = Color.fromString(bg).asHex();
		System.out.println(hexColor);
		assertEquals("#006dcc", hexColor);
	}

}
