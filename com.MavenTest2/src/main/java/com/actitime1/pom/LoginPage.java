package main.java.com.actitime1.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//input[@id='username']")
	private WebElement UnTbx;
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement PwTbx;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement LoginButton;
	
	public  LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUnTbx() {
		return UnTbx;
	}

	public WebElement getPwTbx() {
		return PwTbx;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
}
