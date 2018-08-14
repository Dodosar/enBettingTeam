package Properties;

import java.io.FileInputStream;

/*
 *created by Dima Tiurin Jul 13, 2018
 */

public class Propert {
	public static final String Path_to_properties = "src/main/config.properties";

	public static String getProperties(String prop) {
		FileInputStream fileInputStream;
		java.util.Properties properties = new java.util.Properties();

		try {
			fileInputStream = new FileInputStream(Path_to_properties);
			properties.load(fileInputStream);
			return properties.getProperty(prop);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}

		return null;
	}
}
