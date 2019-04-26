package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	WebDriver driver;
	
	@Test
	public void openBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("F:\\SELENIUM_NEW\\Workspace\\PhpTravels\\src\\test\\java\\test\\datadriven.properties");
		prop.load(fs);
		
		if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "F:\\\\SELENIUM_NEW\\\\Browser_Drivers\\\\geckodriver-v0.18.0-win64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.get(prop.getProperty("url"));
	}

}
