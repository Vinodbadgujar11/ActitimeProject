package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.Generic.Library.FileLibrary;
import com.Actitime.Generic.Library.HomePage;
import com.Actitime.Generic.Library.baseClass;
import com.Actitime.POM.TaskPage;

public class CreateCustomer extends baseClass{
     FileLibrary fil=new FileLibrary();
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
			
    HomePage hp=new HomePage(driver);
    hp.getTasklnk().click();
    TaskPage tp = new TaskPage(driver);
    Thread.sleep(5000);
    String custname = fil.readDataFromExelFile("Sheet1", 1, 1);
    Thread.sleep(5000);
    String custdescr = fil.readDataFromExelFile("Sheet1", 2, 2);
    tp.completeTask(custname, custdescr);
    String expectedtitle = custname;
     String actualtitle = driver.findElement(By.xpath("//div[@title='"+custname+"']")).getText();
    SoftAssert s=new SoftAssert();
    s.assertEquals(expectedtitle, actualtitle);
    Reporter.log("pass",true);
    s.assertAll();
}
	}
