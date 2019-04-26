package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	
	@Test
	public WebDriver initializeDriver() throws IOException {
		
		
		prop = new Properties();
		FileInputStream fs = new FileInputStream("F:\\SELENIUM_NEW\\Workspace\\E2EProject\\src\\test\\java\\resources\\datadriven.properties");

		prop.load(fs);
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if(prop.getProperty("browser").equals("InternetExplorer")) {
			
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public void getScreenshot(String result) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("F:\\SELENIUM_NEW\\screenshots\\"+result+"test.png"));
	}
	

}
