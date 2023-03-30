package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class LoginTest {

	
	@Test
	public void loginTest() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stg1-console.reekoh.io/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);
		home.doLogin("cris.dapitanon@reekoh.com", "Cris1988$");
		
	}
	
	
	
	
	
	
	
}
