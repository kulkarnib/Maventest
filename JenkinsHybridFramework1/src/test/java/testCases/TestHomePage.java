package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestHomePage {
	
	WebDriver d;
	public TestHomePage()
	{
		this.d=TestLoginPage.d;
	}
	
	@Test
	public void verifyLeads() throws InterruptedException
	{
		HomePage home=PageFactory.initElements(d, HomePage.class);
		home.clickOnSales();
	}

}
