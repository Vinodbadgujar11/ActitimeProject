package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
  
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement newcustname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesc;
	
	@FindBy(xpath = "(//div[@class='dropdownButton'])[15]")
	private WebElement dropdownbtn;
	
	//@FindBy(xpath = "(//div[.='Our company'])[3]")
	//private WebElement ourcomp;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcust;

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getNewcustname() {
		return newcustname;
	}

	public WebElement getCustdesc() {
		return custdesc;
	}

	public WebElement getDropdownbtn() {
		return dropdownbtn;
	}

	//public WebElement getOurcomp() {
		//return ourcomp;
	

	public WebElement getCreatecust() {
		return createcust;
	}
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//business logic or generic method
	public void completeTask(String Customername ,String Description) {
		addnewbtn.click();
		newcust.click();
		newcustname.sendKeys(Customername);
		custdesc.sendKeys(Description);
		dropdownbtn.click();
		//ourcomp.click();
		createcust.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
