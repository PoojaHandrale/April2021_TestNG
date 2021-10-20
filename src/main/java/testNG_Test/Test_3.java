package testNG_Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_3 {
	WebDriver driver;

//Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@Test
	public void dropDown() {

		WebElement dropDown = driver.findElement(By.name("due_month"));
		Select select = new Select(dropDown);
		List<WebElement> options = select.getOptions();
		ArrayList<String> months = new ArrayList<String>();
		for (WebElement we : options)
			months.add(we.getText());
		System.out.println("Current list of months: " + months);
	}
}
