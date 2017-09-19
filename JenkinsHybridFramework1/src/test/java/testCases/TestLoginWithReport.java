package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory2.BrowserFactory;
import factory2.DataProviderFactory;

import pages.LoginPage;

public class TestLoginWithReport {

	WebDriver d;
	ExtentReports report; //create report by using this class
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report=new ExtentReports("./Reports/LoginPageReports.html",true);
		logger=report.startTest("TestLogin");
		d=BrowserFactory.getBrowser("Firefox");
		d.get(DataProviderFactory.getConfig().getApplicationUrl());
		//to add log activity
		logger.log(LogStatus.INFO, "Application is up & running");
	}
	
	@Test
	public void verifyLogin()
	{
		LoginPage login=PageFactory.initElements(d, LoginPage.class);
		String title=login.getApplicationTitle();
		Assert.assertTrue(title.contains("SugarCRM"));
		//to display passed verification log
		logger.log(LogStatus.PASS, "LoginPage verified successfully");
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		//to display the login successful log
		logger.log(LogStatus.PASS, "login successful");
		login.verifyLogOutLink();
		//to display logout link displayed successful status
		logger.log(LogStatus.INFO, "logout link is present");
	}
	
	@AfterMethod
	public void cleanUp()
	{
		BrowserFactory.closeBrowser(d);
		report.endTest(logger);
		report.flush();
	}
}





