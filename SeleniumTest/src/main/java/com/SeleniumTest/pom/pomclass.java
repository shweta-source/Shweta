package com.SeleniumTest.pom;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class pomclass {
	
	WebDriver driver;
	@FindBy (xpath = "//*[@id='email']") 
	private WebElement username;
	
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") 
	private WebElement dresses;
	
	
			
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a") 
	private WebElement summerdresses;
	
	
	
	
	@FindBy (xpath = "//*[@class='login']") 
	private WebElement signinlink;
	
	
	@FindBy (xpath = "//*[@id='email']") 
	private WebElement emailaddress;
	
	@FindBy (xpath = "//*[@id='passwd']") 
	private WebElement pwd;
	
	
	@FindBy (xpath = "//*[@id='SubmitLogin']") 
	private WebElement signin;
	
	
	
	@FindBy (xpath = "//*[@class='icon-th-list']") 
	private WebElement listview;
	
	@FindBy (xpath  = "//*[@id=\"center_column\"]/ul/li[1]/div/div/div[2]/h5/a") 
	private WebElement quickview;
	
	@FindBy (xpath  = "//*[@class='btn btn-default btn-facebook']") 
	private WebElement sharefb;
	
	@FindBy (xpath  = "//*[@class='icon-plus']") 
	private WebElement addquantity;
	
	
	@FindBy (xpath  = "//*[@id='wishlist_button']") 
	private WebElement wishlistbtn;
	
	@FindBy (xpath  = "//*[@class='fancybox-item fancybox-close']") 
	private WebElement close_btn;
	
	
	@FindBy (xpath  = "//*[text()='Add to cart']") 
	private WebElement add_cart;
	
	@FindBy (xpath  = "//*[@title='View my shopping cart']") 
	private WebElement cart;
	
	
	@FindBy (xpath  = "//span[text()='$59.96']") 
	private WebElement totalprice;
	
	@FindBy (xpath  = "//*[text()='$28.98']") 
	private WebElement price;
	
	
	@FindBy (xpath  = "//*[@title='Proceed to checkout']") 
	private WebElement proceed_checkout;
	
	@FindBy (xpath  = "(//*[@title='Proceed to checkout'])[2]") 
	private WebElement proceed_checkout2;
	
	@FindBy (xpath  = "//*[@name='processAddress']") 
	private WebElement proceed_checkout3;
	
	@FindBy (xpath  = "//div[@id='uniform-cgv']") 
	private WebElement termscondcheck;
	
	
	@FindBy (xpath  = "//*[@class='button btn btn-default standard-checkout button-medium']") 
	private WebElement checkout4;
	
	@FindBy (xpath  = "//*[@class='bankwire']") 
	private WebElement bankwire;
	
	@FindBy (xpath  = "//*[@class='button btn btn-default button-medium']") 
	private WebElement iconfirm;
	
	
	
	
	
	String expectedcolor = "#5D9CEC";
	String expectedfburl = "facebook";
	String totallprice = "$59.96";
	
	
	public pomclass(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void testing() throws InterruptedException
	{
		
		signinlink.click();
		
		username.sendKeys("abc@gmail.com");
		pwd.sendKeys("123456");
		signin.click();
	}

	public void dresses() throws InterruptedException 
	{
		Thread.sleep(2000);
		Actions builder=new Actions(driver);
		builder.moveToElement(dresses).build().perform();
		
		Thread.sleep(1000);
		builder.moveToElement(summerdresses).build().perform();
		
		builder.moveToElement(summerdresses).click().perform();
		
		listview.click();
		
		Thread.sleep(1000);
		
		
		try {
			
			for(int i = 19; i<23; i++)
			{
			String actualvalue = driver.findElement(By.cssSelector("#color_"+i)).getCssValue("background-color");
			System.out.println(actualvalue);
			
			String hexcode = Color.fromString(actualvalue).asHex();
				
			if(hexcode.toUpperCase().equalsIgnoreCase(expectedcolor))
			{
				System.out.println("Blue has identified");
				break;
			
			}
			else
				System.out.println("Colour not identified");
		}}
		
		catch(Exception e)
		{
			System.out.println("exception arrived on colour and the message is: "+e);
		
		}
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(quickview));
		quickview.click();
		String parentwindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(sharefb));
		sharefb.click();
		
		Set<String> allwindow = driver.getWindowHandles();
		
		for(String fbwindow: allwindow )
		{
		if(!parentwindow.equalsIgnoreCase(fbwindow))
		{
			driver.switchTo().window(fbwindow);
			String fburl= driver.getCurrentUrl();
			System.out.println(fburl);
		Assert.assertTrue(fburl.contains(expectedfburl));
		driver.close();
		
		driver.switchTo().window(parentwindow);
		
		
		}
		}
		
		addquantity.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(add_cart));
		add_cart.click();
		wait.until(ExpectedConditions.elementToBeClickable(proceed_checkout));
		proceed_checkout.click();
		
		builder.moveToElement(cart).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(totalprice));
		String tprice = totalprice.getText();
		
		System.out.println("total price is : "+tprice);
		
		Assert.assertTrue(totallprice.equalsIgnoreCase(tprice));
		
		
		wait.until(ExpectedConditions.elementToBeClickable(proceed_checkout2));
		proceed_checkout2.click();

		wait.until(ExpectedConditions.elementToBeClickable(proceed_checkout3));
		proceed_checkout3.click();
			
		
		wait.until(ExpectedConditions.elementToBeClickable(termscondcheck));
		termscondcheck.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(checkout4));
		checkout4.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bankwire));
		bankwire.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(iconfirm));
		iconfirm.click();
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
		}
		
}
		
		
	
	
	
	
	


