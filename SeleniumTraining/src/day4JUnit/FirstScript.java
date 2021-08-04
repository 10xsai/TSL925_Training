package day4JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
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
	public void test() throws InterruptedException {
		driver.get("http://selenium.dev");
		WebElement E = driver.findElement(By.linkText("Sri Harsha"));
		System.out.println(E.getAttribute("href"));
		assertEquals("https://twitter.com/sri_harsha509", E.getAttribute("href"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", E);
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
	}
}
