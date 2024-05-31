package com.lision;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;

public class ExtentReport_Test extends BaseClass{
			
		public static ExtentTest extenttest;	
		@BeforeSuite
		public void extentReportStartUp() {			
			extentReportStart(null);
		}
		@AfterSuite
		public void extentReportEnd() throws IOException {			
			extentReportTearDown(null);
		}	
		

}
