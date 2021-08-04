package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FactoryRunnerWithCrossBrowser {
  public WebDriver driver;
  @Test(description = "Checking forget link")
  public void forgotTest() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  LoginFactory lf = PageFactory.initElements(driver, LoginFactory.class);
	  lf.clickForget();
	  Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	  
  }
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  if (browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		  driver = new ChromeDriver(); 
	  }
	  else if (browser.equals("firefox")) {
		  System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\geckodriver.exe");
		  driver = new FirefoxDriver();   
	  }
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
