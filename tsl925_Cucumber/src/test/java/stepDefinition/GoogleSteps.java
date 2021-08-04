package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class GoogleSteps {
	WebDriver driver;
	
	@Given("Browser is opened")
	public void browser_is_opened() {
		System.setProperty("webdriver.chrome.driver", "D:\\win\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	
	
	@When("User navigates to url as {string}")
	public void user_navigates_to(String url) {
		driver.get(url);
	}
	
	
	@Then("title should be as {string}")
	public void title_should_be(String expectedTitle) {
		String currentTitle = driver.getTitle();
		assertEquals(expectedTitle, currentTitle);
	}
}
