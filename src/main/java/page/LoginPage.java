package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library:
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	WebElement LoginUserName;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	WebElement LoginPassword;
	
	@FindBy(how=How.XPATH,using="//button[@name='login']")
	WebElement SignInButton;
	
	
	public void LoginTest(String LoginEmail, String Passcode) {
		LoginUserName.sendKeys(LoginEmail);
		LoginPassword.sendKeys(Passcode);
		SignInButton.click();
		
	}
}
