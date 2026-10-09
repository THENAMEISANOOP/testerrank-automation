package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DownloadUtils;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		ChromeOptions options = DownloadUtils.getChromeOptions();

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.testerrank.com/topics");
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
}