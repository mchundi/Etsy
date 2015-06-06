package TestCase;
import UIMap.HomePage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

class OrderJewellery{
	
	public static void main(String args[]){
		
		System.out.println("in OrderJewellery Main");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.etsy.com/");
		
		System.out.println("calling homepage");
		new HomePage().isLogoPresent(driver);
		System.out.println("enter search criteria");
		new HomePage().searchBox("jewellery",driver);
		
		
		driver.close();
	}
}