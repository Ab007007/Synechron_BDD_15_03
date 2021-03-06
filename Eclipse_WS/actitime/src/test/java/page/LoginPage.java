package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	static String USERNAME_ID = "username";
	
	@FindBy(id = "username")
	WebElement usernameTxtBox;
	
	@FindBy(name = "pwd")
	WebElement passwordTxtBox;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	
	public void enterUsername(String un)
	{
		usernameTxtBox.sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		passwordTxtBox.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
	}
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
}
