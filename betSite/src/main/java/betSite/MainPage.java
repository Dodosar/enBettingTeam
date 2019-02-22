package betSite;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import FunctionLibrary.PageSingUp;

public class MainPage extends PageSingUp {

	public MainPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		url = "https://betting.team/en";
		/* url = Propert.get("url_mainpage"); */

	}

}
