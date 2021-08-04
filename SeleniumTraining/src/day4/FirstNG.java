package day4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstNG extends Base {
	
	@Test(priority = 1)
	public void titleTest() {
		driver.get("https://google.com");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Google");
	}
	
	@Test(priority = 2)
	public void searchTest() throws IOException {
		driver.findElement(By.name("q")).sendKeys("LTI");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("lti"));
	}
	
	// Executed before test
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	// Executed after every test
	@AfterMethod	// Using this method to take screenshot on failure
	public void afterMethod(ITestResult response) throws Exception {
		System.out.println("Bye");
		if (response.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot tc = (TakesScreenshot)driver;
			File from = tc.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(from, new File("failure.png"));
		}
		
	}
}
