package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class cart extends BaseClass{
public WebDriver driver;
	

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	private WebElement cartPage;

	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proceedToPay;

	@FindBy(xpath = "//input[@data-testid='Address_selectShipToThisAddress']")
	private WebElement useThisAddress;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement paymentMethod;

	@FindBy(xpath = "(//a[contains(text(),'Enter card details')])[1]")
	private WebElement enterCardDetails;

	@FindBy(xpath = "//input[@class='a-input-text a-form-normal a-width-large a-span9 pmts-claim-code']")
	private WebElement cardNumber;

	@FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	private WebElement clickEnter;

	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	private WebElement errorMassage;
	
	
	
	//constructor
	public cart(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCartPage() {
		return cartPage;
	}

	public WebElement getProceedToPay() {
		return proceedToPay;
	}

	public WebElement getUseThisAddress() {
		return useThisAddress;
	}

	public WebElement getPaymentMethod() {
		return paymentMethod;
	}
	
	public WebElement getEnterCardDetails() {
		return enterCardDetails;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getClickEnter() {
		return clickEnter;
	}

	public WebElement getErrorMassage() {
		return errorMassage;
	}
	public void makePayment(){		
		implicitwait(10);
		clickTheElement(driver, cartPage,10);
		clickTheElement(driver, proceedToPay,10);
		clickTheElement(driver, useThisAddress,10);
		staticwait(5000);
		clickTheElement(driver, paymentMethod, 10);
		clickTheElement(driver, enterCardDetails,10);
		staticwait(5000);
		frameByIndex(0);
		sendvalues(driver, cardNumber, "1543 24345 8976",10);
		clickTheElement(driver, clickEnter,10);
		Assert.assertEquals(errorMassage.getText(), "There was a problem.");
				
	}

	

		
	
}
