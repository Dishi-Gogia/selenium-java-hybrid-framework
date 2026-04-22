package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseClass;

public class LoginPage extends BasePage{
	
	// Logger for this page
    Logger logger = LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtusername;
	
	@FindBy (xpath="//input[@name='password']")
	WebElement txtpassword;
	
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    
    @FindBy (xpath="//*[@id=\"app\"]//span/h6")
    WebElement msgConfirmation;
	
    public void enterUsername(String username) {
    	logger.info("Entering username: " + username);
    	txtusername.clear();
    	txtusername.sendKeys(username);
    }

    public void enterPassword(String password) {
    	 logger.info("Entering password");
    	txtpassword.clear();
    	txtpassword.sendKeys(password);
    }

    public void clickLogin() {
    	logger.info("Clicking Login button");
        btnLogin.click();
    }
    
    public boolean getConfirmationMsg() {
    	try {
    		return(msgConfirmation.isDisplayed());
    	}catch(Exception e) {
    		return false;
    		
    	}
    }
}
