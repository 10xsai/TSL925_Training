package day1;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//WebDriver is an interface
		//ChromeDriver, FirefoxDriver, OperaDriver implements WebDriver Interface
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice ");
		System.out.println("Enter 1 for chrome");
		System.out.println("Enter 2 for firefox");
		
		int choice = sc.nextInt();
		if(choice == 1)
		{
			System.setProperty("webdriver.chrome.driver", 
					"D:\\win\\Downloads\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			openBrowser(driver);
		}
		else if(choice == 2)
		{
			System.setProperty("webdriver.gecko.driver", 
					"D:\\win\\Downloads\\geckodriver.exe");
			FirefoxDriver driver = new FirefoxDriver();
			openBrowser(driver);
		}
		else
			System.out.println("wrong choice!");
		
		sc.close();
	}
	
	private static void openBrowser(WebDriver driver) throws Exception {
		
		driver.get("https://www.selenium.dev/");
		System.out.println("Title is: " + driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

}