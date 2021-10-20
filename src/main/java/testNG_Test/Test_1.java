package testNG_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_1 {

	WebDriver driver;

	// Validate a user is able to add a category and once the category is added it
	// should display.

	@BeforeMethod
	public void init() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(" http://techfios.com/test/101/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void addCategory() {
		driver.findElement(By.name("categorydata")).sendKeys("21489235886");
		driver.findElement(By.xpath("//input[@value='Add category']")).click();
	}

}
