package com.dice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

	WebDriver driver;

	@BeforeMethod
	public void bMethod() {
		driver.get("https://www.orangehrm.com");
	}

	@AfterMethod
	public void aMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Desktop\\selenium_dependencies\\drivers\\MicrosoftWebDriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void titleVerification() {
		System.out.println("Title :" + driver.getTitle());
		String expectedTitle = "OrangeHRM";

		Assert.assertEquals(driver.getTitle(), expectedTitle, "Orange title verification failed: " );
		System.out.println("Title verification is done here");
	}

	@Test
	public void loginTest() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("admin");
		loginBtn.click();

		String expectedUrl = "https://www.orangehrm.com/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "App login failed: ");

		Assert.assertTrue(expectedUrl.equals(driver.getCurrentUrl()));
	}

	@Test
	public void loginVerification() {
		System.out.println("Login verification here");
	}

	@AfterClass
	public void closing() {
		driver.quit();
	}
}
