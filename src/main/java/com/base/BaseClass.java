package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {
	
		public static WebDriver driver;
		protected static ExtentReports extentReports;
		private static File file;	

	public static WebDriver launchBrowser(String browsername) {
			if(browsername.equalsIgnoreCase("Chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("incognito");
				driver = new ChromeDriver();
			}else if(browsername.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();
			}else if(browsername.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			return driver;		
		}
		
	protected void launchUrl(WebDriver driver,String url,int sec) {
		 try {						
			 driver.get(url);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			System.out.println("Error in launch URl method");
			e.printStackTrace();
		}
		
	 }

		
	public static void clickTheElement(WebDriver driver, WebElement element, int sec) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
			element.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		protected void sendvalues(WebDriver driver,WebElement element,String value,int sec) {
	        	try {
					new WebDriverWait(driver,Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
					element.sendKeys(value);
				} catch (Exception e) {
					System.out.println("we cannot send values to sendvalues method");
					e.printStackTrace();
				}
	    }

		protected void selectdragdown(WebElement element,String option,String Value) {
		       try {
		    	   Select s=new Select(element);
		    	   if(option.equalsIgnoreCase("Index")){
		    		   s.selectByIndex(Integer.parseInt(Value));
					   }else if(option.equalsIgnoreCase("Value")){
					        s.selectByValue(Value);
					    }else if(option.equalsIgnoreCase("text")){
					        s.selectByVisibleText(Value);
					    }
				} catch (NumberFormatException e) {
					System.out.println("Error in selecting dropdown");
					e.printStackTrace();
				}
		}
		
		public static void windowhandles(WebDriver driver,int index) {
    		Set<String> allid = driver.getWindowHandles();
    		List<String>id=new ArrayList<String>(allid);
    		driver.switchTo().window(id.get(index));
		}	 
		
		public static void clickButton(WebElement element) {
			element.click();
		}

		public  static void inputvalues(WebDriver driver, WebElement element, int sec, String value) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(value);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void passInput(WebElement element, String input){
			element.sendKeys(input);
		}	
		
		public static void gettitle(String test) {
			System.out.println(driver.getTitle());
		}
		
		public static void getTex(WebElement element) {
			String text = element.getText();
			System.out.println(text);
		}
		
		public static Actions actionObj(){
			Actions as = new Actions(driver);
			return as;
		}
		public void JSFindElement(WebElement element) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);
		}

		public void JSScrollBy(int dist) {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0," + dist + ");", "");

		}

		public void clearText(WebElement element) {

			element.clear();
		}
		
		protected void closeTab() {
			driver.close();
		}


		
			
		public  void staticwait(int sec) {
			try {
				Thread.sleep(sec);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void implicitwait(int sec) {
			try {
				Thread.sleep(sec);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public  String takeScreenshot() throws IOException{
    		TakesScreenshot screenshot = (TakesScreenshot)driver;
    		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
    		File desfile = new File("C:\\Users\\Happy\\eclipse-workspace\\Amazon\\screenshot\\" +  "_" + timeStamp + ".png");
    		FileUtils.copyFile(scrfile, desfile);
    		return desfile.getAbsolutePath();
        }
    			
		public static String fullScreenshot(String location) throws IOException {
			Screenshot take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(take.getImage(), "PNG", new File(location));
			return location;
		}
		
		public void extentReportStart(String location) {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		
		public void extentReportTearDown(String location) throws IOException {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
		}
		
		public void scroll(String suw, WebElement element){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(suw, element);
		}
		public static void getcurrenturl() {
			System.out.println(driver.getCurrentUrl());
		}
		
		public static void navigateto(String url) {
			driver.navigate().to(url);
		}
			
		public static void backPage(WebElement element) {
			driver.navigate().back();
		}
		
		public void reFresh(WebElement element) {
			driver.navigate().refresh();
		} 
		
		public void RadioButton(WebElement element) {
			element.click();
		}
		
		public void alertaccept() {
			Alert a= driver.switchTo().alert();
			a.accept();
		}
		
		public void alertdismiss() {
			Alert a= driver.switchTo().alert();
			a.dismiss();
		}
		
		public static void dropdown(WebElement element, String option, String value) {		
			try {
				Select s = new Select(element);
				if(option.equalsIgnoreCase("index")) {
					s.selectByIndex(Integer.parseInt(value));
				}else if(option.equalsIgnoreCase("value")) {
					s.selectByValue(value);
				}else if(option.equalsIgnoreCase("VisibilityText")) {
					s.selectByVisibleText(value);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void frameByIndex(int index) {

    		driver.switchTo().frame(index);
    	}

		public void terminateBrowser() {
			driver.quit();
		}
		
}




