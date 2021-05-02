package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@Test
	public void setupRegister() {
		registerPage= loginpage.navigateToRegisterPage();
		
	}
	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider="getRegisterData")
	public void userRegisterTest(String firstname, String lastname,String email,String telephone, String password,String subscribe) {
		Assert.assertTrue(registerPage.accountRegistration
		(firstname, lastname, email, telephone, password, subscribe),Error.REGISTER_FAILD_MESSG);
	}
	
	

}
