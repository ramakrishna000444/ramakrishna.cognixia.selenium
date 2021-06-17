package com.selenium.basics;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipkartSearch  extends Base{

	public static void main(String[] args) throws InterruptedException {
		
		openBrowser("Chrome");
		
		//1. Going to destination file
		
		driver.get("http://www.flipkart.com");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement parent = driver.findElement(By.className("_2QfC02"));
		WebElement child = parent.findElement(By.tagName("button"));
		child.click();
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		String keyWord= "samsung";
	
		
		searchbox.sendKeys(keyWord);
		
		WebElement e = driver.findElement(By.xpath("//li[@class='Y5N33s']//a[@class='_3izBDY']/div[2]"));
		
		//Explicit Wait
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		
		myWait.until(ExpectedConditions.textToBePresentInElement(e, keyWord));
		
		
		List<WebElement> suggestionslist = driver.findElements(By.xpath("//li[@class='Y5N33s']//a[@class='_3izBDY']/div[2]"));
		
		//System.out.println(e.getText());
		Thread.sleep(5000);
		for (WebElement suggestion : suggestionslist) {
					
					System.out.print(suggestion.getText());
					
					if(suggestion.getText().contains("samsung")) {
					System.out.println(": Test Passed");
				}
				else {
					System.out.println(": Test Failed");
				}
			}
		driver.quit();	}

}






