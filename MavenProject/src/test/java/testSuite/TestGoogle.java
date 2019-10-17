package testSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGoogle {

	//public static void main(String[] args) throws Exception {
	//WebDriver driver = new ChromeDriver();
	
	
	@Test
	
	public void Test_Google() throws Exception {
		try {
			
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Page title is:" + pageTitle);
		Assert.assertEquals(pageTitle, "Google");
	
		//WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		WebElement searchField = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
		WebDriverWait wait = new WebDriverWait(driver, 4);	
		wait.until(ExpectedConditions.visibilityOfAllElements(searchField));
		searchField.clear();
		//Thread.sleep(1000);
		searchField.sendKeys("hello world");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}

