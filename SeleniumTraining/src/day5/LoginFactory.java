package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginFactory {
	 @FindBy(name="txtUsername") WebElement e_un;
	 @FindBy(name="txtPassword") WebElement e_pwd;
	 @FindBy(id="btnLogin") WebElement e_login;
	 @FindBy(linkText="Forgot your password?") WebElement e_forget;
	  
	private void setUsername(String name) {
		e_un.sendKeys(name);
	}
	
	private void setPwd(String pwd) {
		e_pwd.sendKeys(pwd);
	}
	
	public void clicklogin() {
		e_login.click();
	}
	
	public void clickForget() {
		e_forget.click();
	}
	
	public void doLogin(String name, String pwd) {
		setUsername(name);
		setPwd(pwd);
		clicklogin();
	}
	
}
