package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.lision.ExtentReport_Test;
import com.lision.ITestListenerClass;
import com.pom.AmazonLogin;
import com.pom.AmazonPayment;
import com.pom.AmazonSearch;

@Listeners(ITestListenerClass.class)
public class Amazon extends BaseClass{
	public static WebDriver driver;

	@BeforeTest
	public static void setUp() {

		driver = BaseClass.launchBrowser("chrome");

	}

	@Test(priority = 5)
	public void validLoginTest() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid email id and password");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		Assert.assertTrue(amazonLogin.validLogIn(ExtentReport_Test.extenttest));
	}

	@Test(priority = 1)
	public void inValidEmailId() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Invalid email id");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.inValidEmailId();
	}

	@Test(priority = 2)
	public void validEmailIdAndInvalidPassword() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Your password is incorrect");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.validEmailIdAndInvalidPassword();
	}

	@Test(priority = 3)
	public void emailIdWithEmptyText() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Enter your email or mobile phone number");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.emailIdWithEmptyText();
	}

	@Test(priority = 4)
	public void validEmailIdWithEmptyPassword() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Enter your password");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.validEmailIdWithEmptyPassword();
	}

	@Test(priority = 6)
	private void searchProduct() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct1();
	}

	@Test(priority = 7)
	private void searchProduct2() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct2();
	}

	@Test(priority = 8)
	private void searchProduct3() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct3();
	}

	@Test(priority = 9)
	private void searchProductWithInvalidName() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("No result displayed for invalid name");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProductWithInvalidName();
	}

	@Test(priority = 10)
	private void makePayment() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " : " + Thread
				.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("message has shown for payment fail");
		AmazonPayment amazonPayment=new AmazonPayment(driver);
		amazonPayment.makePayment();
	}

	@AfterTest
	public void BrowserClose() {

		terminateBrowser();
	}



	@BeforeSuite
	private void extentReportStartUp() {
		extentReportStart("C:\\Users\\Happy\\eclipse-workspace\\Amazon\\Report");
	}

	@AfterSuite
	private void extentReportEnd() throws IOException {
		extentReportTearDown("C:\\Users\\Happy\\eclipse-workspace\\Amazon\\Report\\index.html");
	}

}
