package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linksRepository {
	
	
	public WebDriver driver;

	public linksRepository(WebDriver driver) {
		
		this.driver=driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");
	By title_link = By.xpath("//*[@id=\"content\"]/div/div/h2");
	By menu = By.xpath("//*[@class='nav navbar-nav navbar-right']");
	By menus = By.tagName("li");
	By foot = By.id("prefooter");
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public WebElement textCheck() {
		return driver.findElement(title_link);
	}
	
	public WebElement getMenu() {
		return driver.findElement(menu);
	}
	public WebElement getMenuItems() {
		return driver.findElement(menus);
	}
	
	public WebElement getfooterItems() {
		return driver.findElement(foot);
	}

}
