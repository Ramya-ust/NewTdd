package com.verifyTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.main.TestBase;

public class VerifyPageClass {
	
	 WebDriver driver;
	 TestBase testbase;
	 
	 public VerifyPageClass(WebDriver driver){
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 testbase= new TestBase();
	 }

	
	 public String verifyPageTitle()
	 {
		 String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
			return pageTitle;
	 }

}
