package com.seller;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.main.TestBase;

import junit.framework.Assert;

public class Seller {
	
	static Logger log = Logger.getLogger(Seller.class);
	
	 WebDriver driver;
	 TestBase testbase;
	 
	 public Seller(WebDriver driver){
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 testbase= new TestBase();
	 }

	
	 
	 
	
	public  void sellerLogin(String a ,String b) throws Throwable
	{
		
	
		WebElement sellerLink = driver.findElement(By.xpath("/html/body/a[2]"));
		sellerLink.click();
		String loginPageTitle = driver.getTitle();
	    log.info(loginPageTitle);
	    Assert.assertEquals("Login Page", loginPageTitle);
	    WebElement sellerPhone = driver.findElement(By.name("user.name"));
		sellerPhone.sendKeys(a);
		
		WebElement sellerAddress = driver.findElement(By.name("user.password"));
		sellerAddress.sendKeys(b);
		
		WebElement LoginSubmit = driver.findElement(By.name("submit"));
		LoginSubmit.click();
		 Thread.sleep(2000);
		 String SelleropenPageTitle = driver.getTitle();
		 log.info(SelleropenPageTitle);
		  Assert.assertEquals("Seller OpenPage", SelleropenPageTitle);
		  Thread.sleep(2000);
	}
	
	
	public  void sellerCloseBid() throws Throwable
	{
		driver.findElement(By.name("button")).click();
		 Thread.sleep(2000);
	}
	
	
	public  void sellerAddItems(String arg1,String arg2) throws Throwable
	{
	
		 
		 Thread.sleep(2000);
			WebElement itemname = driver.findElement(By.name("item.itemname"));
			itemname.sendKeys(arg1);
			
			WebElement itemprice = driver.findElement(By.name("item.itemprice"));
			itemprice.sendKeys(arg2);
			
			WebElement Submit = driver.findElement(By.name("go"));
			Submit.click();
			
		String successPageTitle	= driver.getTitle();
		Thread.sleep(2000);
		 log.info(successPageTitle);
		Assert.assertEquals("success Page", successPageTitle);

		 String successMsg = driver.findElement(By.xpath("/html/body/h1")).getText();
		 log.info(successMsg);

		driver.findElement(By.xpath("/html/body/a")).click();  // returns to home page

	}
	
	
	
	
}
