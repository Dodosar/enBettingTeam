package Properties;

import java.io.FileInputStream;
import java.io.IOException;

/*
 *created by Dima Tiurin Jul 13, 2018
 */

public class TestData {
	public static final String PATH_TO_TEST_DATA = "C:/Users/tyudm/git/enBettingTeam/betSite/src/main/resources/config.properties";

	public static String value(String inputvalues) {

		FileInputStream fileinputstream;
		java.util.Properties prop = new java.util.Properties();

		try {
			fileinputstream = new FileInputStream(PATH_TO_TEST_DATA);
			prop.load(fileinputstream);
			return prop.getProperty(inputvalues);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
