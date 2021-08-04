package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookTicket {

	public static void main(String[] args) throws InterruptedException {
		String URL = "https://blazedemo.com/";
		WebElement E;

		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		E = driver.findElement(By.name("fromPort"));
		Select fromPort = new Select(E);
		fromPort.selectByValue("San Diego");
		
		E = driver.findElement(By.name("toPort"));
		Select toPort = new Select(E);
		toPort.selectByValue("Cairo");
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();

		// Selects Flight
		driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		
		// Enters Address
		driver.findElement(By.cssSelector("input[name='inputName']")).clear();
		driver.findElement(By.cssSelector("input[name='inputName']")).sendKeys("Sai Krishna");;
		driver.findElement(By.cssSelector("input[name='address']")).clear();
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("123 Main st");
		driver.findElement(By.cssSelector("input[name='city']")).clear();
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Los Angeles");
		driver.findElement(By.cssSelector("input[name='state']")).clear();
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("California");
		driver.findElement(By.cssSelector("input[name='zipCode']")).clear();
		driver.findElement(By.cssSelector("input[name='zipCode']")).sendKeys("90001");
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("03");
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).clear();
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2021");
		driver.findElement(By.cssSelector("input[name='nameOnCard']")).clear();
		driver.findElement(By.cssSelector("input[name='nameOnCard']")).sendKeys("G Sai Krishna");
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
	

}
