package FunctionLibrary;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.NoSuchElementException;

/*
 *created by Dima Tiurin Aug 16, 2018
 */

public interface typeValue {
	public Object typeValueInRegistrationForm(String element,
			String textforlements,String Attribute) throws NoSuchElementException,NoSuchAttributeException;

}

