package betSite;

import static org.testng.Assert.assertNotNull;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import FunctionLibrary.Page;
import Properties.TestData;


/*
 *created by Dima Tiurin Sep 26, 2018
 */

public class PutInBet extends WebDriverSettings{
	private BetSite objBettingSite;
	private String ParentWindow;
	Logger log = Logger.getLogger("devpinoyLogger");
		
	
	@Test(priority = 0)
	private void writeMesssage() {
		System.out.println("Step 1: LogIN");
		PageFactory.initElements(driver,BetSite.class).mathcesPage().open()
		.clickOn("chat").
		sendTextToChat("Who know the best bit and how win today?", "chat").
		clickOn("chatBut").
		clickOn("fb");
		ParentWindow = driver.getWindowHandle();
		for(String Subwindow: driver.getWindowHandles()){
			driver.switchTo().window(Subwindow);
			}
		objBettingSite = new BetSite(driver);
		objBettingSite.
		FBLogInPage()
		.typeValueInRegistrationForm("FBemail", TestData.value("fbemail"), "email")
		.typeValueInRegistrationForm("FBpassword", TestData.value("fbpassword"), "pass")
		.then()
		.clickOn("loginFB");
		Page.pause(3);
		System.out.println("Step 2: Switch to Another Page and puIn Text");
		log.debug("go to another window");
		assertNotNull(ParentWindow);
		driver.switchTo().window(ParentWindow);	
		objBettingSite.mathcesPage().clickOn("chatBut");
		
	}
	
}

