package com.bidder;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.main.TestBase;
import com.seller.Seller;

import junit.framework.Assert;

public class Bidder {
	
	static Logger log = Logger.getLogger(Bidder.class);
	WebDriver driver;
	 TestBase testbase;
	 
	 public Bidder(WebDriver driver){
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 testbase= new TestBase();
	 }
	 
	 public  void bidderVisitsSite() throws Throwable
		{
		 String pageTitle=driver.getTitle();
		 log.info(pageTitle);
			Assert.assertEquals("Welcome To OnlineBidding Application", pageTitle);
		 WebElement bidderLink = driver.findElement(By.xpath("/html/body/a[1]"));
			bidderLink.click();
		 
		}
	 
	 public void bidderentersConttactPage() throws Throwable
	 {
		 Thread.sleep(2000);
		 String contactPageTitle = driver.getTitle();
		 log.info(contactPageTitle);
		    Assert.assertEquals("Bidder Entry page", contactPageTitle);
	 }
	 
	 
	 public void bidderEnterDetails(String username, String email, String phone, String addresss) throws Throwable {
		 Thread.sleep(2000);
		WebElement bidderName = driver.findElement(By.name("userBean.name"));
		bidderName.sendKeys(username);
		
		WebElement bidderEmail = driver.findElement(By.name("userBean.email"));
		bidderEmail.sendKeys(email);
		
		WebElement bidderPhone = driver.findElement(By.name("userBean.phone"));
		bidderPhone.sendKeys(phone);
		
		WebElement bidderAddress = driver.findElement(By.name("userBean.address"));
		bidderAddress.sendKeys(addresss);
		
		WebElement Submit = driver.findElement(By.name("submit"));
		Submit.click();
	 }
	 
	 public void bidderinItemPage() throws Throwable
	 {
		 Thread.sleep(2000);
		 String ItemPageTitle = driver.getTitle();
		 log.info(ItemPageTitle);
		  Assert.assertEquals("Item page", ItemPageTitle);
	 }

	 public void bidderEntersPriceForItem(String arg1) throws Throwable
{
	Thread.sleep(2000);
	WebElement bidderPrice  = driver.findElement(By.name("bid.bidderprice"));
	bidderPrice.sendKeys(arg1);
	
	WebElement BidButton = driver.findElement(By.name("addbid"));
	BidButton.click();
}
	 
	 public void bidderSuccessPage() throws Throwable
	 { 
	 Thread.sleep(2000);
	 String SuccessTitle = driver.getTitle();
	 log.info(SuccessTitle);
	  Assert.assertEquals("Bid Success", SuccessTitle);
	  
	 String successMsg = driver.findElement(By.xpath("/html/body/h1")).getText();
    System.out.println(successMsg);
    
    
    driver.findElement(By.xpath("/html/body/a")).click(); // click on homepage link
	 
	 }
}
