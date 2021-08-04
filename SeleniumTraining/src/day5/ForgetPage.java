package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage {
	WebDriver driver;
	
	By e_un = By.name("securityAuthentication[userName]");
	By e_reset = By.id("btnSearchValues");
	By e_cancel = By.id("btnCancel");
	
	public ForgetPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private void doReset(String name) {
		driver.findElement(e_un).sendKeys(name);
		driver.findElement(e_reset).click();
	}
	
	public void doCancel() {
		driver.findElement(e_cancel).click();
	}
}
