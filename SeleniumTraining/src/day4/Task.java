package day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task extends Base {
	
	@Test
	public void searchTest() throws InterruptedException {
		driver.get("https://rediff.com");
		driver.switchTo().frame("moneyiframe");
		driver.findElement(By.id("query")).sendKeys("YES bank");
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(2));
		Thread.sleep(2000);
		Set<String> win = driver.getWindowHandles();
		List<String> allWin = new ArrayList<>(win);
		driver.switchTo().window(allWin.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		Thread.sleep(2000);
		
//		String pid = driver.getWindowHandle();
//		Set<String> ids = driver.getWindowHandles();
//		for (String id : ids) {
//			if (!id.equals(pid)) {
//				driver.switchTo().window(id);
//				System.out.println(driver.getTitle());
//			}
//		}
//		driver.switchTo().window(pid);
//		driver.close();
	}

}
