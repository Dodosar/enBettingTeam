package FunctionLibrary;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class PageSingUp extends Page implements checkPopUpmessage{

	public PageSingUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean CheckPopUpMessage(String element) {
		try {
			if (getElement(element).isDisplayed()) {
				// isExistPng();
				System.out.println("Pop-up meesage is displayed");
			} else {
				// isExistPng();
				System.out.println("Pop-up meesage is not displayed");
			}
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
}
