package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	ElementUtil elementutil;
	private WebDriver driver;
	
	By searchItemResult= By.cssSelector("div.product-layout div.product-thumb");
	By searchItems= By.cssSelector("div.product-thumb h4 a");
	
	public  SearchResultPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
		
	}
	
	public int getProductResultsCount() {
		 return elementutil.getElements(searchItemResult).size();
	}
	
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemsList= elementutil.getElements(searchItems);
		System.out.println("total number of items displayed : " + productName + " : " + resultItemsList.size());
		for (WebElement e: resultItemsList) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}	
		}
		return new ProductInfoPage(driver);
		
	}
	
	
	
	
}
