package betSite;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import FunctionLibrary.Page;

public class Mathces extends Page {

	public Mathces(WebDriver driver) {
		super(driver);
		url = "https://betting.team/en/match";
	}
	
	public Mathces JSExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollBy(0,1000)");		
		return this;
	}
	
	public Mathces sendTextToChat(String text,String element) {
		getElement(element).sendKeys(text);		
		return this;
	}
}
