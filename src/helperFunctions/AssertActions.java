package helperFunctions;

import static org.testng.AssertJUnit.*;

import org.openqa.selenium.WebElement;

public class AssertActions{
	
	public void assertElementDisplayed(WebElement element){
		assertTrue(element.isDisplayed());
	}
	
	public void assertAttributeValue(WebElement element,String attribute,String expectedValue){
		
		String staticText = element.getAttribute(attribute);
		assertEquals(staticText,expectedValue);
	}
	
	public void innerTextValidation(WebElement element,String expectedValue){
		assertTrue(element.getText().equals(expectedValue));
		
	}
}