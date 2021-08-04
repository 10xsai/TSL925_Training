package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkExtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wt = new WebDriverWait(driver, 20);
		driver.get("https:www.facebook.com");
		
		List<WebElement> ls = driver.findElements(By.tagName("img"));
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getAttribute("src"));
		}

		driver.quit();
	}

}
