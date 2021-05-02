package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	WebDriver driver;
	ElementUtil elementutil;
	
	private By firtsname= By.id("input-firstname");
	private By lastname=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmpassword= By.id("input-confirm");
	
	private By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	
	private By agreeCheckBox=By.name("agree");
	private By continueButton=By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMessage=By.cssSelector("div#content h1");
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
		
	}
	
	public boolean accountRegistration(String firstName,String lastName, String email,String telephone,
									String password,String subscribe ) {
		elementutil.doSendKeys(this.firtsname, firstName);
		elementutil.doSendKeys(this.lastname, lastName);
		elementutil.doSendKeys(this.email, email);
		elementutil.doSendKeys(this.telephone, telephone);
		elementutil.doSendKeys(this.password, password);
		elementutil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")) {
			elementutil.doClick(this.subscribeYes);
		}else {
			elementutil.doClick(this.subscribeNo);
		}
		elementutil.doClick(this.agreeCheckBox);
		elementutil.doClick(this.continueButton);
		
		elementutil.waitForPresenceOfElement(this.successMessage, 5);
		
		String msg= elementutil.doGetElementText(successMessage);
		System.out.println("account creation:" +msg);
		if(msg.contains(Constants.ACCOUNT_CREATION_SUCCESS_MESSAGE)) {
			elementutil.doClick(logoutLink);
			elementutil.doClick(registerLink);
			return true;
		}else
		{
			return false;
		}
			
		
	}
	
	
			

}
