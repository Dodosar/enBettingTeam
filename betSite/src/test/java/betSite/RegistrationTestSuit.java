package betSite;

import junit.framework.Assert;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import Properties.TestData;

/*create test by Dima Tiurin*/

public class RegistrationTestSuit extends WebDriverSettings {
	private BetSite objBettingSite;
	private String ParentWindow;

	@Test(priority = 0)
	public void LogIn() {

		// Open the web site, check the title and got to sing up window
		objBettingSite = new BetSite(driver);
		System.out.println("Step 1: Check Title on Main Page");
		objBettingSite.mainPage().open();
					ParentWindow = driver.getWindowHandle();
					System.out.println(ParentWindow);
		objBettingSite.mainPage().pageShouldBe(objBettingSite.mainPage()).and().clickOn("login")
				.then().clickOn("signup").then();
	}

	/*@Test(priority = 1)
	public void IncorrectEmail() throws Exception {
		// test sing up form for registration. And assert message when it is
		// incorrect
		objBettingSite
				.mainPage()
				.typeValueInRegistrationForm("email", TestData.value("incorectemail"),"required")
				.then()
				.typeValueInRegistrationForm("password",
						TestData.value("password"),"required")
				.then()
				.typeValueInRegistrationForm("cpassword",
						TestData.value("confirpassword"),"required").then()
				.SelectCheckBoxInRegistrationForm("checkbox").clickOn("signup");		

	
	}
	
	@Test(priority = 2)
	public void IncorrectPassword() throws Exception {
		objBettingSite.
						mainPage()
						.typeValueInRegistrationForm("email", TestData.value("email"),"email")
						.then()
						.typeValueInRegistrationForm("password",
								TestData.value("incorrectpas"),"password")
						.then()
						.typeValueInRegistrationForm("cpassword",
								TestData.value("confirpassword"),"password").then()
						.SelectCheckBoxInRegistrationForm("checkbox").clickOn("signup");
	}
	
	@Test(priority = 3)
	public void IncorrectConfirm() throws Exception {
		objBettingSite.
						mainPage()
						.typeValueInRegistrationForm("email", TestData.value("email"),"email")
						.then()
						.typeValueInRegistrationForm("password",
								TestData.value("password"),"password")
						.then()
						.typeValueInRegistrationForm("cpassword",
								TestData.value("incorrectconfirm"),"password").then()
						.SelectCheckBoxInRegistrationForm("checkbox").clickOn("signup").then();
	}*/
	
	@Test(priority = 4)
	public void SingIn() throws Exception {
		objBettingSite.mainPage().clickOn("haveaccount")
			.then().clickOn("fb");
		for(String Subwindow: driver.getWindowHandles()){
			driver.switchTo().window(Subwindow);
			}
		objBettingSite.
						FBLogInPage()
						.typeValueInRegistrationForm("FBemail", TestData.value("fbemail"), "email")
						.typeValueInRegistrationForm("FBpassword", TestData.value("fbpassword"), "pass")
						.then()
						.clickOn("loginFB");
		assertNotNull(ParentWindow);
		driver.switchTo().window(ParentWindow);
		objBettingSite.mainPage().InVisiableElement("profic", "singout");	
		//objBettingSite.mainPage().ClickOnInvisiableElement("singout");				
	}
}