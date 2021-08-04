package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class orangeSteps {
	WebDriver driver;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	
	@After
	public void after() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Given("Browser is Opened with Login Page")
	public void browser_is_opened_with_login_page() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	@When("user enters {string}, {string} & click on login button")
	public void user_enters_click_on_login_button(String user, String pwd) {
		System.out.println(user + " " + pwd);
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();		
	}
	
	@Then("Login {string} be happen")
	public void login_should_happen(String expectedTitle) {
		System.out.println(driver.getCurrentUrl());
	}
}
