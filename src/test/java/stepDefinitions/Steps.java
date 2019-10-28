package stepDefinitions;

 
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import managers.WebDriverManager;


public class Steps {

	 WebDriver driver;
	 
	 HomePage homePage;
	 ProductListingPage productListingPage;
	 CartPage cartPage;
	 CheckoutPage checkoutPage;
	 PageObjectManager pageObjectManager;
	 ConfigFileReader configFileReader;
	 WebDriverManager webDriverManager;
	 
	 @Given("^user is on Home Page$")
	 public void user_is_on_Home_Page(){
		 
		 	configFileReader= new ConfigFileReader(); /*
		 	System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
		 	System.setProperty("webdriver.firefox.bin",configFileReader.getFirefoxDriverPath());
			//String Firefoxdriverpath = "C:\\Users\\228489\\Documents\\technology\\Java-Handson\\Selenium1\\geckodriver.exe";
			*/
		 	 
		 	webDriverManager = new WebDriverManager();
		 	 driver = webDriverManager.getDriver();
			pageObjectManager = new PageObjectManager(driver);
			 homePage = pageObjectManager.getHomePage();
			 homePage.navigateTo_HomePage(); 
	 
	 }
	 
	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
		
		 homePage.perform_Search(product);
	 }
	 
	 @When("^choose to buy the first item$")
	 public void choose_to_buy_the_first_item() {
		 productListingPage = pageObjectManager.getProductListingPage();
		 productListingPage.select_Product(0);
		 productListingPage.clickOn_AddToCart();
	 }
	 
	 @When("^moves to checkout from mini cart$")
	 public void moves_to_checkout_from_mini_cart() throws InterruptedException{
		 cartPage = pageObjectManager.getCartPage();
		 cartPage.clickOn_Cart();
		 cartPage.clickOn_ContinueToCheckout(); 
	 }
	 
	 @When("^enter personal details on checkout page$")
	 public void enter_personal_details_on_checkout_page() throws InterruptedException {
		 checkoutPage = pageObjectManager.getCheckoutPage();
		 Thread.sleep(2000);
		 checkoutPage.fill_PersonalDetails(); 
		 Thread.sleep(2000);
	 } 
	 
	 @When("^place the order$")
	 public void place_the_order() throws InterruptedException {
		 	
		 	checkoutPage.check_TermsAndCondition();
		 	checkoutPage.clickOn_PlaceOrder();
		 	Thread.sleep(2000);
		 	
		 	webDriverManager.closeDriver();
	 } 
	
	 
	
	
}
