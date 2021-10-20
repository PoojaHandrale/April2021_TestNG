package testNG_Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_2 {
	//Validate a user is not able to add a duplicated category. 
	//If it does then the following message will display: 
	//"The category you want to add already exists: <duplicated category name>."
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void addNoDuplicateCategory() {
			
		WebElement catData= driver.findElement(By.tagName("body"));
		String catExists = catData.getText();
		String catNew = "autoTest267";
		
		if(catExists.contains(catNew)) {
			driver.findElement(By.name("categorydata")).sendKeys(catNew);
			System.out.println("The category you want to add already exists: <duplicated category name>.");
		}else {
			
			driver.findElement(By.name("categorydata")).sendKeys(catNew);
			driver.findElement(By.xpath("//input[@value='Add category']")).click();
			System.out.println("New category added to the list.");
		}
		
		}
	@AfterMethod
	public void tearDown() {
		driver.close();// it will close last or recently used window that was open
		driver.quit();//it will kill the driver and close all the windows
	
	}

	
		
	}

