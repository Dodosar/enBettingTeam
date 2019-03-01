package betSite;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import FunctionLibrary.Page;

public class MainPage extends Page {

	public MainPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		url = "https://betting.team/en";
		/* url = Propert.get("url_mainpage"); */
	}
	@Override
	public MainPage logo() {
		assertEquals("//*[@alt='Betting Insider']", getXpath("logo"));
		System.out.println("true");
		return this;
	}
	
	public MainPage sendTextToChat(String text,String element) {
		this.getElement(element).sendKeys(text);;		
		return this;
	}
	
	

}
