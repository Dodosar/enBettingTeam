package FunctionLibrary;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

public class PageSingUp extends Page implements typeValue,selectChechbox,checkPopUpmessage{

	public PageSingUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Page SelectCheckBoxInRegistrationForm(String element){
		if (getElement(element).isSelected()) {
			System.out.println("Check-box is Toggled on");
			return this;
		} else {
			System.out.println("Check-box is not Toggled off");
			return clickOn(element);
		}
	}

	public PageSingUp typeValueInRegistrationForm(String element,
			String textforelements,String Attribute) {
		isAttributePresent(element, Attribute);
		getElement(element).clear();
		getElement(element).sendKeys(textforelements);
		isExistPng();
		return this;
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
