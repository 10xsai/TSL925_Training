package day6;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import day4.Base;

public class Headless {
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("--headless")); 
//		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\geckodriver.exe");
//		driver = new ChromeDriver(new Options().addArguments("--headless")); 
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test
	public void linkTest() throws Exception  {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		for (WebElement e:elements) {
			String link = e.getAttribute("src");
			System.out.println(link);
			URL url = new URL(link);
			URLConnection con = url.openConnection();
			HttpURLConnection hCon = (HttpURLConnection)con;
			hCon.connect();
			
			if (hCon.getResponseCode()==200)
				System.out.println("Success");
			else
				System.out.println("Failed with code " + hCon.getResponseCode());
		}
		
		
	}
}
