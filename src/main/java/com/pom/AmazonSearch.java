package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class AmazonSearch extends BaseClass{
	
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement product1;

	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement cartBtn;

	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	private WebElement addCart;

	@FindBy(xpath = "(//div[@class='a-row'])[1]")
	private WebElement noResultproduct;

	@FindBy(className = "s-no-outline")
	private WebElement invalidName;

	@FindBy(xpath = "(//div[@class='a-row'])[1]")
	private WebElement noResultMsg;

	// constructor
	public AmazonSearch(WebDriver driver1) {

		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	public void searchProduct1() {

		implicitwait(30);
		clickButton(searchBox);
		passInput(searchBox, "lenovo ideapad slim 5");
		clickButton(searchBtn);
		clickButton(product1);
		staticwait(5000);
		windowhandles(driver,1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticwait(5000);
		clickButton(addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.in Shopping Cart");
		searchBox.clear();
		windowhandles(driver,0);
	}

	public void searchProduct2() {

		implicitwait(30);		
		clickButton(searchBox);
		passInput(searchBox, "samsung s24 ultra 5g");
		clickButton(searchBtn);
		clickButton(product1);
		staticwait(5000);
		windowhandles(driver,1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticwait(5000);
		clickButton(addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.in Shopping Cart");
		searchBox.clear();
		windowhandles(driver,0);
	}

	public void searchProduct3() {

		implicitwait(30);
		clickButton(searchBox);
		passInput(searchBox, "google pixel 8 pro");
		clickButton(searchBtn);
		clickButton(product1);
		staticwait(5000);
		windowhandles(driver,1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticwait(5000);
		clickButton(addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.in Shopping Cart");

	}

	public void searchProductWithInvalidName() {

		implicitwait(30);
		clickButton( searchBox);
		passInput(searchBox, "qwertgdseryqwedsawfg");
		clickButton(searchBtn);
		Assert.assertEquals(noResultMsg.getText(), "No results for qwertgdseryqwedsawfg.");

	}


}
