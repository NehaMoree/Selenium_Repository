package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage extends BaseClass{
	
	@BeforeClass
	public void verifyTitle() throws IOException {
		
		openBrowser();
		
		String actual_title  = driver.getTitle();
		String expected_title = "PHPTRAVELS | Travel Technology Partner";
		if(actual_title.equals(expected_title)) {
			System.out.println("Title Verified - Test Successful");
		}
		else
		{
			System.out.println("Title Not Verified - Test Unsuccessful");
		}
				
	}
	
	@Test
	public void menus() {
		
		WebElement menu = driver.findElement(By.xpath("//*[@class='nav navbar-nav']"));
		List<WebElement> menus1 = menu.findElements(By.linkText("li"));
		for(WebElement m: menus1) 
		{
			String menu_items = m.getText();
			System.out.println(menu_items);
		}
		
		
	}
	
	@Test
	public void footer() {
		WebElement foot = driver.findElement(By.xpath("//*[@class='footerlist go-right go-text-right']"));
		List<WebElement> footer = foot.findElements(By.linkText("a"));
		for(WebElement f: footer) {
			String footer_items = f.getText();
			System.out.println(footer_items);
		}
	}

}
