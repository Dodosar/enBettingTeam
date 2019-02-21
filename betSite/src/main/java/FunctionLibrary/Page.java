package FunctionLibrary;



import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;



//import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Elements.Elements;

public abstract class Page implements typeValue, selectChechbox {
	
	HttpURLConnection connection = null;

	protected static WebDriver driver;
	protected String url = "";
	static int b = 0;

	public Page(WebDriver driver) {
		PageSingUp.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Page open() {
		driver.get(url);
		pause(1);
		System.out.println("open page " + url);
		return this;
	}

	public String getXpath(String element) {
		return Elements.getEntryForElementName(element).getXpath();
	}

	public WebElement getElement(String element) {
		return driver.findElement(By.xpath(getXpath(element)));

	}

	public String getURL() {
		return url;
	}

	public Page and() {
		return this;
	}

	public Page then() {
		return this;
	}

	public Page pageShouldBe(Page expectedPage) throws MalformedURLException, IOException {
		if (driver.getCurrentUrl().equals(expectedPage.getURL())) {
			System.out.println("The page " + expectedPage.getURL()
					+ " was loaded");
		connectHttp(expectedPage);
			return expectedPage;
		}
		throw new RuntimeException("Cannot load page " + expectedPage.getURL());
	}

	private void connectHttp(Page expectedPage) throws IOException,
			MalformedURLException, ProtocolException {
		connection = (HttpURLConnection) new URL(expectedPage.getURL()).openConnection();
		
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setConnectTimeout(1000);
		connection.setReadTimeout(1000);
		
		connection.connect();
		
		System.out.println(connection.getResponseMessage() + ": " + connection.getResponseCode() );
		
		connection.disconnect();
	}

	protected void pause(int i) {
		try {
			Thread.sleep(1000 * i);
			// isExistPng();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeSnapShot(WebDriver driver, String fileWithPath)
			throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);

		FileUtils.copyFile(ScrFile, DestFile);
	}

	public static void isExistPng() {
		String a = "D://Selenium/Screens/test.png";
		try {
			if (new File(a).exists()) {
				a = String.format("D://Selenium/Screens/test%d.png", b++);
				takeSnapShot(driver, a);
			} else {
				takeSnapShot(driver, a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Page clickOn(String element) {
		getElement(element).click();
		pause(1);
		// isExistPng();
		System.out.println("Click on element " + element);
		return this;

	}

	public Page WaitUntilAndClick(String xpath) {
		new WebDriverWait(driver, 5).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(getXpath(xpath))));
		return this;

	}

	protected boolean isAttributePresent(String xpath, String attribute) {
		Boolean result = false;
		try {
			String value = getElement(xpath).getAttribute(attribute);
			if (value != null) {
				System.out.println("Attribute is present "
						+ attribute.toUpperCase());
				result = true;
			}
		} catch (Exception e) {
			isExistPng();
		}
		return result;

	}

	public void ClickOnInvisiableElement(String element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click;", getElement(element));
	}

	public void InVisiableElement(String element, String invElement) {
		pause(2);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(element))
					.moveToElement(getElement(invElement)).click()
					.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page typeValueInRegistrationForm(String element,
			String textforelements, String Attribute) {
		isAttributePresent(element, Attribute);
		getElement(element).clear();
		getElement(element).sendKeys(textforelements);
		isExistPng();
		return this;
	}

	public Page SelectCheckBoxInRegistrationForm(String element) {
		if (getElement(element).isSelected()) {
			System.out.println("Check-box is Toggled on");
			return this;
		} else {
			System.out.println("Check-box is not Toggled off");
			return clickOn(element);
		}
	}
}
