package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	static WebDriver driver;
	
	public static WebDriver driverInitializer( String url)
	
	{
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get(url);
		driver.manage().window().maximize();
		 return driver;
	}

}
