package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private ElementUtil elementutil;
	private WebDriver driver;
	
	
	
	//Page Objects--By locators--Object Repository
	private By username= By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwd=By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private By registerLink=By.linkText("Register");
	
	//constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil= new ElementUtil(driver);
		
	}
	
	//Page Actions
	
	public String getLoginPageTitle() {
		return elementutil.waitForTitleIs(5, Constants.LOGIN_PAGE_TITLE);
		

	}
	
	public boolean isForgotPwdLinkExist() {
		return elementutil.doIsDisplayed(forgotPwd);
		
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " : " + pwd);
		elementutil.doSendKeys(username, un);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(loginButton);
		return new AccountsPage(driver);
		
	}
	
	public RegisterPage navigateToRegisterPage() {
		elementutil.doClick(registerLink);
		return new RegisterPage(driver);
		
	}
}
