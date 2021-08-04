package day6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import day4.Base;

public class ActionsExample extends Base {
	@Test
	public void bingTest() throws Exception {
		Actions ac = new Actions(driver);
		driver.get("http://bing.com");
		WebElement searchField = driver.findElement(By.id("sb_form_q"));
		Action a = ac.keyDown(Keys.SHIFT)
					 .sendKeys(searchField, "lti")
					 .keyUp(Keys.SHIFT)
					 .doubleClick(searchField)
					 .contextClick(searchField)
					 .build();
		a.perform();
		Thread.sleep(2000);
	}
}
