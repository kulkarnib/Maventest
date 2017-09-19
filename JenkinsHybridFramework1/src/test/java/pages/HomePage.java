package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {
	
	WebDriver d;
	public HomePage()
	{
		this.d=LoginPage.d;
	}
	
	//@FindBy(xpath=".//*[@id='moduleList']/ul/li[3]/span[2]") WebElement Sales;
	By Sales=By.xpath(".//*[@id='moduleList']/ul/li[3]/span[2]");
	By Leads=By.xpath(".//*[@id='moduleTab_1_Leads']");
    //@FindBy(xpath=".//*[@id='moduleTab_1_Leads']") WebElement Leads;
	By SearchLeads=By.xpath(".//*[@id='content']/div[1]/h2");
	
	
	
	public void clickOnSales() throws InterruptedException
	{
		//WebElement ele = HomePage.element(Sales);
		
		WebDriverWait wait=new WebDriverWait(d,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		ele.click();
		System.out.println("sales is here");
		WebElement ele1=wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		ele1.click();
		System.out.println("lead is here");
		Thread.sleep(3000);
		WebElement ele3=wait.until(ExpectedConditions.presenceOfElementLocated(SearchLeads));
		System.out.println("search lead");
		String text=ele3.getText();
		Assert.assertEquals(text," Search Leads ","lead link is not verified");
		Thread.sleep(3000);
		System.out.println("pass");
	}
	
	
}
  