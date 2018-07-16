package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	
	public static void main(String[] args) {
		
		//Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		//Invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullscreen
		driver.manage().window().maximize();
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch browser and navigate to https://dice.com
		//Expected : dice home page should be displayed
		String url = "https://dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		String exceptedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if (actualTitle.equals(exceptedTitle)) {
			System.out.println("STEP PASSED. Dice homepage successfully loaded");
		} else {
			System.out.println("STEP FAILED. Dice homepage did not load successfully");
			throw new RuntimeException("STEP FAILED. Dice homepage did not load successfully");
		}
		
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location = "22102";
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		int countResult = Integer.parseInt(count.replace(",", ""));
		
		if(countResult > 0) {
			System.out.println("STEP PASSED: Keyword : " + keyword + " search results " + countResult + " results in " + location);
		} else {
			System.out.println("STEP FAILED: Keyword : " + keyword + " search results " + countResult + " results in " + location);
		}
		
		driver.close();
	}

}
