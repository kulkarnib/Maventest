package factory2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	static WebDriver d;
	public static WebDriver getBrowser(String browserName)
	{
		//to load firefox browser
		if (browserName.equalsIgnoreCase("Firefox"))
		{
			d=new FirefoxDriver();
		}
		
		//to load chrome browser
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "DataProviderFactory.getConfig().getChromePath()");
			d=new ChromeDriver();
		}
		
		//to load ie browser
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "DataProviderFactory.getConfig().getIEPath()");
			d=new InternetExplorerDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return d;
	}
	public static void closeBrowser(WebDriver dr)
	{
		dr.close();  // to close the browser
	}

}


