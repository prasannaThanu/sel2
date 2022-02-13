package PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Utilities.Base;
import Utilities.CommonMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends Base{
	
	CommonMethods CommonMethodsObj=new CommonMethods();

	public WebElement UsernameTextFieldElement()
	{
		WebElement	UsernameTextFieldElement=driver.findElement(By.xpath("//*[@name='uid']"));
		return UsernameTextFieldElement;
	}
	
	public WebElement PasswordTextFieldElement()
	{
		WebElement	PasswordTextFieldElement=driver.findElement(By.xpath("//*[@name='password']"));
		return PasswordTextFieldElement;
	}
	
	public WebElement LoginButton()
	{
		WebElement	PasswordTextFieldElement=driver.findElement(By.xpath("//*[@name='btnLogin']"));
		return PasswordTextFieldElement;
	}
	public void BankappLogin() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		test.log(Status.PASS, "Successfully Logged In");
		UsernameTextFieldElement().sendKeys(credentials.getProperty("UserName"));
		PasswordTextFieldElement().sendKeys("ApusUmY");
		LoginButton().click();
		String SC= CommonMethodsObj.TakeScreenshot("Screenshot");
		
		test.error("Failed", MediaEntityBuilder.createScreenCaptureFromPath("." + SC).build());
		
		test.log(Status.PASS, "Successfully Logged In");
	}
	
	//trycatch block
	
}
