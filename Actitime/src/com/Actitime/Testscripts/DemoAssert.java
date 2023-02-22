package com.Actitime.Testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoAssert {

	 @Test
	 public void demoassertion() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.com/");
		 String expectedtitle = "doogle";
		 String actualtitle = driver.getTitle();
		 if (expectedtitle.equals(actualtitle)) {
			System.out.println("title is matching");
		} else {
          System.out.println("title is not matching");
		}
       driver.close();
}
}