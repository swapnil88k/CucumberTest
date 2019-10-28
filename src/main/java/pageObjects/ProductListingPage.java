package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class ProductListingPage {
 
 public ProductListingPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(css = "button.single_add_to_cart_button") 
 private WebElement btn_AddToCart;
 
 @FindAll(@FindBy(css = ".noo-product-inner"))
 private List<WebElement> prd_List; 
 
 @FindBy(id = "pa_color") 
 private WebElement textColor;
 
 @FindBy(id = "pa_size") 
 private WebElement textSize;
 
 
 public void clickOn_AddToCart() {
	 
	 
		Select select=new Select(textColor);
		select.selectByValue("white");
		
		Select select1=new Select(textSize);
		select1.selectByValue("small");
	 
		btn_AddToCart.click();
 }
 
 public void select_Product(int productNumber) {
 prd_List.get(productNumber).click();
 }
 
}