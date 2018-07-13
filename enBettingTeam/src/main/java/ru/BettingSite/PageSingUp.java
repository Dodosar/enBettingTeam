package ru.BettingSite;

import org.openqa.selenium.ElementNotVisibleException;

import org.openqa.selenium.WebDriver;


public class PageSingUp extends Page{	
	
	public PageSingUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Page isSelectedCheckbox(String element){
		if(getElement(element).isSelected()){
			isExistPng();
			System.out.println("Check-box is Toggled on");
			return this;
		}
		else
		{
			System.out.println("Check-box is not Toggled off");
			isExistPng();
			return clickOn(element);
		}
	}
	
	public PageSingUp typeInThefield(String element,String textforlements){
		getElement(element).clear();
		getElement(element).sendKeys(textforlements);
		isExistPng();
		return this;
	}

	@Override
	public boolean CheckPopUpMessage(String element) {
		try{
		if(getElement(element).isDisplayed()){
			isExistPng();
			System.out.println("Pop-up meesage is displayed");
		}
		else {
			isExistPng();
			System.out.println("Pop-up meesage is not displayed");
		}}
		catch(ElementNotVisibleException e){
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
}
