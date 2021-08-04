package day5;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import day4.Base;

public class FactoryRunner extends Base {
  @Test(description = "Checking forget link")
  public void forgotTest() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  LoginFactory lf = PageFactory.initElements(driver, LoginFactory.class);
	  lf.clickForget();
	  Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	  
  }
}
