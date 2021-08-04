package day6;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import day4.Base;

public class imageChecking extends Base {
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
