package SeleniumTest.SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.SeleniumTest.pom.pomclass;

import Utility.DriverFactory;

public class NeoTest {


	@Test
	public  void autoTest() throws InterruptedException
	{
		WebDriver driver = DriverFactory.driverInitializer("http://automationpractice.com/index.php");
		
		pomclass pc= PageFactory.initElements(driver, pomclass.class);
		
		pc.testing();
		pc.dresses();
		
	}
	
	
}
