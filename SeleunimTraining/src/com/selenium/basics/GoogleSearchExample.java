package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearchExample extends Base {

	
	
	
		public static void main(String[] args) throws InterruptedException {
			
			//1. Open the Browser
			openBrowser("Chrome");
			
			//2. Navigate to the URL 
			driver.get("https://www.google.com");
			
			//3. Enter Text in Search Box
			//3.1 Find Search Box
			WebElement searchbox = driver.findElement(By.name("q"));	
			
			//3.2 Enter Text in it
			searchbox.sendKeys("Selenium"); //The text "Selenium" is called Test Data
			
			//4. Hit Enter Key
			searchbox.sendKeys(Keys.ENTER);
			
			Thread.sleep(5000);
			
			//5. Verify that Search results are displayed
			String actual = driver.getTitle();
			String expected = "Selenium";
			
			System.out.println("Title is: "+actual);
			
			if(actual.contains(expected)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
				System.out.println("Title is: "+actual);
			}
			
			//XPATH - Internally can use any attribute
			//CSS Selectors - Internally can use any attribute
			
		}

	}
