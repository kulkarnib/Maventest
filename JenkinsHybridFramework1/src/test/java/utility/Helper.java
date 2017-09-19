package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver d, String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)d;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest="./Screenshot/"+screenshotName+System.currentTimeMillis()+".png";
		try
		{
			FileUtils.copyFile(src, new File(dest));
			
		}
		catch(IOException e)
		{
			System.out.println("Exception : failed to take screenshot"+ e.getMessage());
		}
		return dest;
	}
}
