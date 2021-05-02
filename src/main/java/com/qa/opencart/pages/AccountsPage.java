package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	ElementUtil elementutil;
	private WebDriver driver;
	
	private By logo= By.cssSelector("#logo");
	private By AccHeaders= By.xpath("//div[@id='content']/h2");
	private By searchField= By.name("search");
	private By searchButton= By.cssSelector("div #search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	public boolean isLogoExist() {
		return elementutil.doIsDisplayed(logo);
	}
	public String getAccPageTitle() {
		return elementutil.waitForTitleIs(5,Constants.ACC_PAGE_TITLE);
		
	}
	
	public int getAccountPageHeadersCount() {
		return elementutil.getElements(AccHeaders).size();
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> accList= elementutil.getElements(AccHeaders);
		List<String> accSectionList = new ArrayList<String>();
		
		for(WebElement e: accList) {
			accSectionList.add(e.getText());	
		}
		return accSectionList;
	}
	
	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching dor the product: " + productName);
		elementutil.doSendKeys(searchField, productName);
		elementutil.doClick(searchButton);
		return new SearchResultPage(driver);
	}

}
