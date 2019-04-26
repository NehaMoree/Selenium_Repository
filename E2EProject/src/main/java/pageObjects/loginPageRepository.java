package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageRepository {

	
	public WebDriver driver;
	
	
	
	public loginPageRepository(WebDriver driver) {
		
		this.driver=driver;
	}

	By email = By.id("user_email");
	By password = By.id("user_password");
	By logIn = By.xpath("//*[@value='Log In']");
	
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement clickButton() {
		return driver.findElement(logIn);
	}
	
}
