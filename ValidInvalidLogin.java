package com.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidInvalidLogin {
	public static String Username;
	public static String Password;
	public static String EmailError;
	public static String PassError;
	public static String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			if(i==1) {
				//valid input
				Username="rajashreem127@gmail.com";
				Password="Password@123";
			}
			else if(i==2) {
				//non-existent email ID
				Username="exampledemo@gmail.com";
				Password="pass@1234";
			}
			else if(i==3) {
				//invalid username
				Username="";
				Password="Pass@123";
			}
			else if(i==4) {
				//invalid password
				Username="meet_rajashree123@rediffmail.com";
				Password="";
			}
			else {
				//username regex does not match
				Username="meet_rajashree123";
				Password="Pass@123";
			}
			
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver.exe"); 
		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
		  driver.get("https://www.facebook.com/"); 
		  driver.findElement(By.id("email")).sendKeys(Username); 
		  driver.findElement(By.id("pass")).sendKeys(Password); 
		  WebElement login=driver.findElement(By.id("loginbutton")); 
		  
		  login.click(); 
		  /*WebElement ele = driver.findElement(By.id("email"));
		  boolean res=ele.getAttribute(Username).matches(regex);*/
		  String actualUrl="https://www.facebook.com/"; 
		  String expectedUrl= driver.getCurrentUrl(); 
		  if(!expectedUrl.equals(actualUrl)) {
			  EmailError=driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText();
		  }
		  if(!expectedUrl.equals(actualUrl)) {
			  PassError=driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText();
		  }
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
			  System.out.println("Test passed: Login successful"); 
		  } 
		  else if(!actualUrl.equalsIgnoreCase(expectedUrl)&& EmailError.contains("The email address or phone number that you've entered doesn't match any account. ")) {
			  System.out.println("Test passed: Login unsuccessful with incorrect email warning."); 
		  }
		  else if(!actualUrl.equalsIgnoreCase(expectedUrl)&& PassError.contains("The password that you've entered is incorrect. ")) {
			  System.out.println("Test passed: Login unsuccessful with incorrect password warning."); 
		  }	
		  /*else if(!actualUrl.equalsIgnoreCase(expectedUrl)&& res==false) {
			  System.out.println("Test passed: Login unsuccessful with 'invalid email ID entered' warning."); 
		  }*/
		  else { 
			  System.out.println("Test failed: Login unsuccessful"); 
		  }  
		  driver.close();
	 }
	}		

	
}
