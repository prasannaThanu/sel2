package Testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.Base;

public class LoginPageTC extends Base {
	
	
	LoginPage LoginPageObj = new LoginPage();
	
	@Test
	public void LoginToBankapp() throws InterruptedException, IOException
	{
		LoginPageObj.BankappLogin();
		System.out.println("12345");
	}

}
