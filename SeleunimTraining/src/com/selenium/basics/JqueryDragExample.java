package com.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

	public class JqueryDragExample  extends Base{
	public static void main(String[] args) {
		
	openBrowser("chrome");
	driver.get("https://jqueryui.com/slider/");
	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS, null)

	driver.switchTo().frame(0);
	
	WebElement silder =driver.findElement(By.id("slider"));
	
	
	int maxXoffset=slider.getsize().width;
	
	
	System.out.println(maxXoffset);
	
	
	
	WebElement myAction=driver.findElement(By.id("//div[@class='slider']"));
	Actions myActions = new Actions(driver);
	myActions.dragAndDropBy(slider, 50, 0).build().perform();
   



}}
