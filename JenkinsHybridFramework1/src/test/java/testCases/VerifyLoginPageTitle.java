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



public class VerifyLoginPageTitle {
	

	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d=BrowserFactory.getBrowser("Firefox");
		d.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void verifyLoginPageTitle1()
	{
		LoginPage login=PageFactory.initElements(d, LoginPage.class);
		String title=login.getApplicationTitle();
		System.out.println("my application title is: "+title);
		Assert.assertTrue(title.contains("SugarCRM"));
		
	}
	@AfterMethod
	public void cleanUp()
	{
		BrowserFactory.closeBrowser(d);
	}

}
