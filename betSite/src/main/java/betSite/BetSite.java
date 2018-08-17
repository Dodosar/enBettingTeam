package betSite;

import org.openqa.selenium.WebDriver;

import FunctionLibrary.FB;
import FunctionLibrary.MainPage;

public class BetSite {
	WebDriver driver;

	public BetSite(WebDriver driver) {
		this.driver = driver;
	}

	public MainPage mainPage() {
		return new MainPage(driver);
	}
	
	public FB FBLogInPage() {
		return new FB(driver);
	}

}