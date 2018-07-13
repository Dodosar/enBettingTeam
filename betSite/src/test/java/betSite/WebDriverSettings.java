package betSite;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings extends EmailReport {
	protected static WebDriver driver;

	/*
	 * @BeforeClass public static void setupClass() {
	 * ChromeDriverManager.getInstance().setup(); }
	 */

	/*
	 * @BeforeTest public void setUp() throws Exception { driver = new
	 * ChromeDriver();
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
	 * WebDriverWait wait = new WebDriverWait(driver, 30,500); }
	 */
	// *@Parameters("browser")
	@BeforeTest
	public static void setupClass1() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String browser = null;
		/*
		 * //Check if parameter passed from TestNG is 'firefox'
		 * if(browser.equalsIgnoreCase("firefox")){ //create firefox instance
		 * System.setProperty("webdriver.firefox.marionette",
		 * ".\\geckodriver.exe"); driver = new FirefoxDriver(); }
		 */
		try {
			browser = reader.readLine();
			System.out.println(browser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectBrowser(browser);
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.get("http://localhost:4444/selenium-server/driver/?cmd=shutDownSeleniumServer");
			driver.quit();
		}
	}

	@AfterSuite
	public void tearDown() {
		sendPDFReportByGMail("tyudm@anzer.com", "Lbvf650065",
				"tiurindmitry1989@gmail.com", "PDF Report",
				"Test how will sent PDF file by email");
		if (driver != null) {
			driver.quit();
		}
	}

	public static void selectBrowser(String browser)
			throws MalformedURLException {
		switch (browser) {
		case "CH":
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-extenstions");
			driver = new ChromeDriver(options);
			System.out.println("Welcome to Maven World and browser CH");
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			// driver.manage().window().maximize();
			break;
		case "IE":
			try {
				System.out.println("Welcome to Maven World and browser IE");
				System.setProperty("webdriver.ie.driver",
						".\\IEDriverServer.exe");
				DesiredCapabilities capability = DesiredCapabilities
						.internetExplorer();
				capability
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				capability.setCapability(
						InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				// capability1.setBrowserName("chrome");
				URL hostURL = new URL("http://localhost:4444/wd/hub");
				driver = new RemoteWebDriver(hostURL, capability);
				// driver = new InternetExplorerDriver();
				driver.manage().timeouts()
						.pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		case "Op":
			System.out.println("Welcome to Maven World and browser Opera");
			System.setProperty("webdriver.opera.driver", ".\\operadriver.exe");
			OperaOptions opera = new OperaOptions();
			opera.addArguments("disable-infobars");
			opera.addArguments("--start-maximized");
			opera.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
			driver = new OperaDriver(opera);
			// WebDriverManager.operadriver().setup();
			// driver =new OperaDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			break;
		case "FF":
			System.out.println("Welcome to Maven World and browser FF");
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			System.out.println(WebDriverManager.firefoxdriver().getVersions());
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			break;
		case "FFF":
			System.out.println("Welcome to Maven World and browser FF");
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			System.out.println(WebDriverManager.firefoxdriver().getVersions());
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--start-maximized");
			capability.setCapability(ChromeOptions.CAPABILITY, options1);
			;
			// URL hostURL = new URL("http://localhost:4444/wd/hub");
			// driver = new RemoteWebDriver(hostURL,capability);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			break;
		case "HT":
			System.out.println("Welcome to Maven World and browser HTMLUnit");
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			break;
		case "Ph":
			System.out.println("Welcome to Maven World and browser Phantom");
			WebDriverManager.phantomjs().useMirror().setup();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			DesiredCapabilities capability1 = DesiredCapabilities.chrome();
			ChromeOptions options2 = new ChromeOptions();
			options2.addArguments(Arrays.asList("--start-maximized"));
			capability1.setCapability(ChromeOptions.CAPABILITY, options2);
			;
			capability1.setBrowserName("chrome");
			URL hostURL1 = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(hostURL1, capability1);
			// System.out.println(WebDriverManager.chromedriver().getVersions());
			// driver = new ChromeDriver(options2);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			break;
		}
	}

}
