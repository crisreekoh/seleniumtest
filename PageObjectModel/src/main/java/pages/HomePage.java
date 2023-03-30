package pages;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	/*
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(xpath="//button[normalize-space()=\'Log In\']")
	public WebElement loginBtn;
	*/
	

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public void doLogin(String emailadd, String password) {
		
		/*
		email.sendKeys(emailadd);
		pass.sendKeys(password);
		loginBtn.click();
		*/
		
		// Login Page
		driver.findElement(By.id("username")).sendKeys(emailadd);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[class=\'btn btn-md btn-primary btn-block\']")).click();
		
		// Navigate Pipeline Studio
		driver.findElement(By.cssSelector(".fal.fa-fw.ion-grid.pull-left.nav-icon.m-n")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Pipeline Studio\")]")).click();
		driver.findElement(By.cssSelector("a[class=\"thumbnail\"] div[class=\"caption\"]")).click();
		
		// Pin Plugin
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()=\\\"Pin New Gateway Plugin\\\"]")));
		driver.findElement(By.xpath("//a[normalize-space()=\"Pin New Gateway Plugin\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Search...\"]")).sendKeys("Http Gateway", Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title=\"HTTP Gateway\"] span[class=\"card-label\"]")));
		// Select Plugin
		driver.findElement(By.cssSelector("body > rp-root:nth-child(1) > main:nth-child(1) > rp-pipeline:nth-child(3) > rp-pipeline-edit:nth-child(2) > rp-modal:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(3)")).click();
		
		// Close Modal Page
		driver.findElement(By.cssSelector("rp-modal[class=\"modal fade in\"] i[class=\"fal fa-times\"]")).click();
		
		//Actions class method to drag and drop 
		Actions builder = new Actions(driver);
		WebElement from = driver.findElement(By.cssSelector("div[name=\"HTTP Gateway\"]"));
		WebElement to = driver.findElement(By.cssSelector(".workspace-overlay-new.ng-star-inserted")); 
		//Perform drag and drop
		builder.dragAndDrop(from, to).perform();
		
		//Double click on element
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='image'])[1]")));
		
		/* Actions act = new Actions(driver);
		 WebElement ele = driver.findElement(By.xpath("(//*[name()='image'])[1]"));
		driver.findElement(By.xpath("(//*[name()='image'])[1]")).sendKeys(Keys.ENTER);
		act.doubleClick(ele).perform(); */
		
		// Working but page did not show
		/* WebElement element = driver.findElement(By.xpath("(//*[name()='image'])[1]"));          
		Actions builder1 = new Actions(driver);
		//driver.findElement(By.xpath("(//*[name()='image'])[1]")).sendKeys(Keys.ENTER);
		builder1.moveToElement(element).sendKeys(Keys.ENTER).doubleClick(element).perform(); */
		
		
		/* Actions a = new Actions(driver);
	      a.moveToElement(driver.findElement(By.xpath("(//*[name()='image'])[1]"))).
	      click().
	      sendKeys(Keys.ENTER).
	      doubleClick().
	      perform(); */
		
		 /* WebElement clickable = driver.findElement(By.xpath("(//*[name()='image'])[1]"));
	        new Actions(driver)
	                .doubleClick(clickable)
	                .perform();*/
	      
	      
	      /*JavascriptExecutor executor = (JavascriptExecutor) driver;
	      WebElement element = driver.findElement(By.xpath("(//*[name()='image'])[1]"));
	      executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);*/
		
	      
		WebElement plugin = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='image'])[1]")));
		//driver.findElement(By.xpath("(//*[name()='image'])[1]")).sendKeys(Keys.ENTER);
		new Actions(driver).moveToElement(plugin).doubleClick(plugin).perform();
	      
	      
		/*
		Actions action = new Actions(driver); 
	    action.moveToElement(driver.findElement(By.cssSelector("g[style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\"]"))).doubleClick().build().perform();
	    //action.moveToElement(driver.findElement(By.cssSelector("g[style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\"]"))).doubleClick().build().perform();
		*/
		
		/* // Unpin Plugin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[title=\\\"Unpin this plugin\\\"]")));
		driver.findElement(By.cssSelector("i[title=\"Unpin this plugin\"]")).click();
		*/
		
	}
	

}
