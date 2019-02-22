package betSite;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

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
	
	@Test(priority = 1)
	private void writeMesssage() {
		$(By.xpath("//*[@class='bi-field w-chat-send__field bi-mod-input-placeholder "
				+ "bi-field--theme-gray']")).setValue("TestDima").pressEnter();
	}
}

