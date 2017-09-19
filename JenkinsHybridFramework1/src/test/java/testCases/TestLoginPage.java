package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory2.BrowserFactory;
import factory2.DataProviderFactory;
import pages.LoginPage;

public class TestLoginPage {

public static WebDriver d;
	
	@BeforeMethod
	public void setUp()
	{
		d=BrowserFactory.getBrowser("Firefox"); //launch the browser
		d.get(DataProviderFactory.getConfig().getApplicationUrl()); //goes to or navigate to particular url
	}
	
	@Test
	public void verifyLogin() throws InterruptedException
	{
		LoginPage login= PageFactory.initElements(d, LoginPage.class);
		String title=login.getApplicationTitle();
		Assert.assertTrue(title.contains("SugarCRM"));
		//verifying actual page title with title of sugarcrm title
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		//above line/method will pick up the userName and password from the excelsheet
		//to verify login is successful and signout link is present
		Thread.sleep(5000);
		login.verifyLogOutLink();
	}
	
	@AfterMethod
	public void cleanUp()
	{
		BrowserFactory.closeBrowser(d);
	}
}





