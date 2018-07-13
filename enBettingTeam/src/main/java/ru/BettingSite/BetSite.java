package ru.BettingSite;

import org.openqa.selenium.WebDriver;


public class BetSite {
	WebDriver driver;
	
	public BetSite(WebDriver driver){
		this.driver = driver;
	}
	
	public MainPage mainPage(){return new MainPage(driver);}
	

}