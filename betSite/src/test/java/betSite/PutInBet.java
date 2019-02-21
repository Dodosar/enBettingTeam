package betSite;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/*
 *created by Dima Tiurin Sep 26, 2018
 */

public class PutInBet extends WebDriverSettings{
	private BetSite objBettingSite;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	@Test(priority = 0)
	private void countMatches() throws Exception{
		objBettingSite = new BetSite(driver);
		org.apache.log4j.BasicConfigurator.configure();
		System.out.println("Step 1: Check Title on Matches Page");
		objBettingSite
					.mainPage().open().clickOn("matchesPage");
	}
}

