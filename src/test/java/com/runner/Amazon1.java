package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.lision.ExtentReport_Test;
import com.pom.AmazonLogin;
import com.pom.Search2;
import com.pom.Search3;
import com.pom.SearchAmazon;
import com.pom.cart;

public class Amazon1 extends BaseClass{
		
	@BeforeTest
	public void getlaunch() {
		launchBrowser("chrome");
		
	}

	@Test(priority = 5)
	public void validLoginTest() {

		ExtentReport_Test.extenttest = extentReports.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Valid email id and password");
		AmazonLogin al = new AmazonLogin(driver);	
		Assert.assertTrue(al.validLogIn(ExtentReport_Test.extenttest));
	}

	@Test(priority = 1)
	public void inValidEmailId() {

		ExtentReport_Test.extenttest = extentReports.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Invalid email id");
		AmazonLogin al = new AmazonLogin(driver);
		al.inValidEmailId();
	}

	@Test(priority = 2)
	public void validEmailIdAndInvalidPassword() {

		ExtentReport_Test.extenttest = extentReports.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Your password is incorrect");
		AmazonLogin al = new AmazonLogin(driver);
		al.validEmailIdAndInvalidPassword();
	}

	@Test(priority = 3)
	public void emailIdWithEmptyText() {
		ExtentReport_Test.extenttest = extentReports.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Enter your email or mobile phone number");
		AmazonLogin al = new AmazonLogin(driver);
		al.emailIdWithEmptyText();
	}

	@Test(priority = 4)
	public void validEmailIdWithEmptyPassword() {
		ExtentReport_Test.extenttest = extentReports.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Enter your password");
		AmazonLogin al = new AmazonLogin(driver);
		al.validEmailIdWithEmptyPassword();
	}
	@Test(priority = 6)
	private void searchProduct() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Search product and displayed product matched");
		SearchAmazon sp1=new SearchAmazon(driver);
		sp1.search();
	
	}

	@Test(priority = 7)
	private void searchProduct2() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports
			.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Search product and displayed product matched");
		Search2 sp2 = new Search2(driver);
		sp2.search2();
	
	}

	@Test(priority = 8)
	private void searchProduct3() throws InterruptedException {
		ExtentReport_Test.extenttest = extentReports.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Search product and displayed product matched");
		Search3 sp3=new Search3(driver);
		sp3.search3();
	}

	@Test(priority = 9)
	private void makePayment() {
		ExtentReport_Test.extenttest = extentReports.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("message has shown for payment fail");
		cart ca=new cart(driver);
		ca.makePayment();
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
