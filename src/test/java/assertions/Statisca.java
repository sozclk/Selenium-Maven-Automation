package assertions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Statisca {
	WebDriver driver;
	
	
	//comment
	//comment
	//comment
	
	
	
	@BeforeClass
	public void setup () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test 
	public void navigator () throws InterruptedException {
		driver.get("https://www.statista.com");
		List<WebElement> navigators = driver.findElements(By.xpath("//div[@id='navigation']/nav/ul/li"));
		
		Actions action = new Actions(driver);
		
		for (int i = 0; i < navigators.size()-2; i++) {
			action.moveToElement(navigators.get(i)).perform();
			Thread.sleep(2000);
		}
		
	}

}
