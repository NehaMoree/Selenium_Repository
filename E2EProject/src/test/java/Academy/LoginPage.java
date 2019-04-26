package Academy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.linksRepository;
import pageObjects.loginPageRepository;
import resources.BaseClass;


public class LoginPage extends BaseClass {
	
	@Test(dataProvider="getData")
	public void loginTrial(String usernm, String pass) throws IOException {
		
		driver = initializeDriver();
				
		linksRepository lk = new linksRepository(driver);
		lk.clickLogin().click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		loginPageRepository lg = new loginPageRepository(driver);
		lg.email().sendKeys(usernm);
		lg.password().sendKeys(pass);
		
		lg.clickButton().click();
}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		//For positive values
		data[0][0] = "bracegraceyou@gmail.com";
		data[0][1] = "qaclickacademy";
		
		
		//for negative values
		data[1][0] = "dxcgvbhnjm";
		data[1][1] = "fghjk";
		
		
		return data;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
