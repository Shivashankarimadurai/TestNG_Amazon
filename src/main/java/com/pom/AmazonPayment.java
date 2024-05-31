package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class AmazonPayment extends BaseClass{
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

	@FindBy(xpath = "//input[@name='addCreditCardNumber']")
	private WebElement cardNumber;

	@FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	private WebElement clickEnter;

	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	private WebElement errorMassage;
	
	
	
	//constructor
	public AmazonPayment(WebDriver driver1) {

		this.driver = driver1;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void makePayment(){
		
		implicitwait(30);
		clickButton(cartPage);
		clickButton( proceedToPay);
		clickButton(useThisAddress);
		staticwait(5000);
		clickButton(paymentMethod);
		clickButton(enterCardDetails);
		staticwait(5000);
		frameByIndex(0);
		passInput(cardNumber, "6543 2456 76");
		clickButton(clickEnter);
		Assert.assertEquals(errorMassage.getText(), "There was a problem.");
		
		
		
	}

}
