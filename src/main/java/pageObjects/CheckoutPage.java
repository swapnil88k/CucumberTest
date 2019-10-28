package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	 public CheckoutPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(css="#billing_first_name") 
	 WebElement textFirstName;
	 
	 @FindBy(css="#billing_last_name") 
	 WebElement textLastName;
	 
	 @FindBy(css="#billing_email") 
	 WebElement textEmailAddress;
	 
	 @FindBy(css="#billing_phone") 
	 WebElement textPhone;
	 
	 @FindBy(id="select2-billing_country-container") 
	 WebElement textCountry;
	 
	 @FindBy(xpath="/html/body/span/span/span[1]/input") 
	 WebElement textCountrytext;
	 
	 @FindBy(id="select2-billing_state-container") 
	 WebElement textState;
	 
	 @FindBy(xpath="/html/body/span/span/span[1]/input") 
	 WebElement textStatetext;
	 
	 @FindBy(id="billing_city") 
	 WebElement textCity;
	 
	 @FindBy(id="billing_address_1") 
	 WebElement textAddress;
	 
	 @FindBy(id="billing_postcode") 
	 WebElement textPostCode;
	 
	 @FindBy(id="terms") 
	 WebElement textTerms;
	 
	 @FindBy(css="#place_order") 
	 WebElement textPlaceOrder;
	 
	 public void enter_Name(String name) {
		 textFirstName.sendKeys(name);
		 }
		 
		 public void enter_LastName(String textlastName) {
			 textLastName.sendKeys(textlastName);
		 }
		 
		 public void enter_Email(String email) {
			 textEmailAddress.sendKeys(email);
		 }
		 
		 public void enter_Phone(String phone) {
			 textPhone.sendKeys(phone);
		 }
		 
		 public void enter_City(String city) {
			 textCity.sendKeys(city);
		 }
		 
		 public void enter_Address(String address) {
			 textAddress.sendKeys(address);
		 }
		 
		 public void enter_PostCode(String postCode) {
			 	textPostCode.sendKeys(postCode);
		 }
		 
		 
		 public void select_Country(String countryName) {
			 	textCountry.click();
			 	textCountrytext.click();
			 	textCountrytext.sendKeys("India");

			 	textCountrytext.sendKeys(Keys.DOWN);
			 	textCountrytext.sendKeys(Keys.DOWN);
			 	textCountrytext.sendKeys(Keys.ENTER);
			 }
		 
		 public void select_State(String countyName) {
			 	textState.click();
			 	textStatetext.click();
			 	textStatetext.sendKeys("Delhi");
			 	textStatetext.sendKeys(Keys.DOWN);
			 	textStatetext.sendKeys(Keys.ENTER);
			 
			 }
		 
		 public void check_TermsAndCondition() {
			 textTerms.click();
			 
			 }
			 
			 public void clickOn_PlaceOrder() {
				 
				textPlaceOrder.submit();
			 }
	 
			 public void fill_PersonalDetails() throws InterruptedException {
				 enter_Name("Aotomation");
				 enter_LastName("Test");
				 enter_Phone("0000000000");
				 enter_Email("Automation@gmail.com");
				 select_Country("India");
				 enter_City("Delhi");
				 enter_Address("Shalimar Bagh");
				 enter_PostCode("110088");
				 select_State("Delhi");
				 
				 
				 }
	
}
