package seleniumTests;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class E2E_Test {
	private static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver","C:\\Users\\228489\\Documents\\technology\\Java-Handson\\Selenium1\\geckodriver.exe");
	/*
	File pathBinary = new File("C:\\Users\\228489\\Documents\\technology\\Java-Handson\\Selenium1\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
	DesiredCapabilities desired = DesiredCapabilities.firefox();
	FirefoxOptions options = new FirefoxOptions();
	desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
	WebDriver driver = new FirefoxDriver(options);
	*/
	System.setProperty("webdriver.firefox.bin", "C:\\Users\\228489\\Documents\\technology\\Java-Handson\\Selenium1\\Mozilla Firefox\\firefox.exe");
	String Firefoxdriverpath = "C:\\Users\\228489\\Documents\\technology\\Java-Handson\\Selenium1\\geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", Firefoxdriverpath);
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	driver = new FirefoxDriver(capabilities);
	
	
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://www.shop.demoqa.com");
	
	driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	
	
	List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
	items.get(0).click();
	WebElement element=driver.findElement(By.id("pa_color"));
	Select select=new Select(element);
	select.selectByValue("white");
	element=driver.findElement(By.id("pa_size"));
	Select select1=new Select(element);
	select1.selectByValue("small");
	
	WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
	addToCart.click(); 
	
	
	WebElement cart = driver.findElement(By.cssSelector(".cart-name-and-total"));
	cart.click();
	
	WebElement continueToCheckout = driver.findElement(By.cssSelector("a.checkout-button:nth-child(1)"));
	continueToCheckout.click(); 
	
	
		
	WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
	firstName.sendKeys("Lakshay");
	
	WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
	lastName.sendKeys("Sharma");
	
	WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
	emailAddress.sendKeys("test@gmail.com");
	
	WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
	phone.sendKeys("07438862327");
	
	
	WebElement country=driver.findElement(By.id("select2-billing_country-container"));
	country.click();
	WebElement countrytext=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
	countrytext.click();
	countrytext.sendKeys("India");

	countrytext.sendKeys(Keys.DOWN);
	countrytext.sendKeys(Keys.DOWN);
	countrytext.sendKeys(Keys.ENTER);
	
	WebElement state=driver.findElement(By.id("select2-billing_state-container"));
	state.click();
	WebElement statetext=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
	statetext.click();
	statetext.sendKeys("Delhi");

	statetext.sendKeys(Keys.DOWN);
	
	statetext.sendKeys(Keys.ENTER);
	
	
	
	
	
	WebElement city = driver.findElement(By.id("billing_city"));
	city.sendKeys("Delhi");
	
	WebElement address = driver.findElement(By.id("billing_address_1"));
	address.sendKeys("Shalimar Bagh");
	
	WebElement postcode = driver.findElement(By.id("billing_postcode"));
	postcode.sendKeys("110088"); 
	
	driver.findElement(By.id("terms")).click();
	
	WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
	placeOrder.submit();
	
	driver.close();

}

}