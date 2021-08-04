package fm;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWords {
	WebDriver driver;
	
	public KeyWords(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public By getLocator(String locatorType, String locatorValue) {
		By e = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			e = By.id(locatorValue);
			break;
		case "name":
			e = By.name(locatorValue);
			break;
		case "link":
			e = By.linkText(locatorValue);
			break;
		case "xpath":
			e = By.xpath(locatorValue);
			break;
		case "css":
			e = By.cssSelector(locatorValue);
			break;
		default:
			System.out.println("Invalid Locator Type ");
			break;
		}
		return e;
	}
	
	public WebElement getWebElement(String locatorType, String locatorValue) {
		return driver.findElement(getLocator(locatorType, locatorValue));
	}
	
	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public void type(String locatorType, String locatorValue, String data) {
		getWebElement(locatorType, locatorValue).sendKeys(data);
	}
	
	public void selectFromDropDown(String locatorType, String locatorValue, String option) {
		new Select(getWebElement(locatorType, locatorValue)).selectByVisibleText(option);
	}
	
	public void getSnap(String path) {
		TakesScreenshot tc = (TakesScreenshot)driver;
		File from = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(from, new File(path + ".png"));			
		}
		catch (Exception e) {
			System.out.println("Something went wrong" + e.getMessage());
		}
	}
}
