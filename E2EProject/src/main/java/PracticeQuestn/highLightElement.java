package PracticeQuestn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class highLightElement {
	WebDriver driver;
	
	@Test
	public void test2() {
		System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath("//*[@class='entry-title']"));
		highLightElement(driver,ele);
		

}
	

	public void highLightElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		String script = "arguments[0].style.border='3px solid red';";

		je.executeScript(script, element);
	}
	

}