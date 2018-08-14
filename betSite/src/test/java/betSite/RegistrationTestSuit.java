package betSite;

import org.testng.annotations.Test;

import Properties.TestData;

/*create test by Dima Tiurin*/

public class RegistrationTestSuit extends WebDriverSettings {
	BetSite objBettingSite;

	@Test(priority = 0)
	public void LogIn() {

		// Open the web site, check the title and got to sing up window
		objBettingSite = new BetSite(driver);
		System.out.println("Step 1: Check Title on Main Page");
		objBettingSite.mainPage().open()
				.pageShouldBe(objBettingSite.mainPage()).and().clickOn("login")
				.then().clickOn("signup").then();
	}

	@Test(priority = 1)
	public void IncorrectEmail() throws Exception {
		// test sing up form for registration. And assert message when it is
		// incorrect
		objBettingSite
				.mainPage()
				.typeValueInRegistrationForm("email", TestData.value("email"))
				.then()
				.typeValueInRegistrationForm("password",
						TestData.value("password"))
				.then()
				.typeValueInRegistrationForm("cpassword",
						TestData.value("confirpassword")).then()
				.SelectCheckBoxInRegistrationForm("checkbox").clickOn("signup");// .CheckPopUpMessage("popup");
	}
}