package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver InitBrowser() {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
		
	}
	
	
	public static void tearDown() {
		
		driver.close();
		driver.quit();
		
	}
}
