package day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wt = new WebDriverWait(driver, 20);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https:www.facebook.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='-1']")));
		
//		driver.findElement(By.cssSelector("input[value='-1']")).click();
		
//		List<WebElement> ls = driver.findElements(By.name("sex"));
//		for (int i = 0; i < ls.size(); i++) {
//			ls.get(i).click();
//			Thread.sleep(1500);
//		}
		List<WebElement> ls = driver.findElements(By.tagName("a"));
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getAttribute("href"));
		}

		driver.quit();
	}
}
