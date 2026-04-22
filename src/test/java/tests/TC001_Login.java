package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test
	public void login_logic() {
		
		//Login
		logger.info("Starting login process");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUsername(p.getProperty("Username"));
		lpg.enterPassword(p.getProperty("Password"));
		lpg.clickLogin();
		
		boolean targetPage=lpg.getConfirmationMsg();
		Assert.assertTrue(targetPage);
		logger.info("Login action completed");
	
		
	}
	
	

}
