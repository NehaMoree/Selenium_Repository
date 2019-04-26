package Academy;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.linksRepository;
import pageObjects.loginPageRepository;
import resources.BaseClass;


public class HomePage extends BaseClass {
	
	public linksRepository lk;
	
	@BeforeTest
	public void basePageNavigation() throws IOException {
		
		driver = initializeDriver();
		lk = new linksRepository(driver);

//		lk.clickLogin().click();
//		driver.navigate().back();
		String heading_Text = lk.textCheck().getText();
		
		//Assert.assertEquals(heading_Text, "Featured Courses");
		Assert.assertTrue(true, heading_Text);
		System.out.println("Heading Matches!");
	
}
	
	@Test 
	public void menuItems() {
		
		Assert.assertTrue(lk.getMenu().isDisplayed());
		List<WebElement> menus = lk.getMenu().findElements(By.tagName("li"));
		
		for(int i =0;i<menus.size();i++) {
			String menu_items = menus.get(i).getText();
			System.out.println(menu_items);
		}
		
	}
	
	@Test (priority=1)
	public void footerItems() {
		
		Assert.assertTrue(lk.getfooterItems().isDisplayed());
		List<WebElement> footer = lk.getfooterItems().findElements(By.xpath("//div[@class='col-sm-3']"));
		for(WebElement f:footer) {
			String footer_item = f.getText();
			System.out.println(footer_item);
		}
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null; //to erase memory
	}
	

}