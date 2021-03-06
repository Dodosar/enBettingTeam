package betSite;
//import org.testng.annotations.AfterTest;
//import org.openqa.selenium.Platform;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

import org.testng.annotations.BeforeTest;

import Properties.Propert;

public class WebDriverSettings extends EmailReport {
	public static WebDriver driver;
	public static String browser = null;

	/*
	 * @BeforeClass public static void setupClass() {
	 * ChromeDriverManager.getInstance().setup(); }
	 * 
	 * @BeforeTest public void setUp() throws Exception { driver = new
	 * ChromeDriver();
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
	 * WebDriverWait wait = new WebDriverWait(driver, 30,500); }
	 */
	// *@Parameters("browser")
	
	@BeforeTest(alwaysRun = true)
	public static void setupClass() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);		
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

			e.printStackTrace();
		}
		selectBrowser(browser);
	}

	/*
	 * @AfterTest(alwaysRun = true) public void teardown() { // driver.get(
	 * "http://localhost:4444/selenium-server/driver/?cmd=shutDownSeleniumServer"
	 * ); driver.quit(); driver.close(); }
	 */
	
	
	//@AfterTest
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		sendPDFReportByGMail("tyudm@anzer.com", "Lbvf650065",
				"tiurindmitry1989@gmail.com", "PDF Report",
				"Dima Tiurin");
		if (driver == null) {
			CheckBrowserOpera("OP");
			return;
		}
		CheckBrowserOpera("OP");
		driver.quit();
		driver = null;
	}

	private void CheckBrowserOpera(String browser) throws IOException {
		if (browser == "OP") {
			Runtime.getRuntime().exec("taskkill /f /im opera.exe");
		}
	}

	@SuppressWarnings("deprecation")
	public static WebDriver selectBrowser(String browser) throws MalformedURLException {
		if (driver == null) {
		switch (browser.toUpperCase()) {
		case "CH":
			System.setProperty("webdriver.chrome.driver",
					Propert.getProperties("Chromewebdriver_path"));
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-extenstions");
			driver = new ChromeDriver(options);
			System.out.println("Welcome to Maven World and browser CH");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
			break;
		case "IE":
			try {
				System.out.println("Welcome to Maven World and browser IE");
				System.setProperty("webdriver.ie.driver",
						Propert.getProperties("IEServer_path"));
				DesiredCapabilities capability = DesiredCapabilities
						.internetExplorer();
				capability
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				capability.setCapability(
						InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				driver = new InternetExplorerDriver(capability);
				driver.manage().timeouts()
						.pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		case "OP":
			System.out.println("Welcome to Maven World and browser Opera");
			System.setProperty("webdriver.opera.driver",
					Propert.getProperties("Opera_path"));
			OperaOptions opera = new OperaOptions();
			opera.addArguments("--disable-infobars");
			opera.addArguments("--start-maximized");
			opera.setBinary(Propert.getProperties("binery_opera"));
			driver = new OperaDriver(opera);
			// WebDriverManager.operadriver().setup();
			// driver =new OperaDriver();
			// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			break;
		/*case "FF":
			System.out.println("Welcome to Maven World and browser FF");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;*/
		case "FFF":
			System.out.println("Welcome to Maven World and browser FF");
			System.setProperty("webdriver.gecko.driver",
					Propert.getProperties("Geckofriver_path"));
			System.out.println(WebDriverManager.firefoxdriver().getVersions());
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			FirefoxOptions optionsFF = new FirefoxOptions();
			optionsFF.addArguments("--start-maximized");
			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsFF);
			;
			// URL hostURL = new URL("http://localhost:4444/wd/hub");
			// driver = new RemoteWebDriver(hostURL,capability);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			break;
		case "HT":
			System.out.println("Welcome to Maven World and browser HTMLUnit");
			driver = new HtmlUnitDriver(true);
			/*
			 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			 * driver.manage().timeouts().setScriptTimeout(30,
			 * TimeUnit.SECONDS);
			 */
			break;
		case "Ph":
			System.out.println("Welcome to Maven World and browser Phantom");
			WebDriverManager.phantomjs().useMirror().setup();
			/*
			 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			 * driver.manage().timeouts().setScriptTimeout(60,
			 * TimeUnit.SECONDS);
			 */
			break;
		default:
			System.out.println("Welcome to Maven World and browser Chrome on RemoteWebDriver");
			ChromeOptions option3 = new ChromeOptions();
			option3.addArguments("--window-size=1920x1080");
			//optionRemote.addArguments("--start-maximized");
			/*Map<String, Object> options1 = new HashMap<String, Object>();
			ArrayList<String> args = new ArrayList<String>();
			args.add("enable-automation");
			args.add("test-type=browser");
			args.add("disable-plugins");
			args.add("disable-infobars");
			args.add("window-size=1920x1080");*/
			//options1.put("args", args);
			DesiredCapabilities capabilityRemote = DesiredCapabilities.chrome();			
			capabilityRemote.setCapability(ChromeOptions.CAPABILITY, option3);
			capabilityRemote.setBrowserName("chrome");
			URL hostURL1 = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(hostURL1, capabilityRemote);
			/*JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.resizeTo(1366, 768);");*/
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
			break;
		}
		}
	return driver;	
	}
}
