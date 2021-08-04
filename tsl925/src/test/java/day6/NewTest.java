package day6;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  public WebDriver driver;
	
  @Test
  public void f() throws Exception {
	  ExtentReports ex = new ExtentReports(); // To specify we are working with extent reports
	  ex.attachReporter(new ExtentHtmlReporter("google.html")); // We specified we need html report with name
	  
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/test/resources/settings.property"));
	  
	  ExtentTest tc = ex.createTest("GoogleTest");
	  
	  System.out.println(prop.getProperty("searchField"));
	  tc.info("Opening URL");
	  driver.get(prop.getProperty("url"));
	  tc.info("Typing text");
	  driver.findElement(By.name(prop.getProperty("searchField"))).sendKeys("LTI");
	  Assert.assertEquals(driver.getTitle(), "Google");
	  Thread.sleep(2000);
	  tc.pass("Test Case Pass");
	  ex.flush();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver(); 
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
