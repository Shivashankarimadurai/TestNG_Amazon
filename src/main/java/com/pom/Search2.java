package com.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Search2 extends BaseClass{
	public WebDriver driver2;
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchbox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchicon;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement product1;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addcart;
	@FindBy(xpath="(//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce'])[1]")
	private WebElement cart;


	public Search2(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		driver=driver2;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchicon() {
		return searchicon;
	}
	public WebElement getproduct1() {
		return product1;
	}
	public WebElement getaddcart() {
		return addcart;
	}
	public WebElement getcart() {
		return cart;
	}
	public void search2() {
		clickTheElement(driver, searchbox, 10);
		sendvalues(driver, searchbox, "boat earphones", 10);
		clickTheElement(driver,searchicon,10);
		clickTheElement(driver, product1, 10);
		windowhandles(driver,1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		js.executeScript("arguments[0].click();", addcart);
		staticwait(2000);
		clickTheElement(driver, cart, 10);
		driver.close();
		windowhandles(driver, 0);
		searchbox.clear();
	}



}
