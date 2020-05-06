package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bidder.Bidder;
import com.main.TestBase;
import com.seller.Seller;
import com.verifyTitle.VerifyPageClass;

import junit.framework.Assert;

public class SellerBidderTest {
	
	WebDriver driver;
	Seller seller;
	Bidder bidder;
	TestBase testbase;
	VerifyPageClass verifytitle;
	
	@BeforeMethod
	public  void openBrowser()
	{
		testbase= new TestBase();
		System.setProperty("webdriver.chrome.driver", testbase.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(testbase.getImplicitlyWait(), TimeUnit.SECONDS);
		String uri = testbase.getApplicationUrl();
		driver.get(uri);
		
	}
	
	@Test
	public void verifyPageTitle()
	{
		verifytitle=new VerifyPageClass(driver);
	String title = 	verifytitle.verifyPageTitle();
	Assert.assertEquals("Welcome To OnlineBidding Application", title);	
	}
	
	@Test(priority=1)
	public  void sellerSide() throws Throwable
	{
		seller = new Seller(driver);
		seller.sellerLogin("admin", "admin");
		seller.sellerCloseBid();
		seller.sellerAddItems("watch", "100");
		
	}
	
	
	@Test(priority=2,dependsOnMethods="sellerSide")
	public  void bidderSide() throws Throwable
	{
		bidder= new Bidder(driver);
		bidder.bidderVisitsSite();
		bidder.bidderentersConttactPage();
		bidder.bidderEnterDetails("man", "nam@man.com", "12132", "234ertr");
		bidder.bidderinItemPage();
		bidder.bidderEntersPriceForItem("145");
		bidder.bidderSuccessPage();
	}
	
	@AfterMethod
	public  void closeBrowser()
	{
		driver.close();
	}

}
