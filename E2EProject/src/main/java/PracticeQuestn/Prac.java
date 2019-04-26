package PracticeQuestn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Prac {
	
	WebDriver driver;
	

//	@BeforeTest
//	public void brow() {
//		System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("http://www.espncricinfo.com/");
//		
//	}
//	
//	@Test
//	public void test1() {
//		String scrr = driver.getPageSource();
//		String toCheck = "Cricket";
//		
//		boolean isTextPresent = scrr.contains(toCheck);
//		System.out.println("Result "+isTextPresent);
//	}
	
	@Test
	public void test2() {
		System.setProperty("webdriver.chrome.driver", "F:\\SELENIUM_NEW\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='datepicker']")).click();
		driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		
		String name = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
		System.out.println(name);
		
		if(name.equals("September 2018")) {
			List<WebElement> day = driver.findElements(By.xpath("//*[@data-handler='selectDay']"));
			for(WebElement d:day) {
				String n = d.getText();
				if(n.equals("11")) {
					d.click();
									}
			}
		}
		
	}
	
	
	

}
