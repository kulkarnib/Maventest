package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory2.BrowserFactory;
import factory2.DataProviderFactory;
import pages.LoginPage;



public class TestLoginWithReportAndScreenshot {


	WebDriver d;
	ExtentReports report;
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
		logger.log(LogStatus.PASS, "Login verified successfuly");
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		//to display the login successful log
		//logger.log(LogStatus.PASS, "login successful");
		logger.log(LogStatus.INFO, "click on login button");
		login.verifyLogOutLink();
		//to display logout link displayed successful status
		logger.log(LogStatus.INFO, logger.addScreenCapture(utility.Helper.captureScreenshot(d, "validation2")));
		
		//to fail the test case so that selenium take screenshot
		//Assert.assertFalse(false);
		//String path=utility.Helper.captureScreenshot(d, "b.png");
		//calls capture screenshot() from helper class and stores the screenshot path
		logger.log(LogStatus.PASS, "logout link is present");
		
	}
	
	@AfterMethod
	public void cleanUp(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=utility.Helper.captureScreenshot(d, result.getName());
			//calls capture screenshot() from helper class and stores the screenshot path
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
		}
		BrowserFactory.closeBrowser(d);
		report.endTest(logger);
		report.flush();
	}
}




