package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {
	
	public static WebDriver d;
	public LoginPage(WebDriver ldriver)
	{
		this.d=ldriver;    //initialize driver
	}
	@FindBy(xpath=".//*[@id='user_name']") WebElement userName;
	@FindBy(xpath=".//*[@id='user_password']") WebElement password; 
	@FindBy(xpath=".//*[@id='login_button']") WebElement loginButton; 
	By logout=By.xpath(".//*[@id='logout_link']");  //logout
	
	public void loginApplication(String user,String pass)
	{
		//method to login into application
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	//to get the application title
	public String getApplicationTitle()
	{
		return d.getTitle();
	}
	
	public void verifyLogOutLink()
	{
	
		//smart wait or dynamic wait wait for max 20sec till the object 
		WebDriverWait wait=new WebDriverWait(d,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(logout));
		String text=ele.getText();
		Assert.assertEquals(text, "Log Out","logout link is not verified");
		//compares the containt in (text) with (logout) if it fails then display msg
		System.out.println("end");
	}

}



