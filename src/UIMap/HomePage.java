package UIMap;

import java.util.List;

import org.openqa.selenium.*;

import helperFunctions.AssertActions;

public class HomePage{
	
	AssertActions aaObject = new AssertActions();
	
	public void isLogoPresent(WebDriver driver){
		System.out.println("in HomePage.isLogoPresent");
		WebElement etsyLogo = driver.findElement(By.xpath("//div[@id='etsy-logo']"));
		etsyLogo.isDisplayed();
		String logoLink = etsyLogo.getAttribute("style");
		System.out.println("LogoLink:"+logoLink);
	}
	
	public void searchBox(String searchStr, WebDriver driver){
		System.out.println("in HomePage.searchBox");
		
		WebElement searchBox = driver.findElement(By.id("search-query"));
		aaObject.assertElementDisplayed(searchBox);
		aaObject.assertAttributeValue(searchBox,"placeholder","Search for items or shops");
		
		searchBox.click();
		searchBox.sendKeys(searchStr.substring(0, searchStr.length()/2));
		
		WebElement searchSuggestions = driver.findElement(By.id("search-suggestions"));
		aaObject.assertElementDisplayed(searchSuggestions);
		
		searchSuggestions.getCssValue("style").equals("display: table;");
		//using List<WebElements> as the list of items displayed for this autocompleter text box has same className.
		List<WebElement> searchSuggestionList = driver.findElements(By.className("as-rich"));
		
		//of the list of elements, selecting one
		java.util.Iterator<WebElement> i = searchSuggestionList.iterator();
		while(i.hasNext()) {
		    WebElement row = i.next();
		    if(row.getText().equalsIgnoreCase(searchStr))
		    	row.click();
		    System.out.println(row.getText());
		}
		hitSearchButton(driver);
	}
	void hitSearchButton(WebDriver driver){
		
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		aaObject.assertElementDisplayed(searchButton);
		searchButton.click();
	}
	
	public void newUser(WebDriver driver){
		
		WebElement register = driver.findElement(By.id("register"));
		aaObject.assertElementDisplayed(register);
		aaObject.assertAttributeValue(register,"href","/in-en/join?ref=hdr&from_page=https%3A%2F%2Fwww.etsy.com%2F");
		aaObject.innerTextValidation(register,"Register");
		
		register.click();
		
	}
	
	public void cart(WebDriver driver){
		
		WebElement cart = driver.findElement(By.xpath("//a[@title='Cart']"));
	}
}