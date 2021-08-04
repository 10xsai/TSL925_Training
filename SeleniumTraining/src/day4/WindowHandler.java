package day4;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://naukri.com";
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		String pid = driver.getWindowHandle();
		
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			System.out.println(id);
			
			if (!id.equals(pid)) {
				driver.switchTo().window(id);
				driver.close();
				Thread.sleep(1000);
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
