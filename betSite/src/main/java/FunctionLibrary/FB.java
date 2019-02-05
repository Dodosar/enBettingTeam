package FunctionLibrary;


import org.openqa.selenium.WebDriver;

/*
 *created by Dima Tiurin Aug 16, 2018
 */

public class FB extends Page implements typeValue{


	public FB(WebDriver driver) {
		super(driver);
	}

	@Override
	public final FB typeValueInRegistrationForm(String element,
			String textforelements,String Attribute) {
		isAttributePresent(element, Attribute);
		getElement(element).clear();
		getElement(element).sendKeys(textforelements);
		isExistPng();
		return this;
	}


	

}

