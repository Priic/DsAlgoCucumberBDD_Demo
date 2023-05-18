package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.Logger;

public class Helper {

	private static WebDriver driver;
	public final static int TIMEOUT = 2;
	//private FileInputStream fileReader; // reading properties file
	public static Properties p = new Properties(); // getting properties of file
	public static Logger log;

	public static void openPage() {

		driver.get(p.getProperty("StartPageURL"));
	}

	public static void homePage() {

		driver.get(p.getProperty("HomePageURL"));
	}

	public static void gotoRegisterPage() {

		driver.get(p.getProperty("RegisterURL"));
	}

	public static void LoginPage() {

		driver.get(p.getProperty("LoginURl"));
	}

	public static void linkedListPage() {

		driver.get(p.getProperty("LinkedListURL"));
	}
	
	public static void stackPage() {

		driver.get(p.getProperty("StackURL"));
	}
	
	
	public static void arrayPracQuesPage() {

		driver.get(p.getProperty("ArrayPractPageURL"));
	}
	
	public static void graphPage() {

		driver.get(p.getProperty("GraphPageURL"));
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}

	public static void NavBack() {
		driver.navigate().back();
	}

	public static void NavForward() {
		driver.navigate().forward();
	}
	public static void handleAlert() {

		driver.switchTo().alert().accept();
		

	}

	public static void EqualAssert(String expected, String actual) {

		Assert.assertEquals(expected, actual);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() throws IOException {
		
		
		if (driver == null) {
			FileInputStream fileReader = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Config files\\config.properties");
			p.load(fileReader);
			
			setUpDriver1();

		}
	}
		public static void setUpDriver1() throws IOException{
		
		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			driver.manage().window().maximize();
		//	log=LogManager.getLogger();
			LoggerLoad.info("Test is running on " +driver);
	LoggerLoad.info("Driver is Initialized");

		}

		if (p.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			driver.manage().window().maximize();
			LoggerLoad.info("Test is running on " +driver);
			LoggerLoad.info("Driver is Initialized");

		}
		if (p.getProperty("browser").equalsIgnoreCase("EdgeDriver")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			driver.manage().window().maximize();
			LoggerLoad.info("Test is running on " +driver);
			LoggerLoad.info("Driver is Initialized");

		}
		}
		
	

	public static void tearDown() {
		//if (driver != null) {
			driver.close();
			driver.quit();
	//	}
	}
	
}
