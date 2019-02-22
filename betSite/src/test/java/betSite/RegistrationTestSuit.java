package betSite;



import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import Properties.TestData;

/*create test by Dima Tiurin*/

public class RegistrationTestSuit extends WebDriverSettings {
	private BetSite objBettingSite;
	private String ParentWindow;
	//Logger log = Logger.getLogger(System.getProperty("LOG4J"));
	Logger log = Logger.getLogger("devpinoyLogger");
	@Test(priority = 0)
	private void LogIn() throws Exception {
		// Open the web site, check the title and got to sing up window
		objBettingSite = new BetSite(driver);
		org.apache.log4j.BasicConfigurator.configure();
		System.out.println("Step 1: Check Title on Main Page");
		/* можно использывать этот способ обращения к обьекту*/
		PageFactory.initElements(driver, MainPage.class).open();
		log.debug("opening webiste");
		log.info("test info");
		ParentWindow = driver.getWindowHandle();
		objBettingSite.mainPage().pageShouldBe(objBettingSite.mainPage()).and().clickOn("login")
				.then().clickOn("signup").then();
		log.debug("opening singup");
		log.fatal("This is a FATAL message.");
		log.error("This is an ERROR message.");
		log.warn("This is a WARN message.");
		log.info("This is an INFO message.");
		log.debug("This is a DEBUG message.");
		log.trace("This is a TRACE message.");
	}
/*
	@Test(priority = 1)
	private void IncorrectEmail() throws Exception {
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
	private void IncorrectPassword() throws Exception {
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
	private void IncorrectConfirm() throws Exception {
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
	}
*/	
	@Test(priority = 4)
	private void SingIn() throws Exception {
		objBettingSite.mainPage().clickOn("haveaccount")
			.then().clickOn("fb");
		log.debug("opening fb");
		for(String Subwindow: driver.getWindowHandles()){
			driver.switchTo().window(Subwindow);
			}
		objBettingSite.
						FBLogInPage()
						.typeValueInRegistrationForm("FBemail", TestData.value("fbemail"), "email")
						.typeValueInRegistrationForm("FBpassword", TestData.value("fbpassword"), "pass")
						.then()
						.clickOn("loginFB");
		log.debug("sing up in fb");
		assertNotNull(ParentWindow);
	}
	@Test(priority = 5)
	public void SingOut() throws Exception{
		driver.switchTo().window(ParentWindow);
		objBettingSite.mainPage().pageShouldBe(objBettingSite.mainPage()).InVisiableElement("profic", "singout");	
		log.debug("sing out from fb");
		//objBettingSite.mainPage().ClickOnInvisiableElement("singout");				
	}
}