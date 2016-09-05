package google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author paskor
 *
 */
public class GoogleTest {

	private static WebDriver driver;

	static {
		afterAll();
	}

	@BeforeMethod
	public void beforeMethod() {

		// Please set path to the chromedriver.exe if not set on the OS level !
		/*System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");*/ 

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Fails the test
		driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
	}

	@Test
	public void openGoogleEn() {
		driver.get("https://www.google.com/?hl=en");
	}

	@AfterMethod
	public void afterMethod() {
		quitDirver();
	}

	private static void afterAll() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				quitDirver();	
			}
		});
	}

	private static void quitDirver() {
		if (driver != null) {
			driver.quit();
		}
	}
}