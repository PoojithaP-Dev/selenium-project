package base;

//import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;

	public static WebDriver WebDriverManager() {
		if (driver == null) {
			setUp();
		}
		return driver;

	}

	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void tearDown() {

		if (driver != null) {
			driver.quit();
			driver = null; 
		}

	}

}
