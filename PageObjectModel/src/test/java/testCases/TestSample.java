package testCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSample {
	
	@Test
	public void testsample() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://stg1-console.reekoh.io/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.id("username")).sendKeys("cris.dapitanon@reekoh.com");
	driver.findElement(By.id("password")).sendKeys("Cris1988$");
	driver.findElement(By.cssSelector("button[class=\'btn btn-md btn-primary btn-block\']")).click();

	Assert.assertEquals("Platform Console", driver.getTitle());
	
	// Assert element
	 WebElement textSlogan = driver.findElement(By.cssSelector(".rkh-slogan"));
	 Assert.assertEquals(true, textSlogan.isDisplayed());
	 
	  
	
	
	}
	
	

}

