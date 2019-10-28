package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
 
public class HomePage {
 WebDriver driver;
 ConfigFileReader configFileReader;
 
 public HomePage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 configFileReader= new ConfigFileReader();
 }
 
 public void perform_Search(String search) {
	 String url=FileReaderManager.getInstance().getConfigReader().getApplicationUrl()+"/?s=";
 driver.navigate().to(url + search + "&post_type=product");
 }
 
 public void navigateTo_HomePage() {
	 
	 String url1=FileReaderManager.getInstance().getConfigReader().getApplicationUrl().toString();
	 String url=url1;
	 driver.get(url);
 }
 
}
