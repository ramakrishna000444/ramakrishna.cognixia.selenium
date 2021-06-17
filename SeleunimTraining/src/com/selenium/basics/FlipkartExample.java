package com.selenium.basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FlipkartExample  extends Base{ 
	

	
	

		public static void main(String[] args) throws InterruptedException {
			
			openBrowser("Chrome");
			
			driver.get("https://www.flipkart.com");
			
			//Click on the Cross button of the popup to dismiss it
			WebElement parent = driver.findElement(By.className("_2QfC02"));
			WebElement child = parent.findElement(By.tagName("button"));
			child.click();
			
			//Another way of clicking on the button
//			List<WebElement> all_buttons = driver.findElements(By.tagName("button"));
//			
//			for (WebElement button : all_buttons) {
//				if(button.getText().equals("x")) {
//					button.click();
//				}
//			}
			
			String searchstring = "iphone";
			
			driver.findElement(By.name("q")).sendKeys(searchstring);
			
			driver.findElement(By.name("q")).submit();
			
			Thread.sleep(2000);
			
			String text = driver.findElement(By.className("_10Ermr")).getText();
			
			int startingindex = text.indexOf("of");
			int endingindex = text.indexOf("results");
			
			String numberofitems = text.substring(startingindex+2, endingindex-1);
			
			System.out.println("No. of iphone in inventory are: "+numberofitems);
		

	}
}


