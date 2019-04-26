package PracticeQuestn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DateTimeZone {
	
	WebDriver driver;
	
	@Test
	public void test2() {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
//		
//		formatter.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
//		System.out.println("US/Eastern"+formatter.format(date));
//	
		String[] allTimeZones = TimeZone.getAvailableIDs();
		for(int i=0;i<allTimeZones.length;i++) {
			System.out.println(allTimeZones[i]+": "+formatter.format(date));
		}

}
}