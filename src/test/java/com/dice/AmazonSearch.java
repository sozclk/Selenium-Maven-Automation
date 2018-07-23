package com.dice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AmazonSearch {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Desktop\\selenium_dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void before() {
		driver.get("http://amazon.com");
	}
}
