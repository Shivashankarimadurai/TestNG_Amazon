package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class AmazonLogin extends BaseClass{
	public WebDriver driver1;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	private WebElement signinbtn;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement signin1;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement emailbtn;
	
	@FindBy(css="input[type='submit']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//div[contains(text(),'  Enter your email or ')]")
	private WebElement blankEmail;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordbtn;
	
	@FindBy(xpath="//div[contains(text(),'password')]")
	private WebElement blankPasword;
	
	@FindBy(id="signInSubmit")
	private WebElement signin;
	
	@FindBy(xpath = "//span[@class='a-list-item']")
	private WebElement inputError;
		
	public AmazonLogin() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		driver=driver1;
	}

	public AmazonLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		driver=driver1;	
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}
	public WebElement getSignin1() {
		return signin1;
	}
	public WebElement getEmailbtn() {
		return emailbtn;
	}
	public WebElement getContinuebtn() {
		return continuebtn;
	}
	public WebElement getBlankEmail() {
		return blankEmail;
	}
	public WebElement getPasswordbtn() {
		return passwordbtn;
	}
	public WebElement getBlankPasword() {
		return blankPasword;
	}
	public WebElement getSignin() {
		return signin;
	}
		
	public  void launch() {
		launchBrowser("chrome");
	
		
	}
	  	  
	  public boolean validLogIn(ExtentTest extentTest) {

			try {
				implicitwait(30);
				launchUrl(driver, "https://www.amazon.in/", 10);
				clickTheElement(driver, signinbtn,10);
				sendvalues(driver, emailbtn, "ssam072001@gmail.com",10);
				clickTheElement(driver, continuebtn,10);
				sendvalues(driver, passwordbtn, "123456",10);
				clickTheElement(driver, signin,10);
				staticwait(10000);
				String title = driver.getTitle();
				Assert.assertEquals(title,
						"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
				extentTest.log(Status.PASS, "Login Successful");
			} catch (AssertionError e) {
				extentTest.log(Status.FAIL, "Login Failed");

				return false;
			}
			return true;
		}

		public void inValidEmailId() {

			launchUrl(driver, "https://www.amazon.in/",10);
			clickTheElement(driver, signinbtn,10);
			sendvalues(driver, emailbtn, "ssam0720@gmail.com",10);
			clickTheElement(driver, continuebtn,10);
			Assert.assertEquals(inputError.getText(), "We cannot find an account with that email address");
		}

		public void validEmailIdAndInvalidPassword() {

			launchUrl(driver, "https://www.amazon.in/",10);
			clickTheElement(driver, signinbtn,10);
			sendvalues(driver, emailbtn, "ssam072001@gmail.com",10);
			clickTheElement(driver, continuebtn,10);
			sendvalues(driver,passwordbtn, "1234",10);
			clickTheElement(driver,signin,10);
			staticwait(15000);
			Assert.assertEquals(inputError.getText(), "Your password is incorrect");
		}

		public void emailIdWithEmptyText() {

			launchUrl(driver, "https://www.amazon.in/",10);
			clickTheElement(driver, signinbtn,10);
			sendvalues(driver, emailbtn, "",10);
			clickTheElement(driver, continuebtn,10);
			Assert.assertEquals(blankEmail.getText(), "Enter your email or mobile phone number");
		}

		public void validEmailIdWithEmptyPassword() {

			launchUrl(driver, "https://www.amazon.in/",10);
			clickTheElement(driver, signinbtn,10);
			sendvalues(driver, emailbtn, "ssam072001@gmail.com",10);
			clickTheElement(driver, continuebtn,10);
			sendvalues(driver, passwordbtn, "",10);
			clickTheElement(driver, signin,10);
			Assert.assertEquals(blankPasword.getText(), "Enter your password");
		}
	  
	
	

}
