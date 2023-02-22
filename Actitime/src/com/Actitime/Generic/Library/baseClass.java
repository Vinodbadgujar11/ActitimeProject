package com.Actitime.Generic.Library;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.LoginPage;

public class baseClass {
	FileLibrary f=new FileLibrary();
  public static WebDriver driver;
  
  @BeforeSuite
  public void databaseconnection() {
	  Reporter.log("database connection",true);
  }
  @AfterSuite
  public void databasedisconnected() {
	  Reporter.log("database disconnected",true);
  }
  @BeforeClass
  public void openbrowser() throws IOException {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String url = f.readDataFromPropertyFile("url");
	  driver.get(url);
	  Reporter.log("open browser succesfully",true);
  }
  @AfterClass
  public void closebrowser() {
	  driver.close();
	  Reporter.log("browser is closed",true);
  }
  @BeforeMethod
  public void loginToActitime() throws IOException {
	 String UN = f.readDataFromPropertyFile("username");
	 String pwd = f.readDataFromPropertyFile("password");
	 LoginPage lp=new LoginPage(driver);
	 lp.login(UN, pwd);
	// driver.findElement(By.id("username")).sendKeys(UN);
	 //driver.findElement(By.name("pwd")).sendKeys(pwd);
	 //driver.findElement(By.xpath("//div[.='Login ']")).click();
	 Reporter.log("login succesfully",true);	 
  }
  @AfterMethod
  public void logoutFromActitime() throws InterruptedException {
	 Thread.sleep(5000); 
	 HomePage hp= new HomePage(driver);
	 hp.getLgoutlnk().click();
	 //driver.findElement(By.id("logoutLink")).click();
	 Reporter.log("logout succesfully",true);
  }
}
