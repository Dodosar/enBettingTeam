import org.testng.annotations.Test;
import org.testng.annotations.Test;

import ru.BettingSite.BetSite;

/*create test by Dima Tiurin*/

public class Story1 extends WebDriverSettings {
	BetSite objBettingSite;

	String email = "tiurindmitry1989@gmail.com";
	String password = "Dima650065";
	String confirpassword = "Dima650065";
	String incorectemail = "TEST1";
	String incorrectpas = "123";
	String incorrectconpas = "999";

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
		objBettingSite.mainPage().typeInThefield("email", incorectemail).then()
				.typeInThefield("password", password).then()
				.typeInThefield("cpassword", confirpassword).then()
				.isSelectedCheckbox("checkbox").clickOn("signup");// .CheckPopUpMessage("popup");
	}
}