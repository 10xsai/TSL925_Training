package day6;

import org.testng.annotations.Test;

import day4.Base;
import fm.KeyWords;

public class KeyRunner extends Base {
	@Test
	public void runKeyTest() {
		KeyWords key = new KeyWords(driver);
		key.getURL("https://blazedemo.com/");
		key.selectFromDropDown("name", "fromPort", "San Diego");
		key.selectFromDropDown("name", "toPort", "Cairo");
		key.click("css", "input[value='Find Flights']");
		key.click("css", "input[value='Choose This Flight']");
		key.type("name", "inputName", "Sai Krishna");
		key.type("name", "inputAddress", "123 Street");
	}
}
