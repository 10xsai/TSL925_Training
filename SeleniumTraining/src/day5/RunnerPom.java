package day5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import day4.Base;

public class RunnerPom extends Base {
	@Test
	public void forgetLinkTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage lp = new LoginPage(driver);
		lp.clickForget();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	}
	
	@Test(dependsOnMethods = "forgetLinkTest")
	public void cancelCheck() {
		ForgetPage fp = new ForgetPage(driver);
		fp.doCancel();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		Assert.assertEquals(driver.getCurrentUrl().contains("login"), true);
	}
	
	@Test(dependsOnMethods = "cancelCheck")
	public void mouseHover() {
		new LoginPage(driver).doLogin("admin", "admin123");
		WebElement perf = driver.findElement(By.linkText("Performance"));
		Actions ac = new Actions(driver);
		ac.moveToElement(perf).perform();
		ac.click(driver.findElement(By.linkText("Employee Trackers"))).perform();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeePerformanceTrackerList"));
	}
}
