package com.selenium.basics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Assignemet extends Base{
	

		
		
		
		public static void main(String[] args) throws InterruptedException {
			
//			//1. Open the Browser
//			openBrowser("Chrome");
//			
//			//2. Navigate to the URL 
//			driver.get("https://www.google.com");
//			
//			//3. Enter Text in Search Box
//			//3.1 Find Search Box
//			WebElement searchbox = driver.findElement(By.name("q"));	
//			
//			//3.2 Enter Text in it
//			searchbox.sendKeys("Selenium"); //The text "Selenium" is called Test Data
//			
//			//4. Hit Enter Key
//			searchbox.sendKeys(Keys.ENTER);
//			
//			Thread.sleep(5000);
			
			
			
			
			
			openBrowser("Chrome");
			
			driver.get("http://google.com");
			
			//1. Get the Company Names from the Table
			//1.1 - Get the Table in List
			//1.2 - Get Company names from the List
			
			List<WebElement> companynames = driver.findElements(By.xpath("//li[class='sbai JCHpcb']/spam"));
		
			
			System.out.println(companynames);
}}
	
