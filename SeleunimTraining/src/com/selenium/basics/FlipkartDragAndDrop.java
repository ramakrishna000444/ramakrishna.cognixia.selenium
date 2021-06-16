package com.selenium.basics;

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;




public class FlipkartDragAndDrop extends Base{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		  openBrowser("Chrome");
			
		  driver.get("https://www.flipkart.com");
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
		  WebElement parent= driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
		  parent.click();
		  String searchstring = "fitbit";
		  WebElement searchbox= driver.findElement(By.name("q"));
		  searchbox.sendKeys(searchstring);
		  WebElement search= driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		  search.click();
		  Actions myActions= new Actions(driver);
		  
		
		   WebElement lefthandle=driver.findElement(By.xpath("//div[@class='HQL4QS _28DFQy']"));
		   WebElement Righthandle=driver.findElement(By.xpath("//div[@class='HQL4QS WC_zGJ']"));
		   myActions.dragAndDropBy(lefthandle,67,0).build().perform();
		   Thread.sleep(1000);
		   myActions.dragAndDropBy(Righthandle,-68,0).build().perform();
			
			
	       String text = driver.findElement(By.className("_10Ermr")).getText();
	       
	       int startingindex = text.indexOf("of");
	       int endingindex = text.indexOf("results");
	       
	       String numberofitems = text.substring(startingindex+3, endingindex-1);
	       
	       Integer searchresult=Integer.parseInt(numberofitems);
	       if(searchresult>900) 
	       {
	    	   System.out.println("Total no. of results is more than 900,Total items are : "+searchresult);
	       }
	       else 
	       {
	    	   System.out.println("Total no. of results is less than 900, Total items are : "+searchresult);
	       }
	      
	        WebElement firstlink= driver.findElement(By.xpath("//a[@class='s1Q9rs']"));
			firstlink.click();
			Thread.sleep(1000);
			Set<String> handles = driver.getWindowHandles();
			System.out.println("No. of windows open: "+handles.size());
			
			Iterator<String> iter = handles.iterator();
			
			while(iter.hasNext()) 
			{
				String handle = iter.next();
				
				driver.switchTo().window(handle);
				
				if(driver.getTitle().contains("Online Shopping India")) 
				{
					break;
				}
			}
			File f;
			f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File("screenshot/product.jpg"));
			
            System.out.println("handles successful");
			WebElement finalprice= driver.findElement(By.xpath("//*[@class='_30jeq3 _16Jk6d']"));
			
			String Finalpric=finalprice.getText();
			System.out.println("Final price is : "+Finalpric);
			WebElement actualPrice= driver.findElement(By.xpath("//*[@class='_3I9_wc _2p6lqe']"));
			
			String ActualPrice=actualPrice.getText();
			System.out.println("Actual price is : "+ActualPrice);
			
		    String  Finalprice= Finalpric.replace("₹","");
			Finalprice=Finalprice.replace(",","");
			
			Float Final=Float.parseFloat(Finalprice);
			System.out.println("Final in : "+Final);
			
			ActualPrice= ActualPrice.replace("₹","");
			ActualPrice=ActualPrice.replace(",","");
			
			Float Actual=Float.parseFloat(ActualPrice);
		    System.out.println("Actual in : "+Actual);
		    
		    int discount=(int) (((Actual-Final)/Actual)*100f);
		    
		    System.out.println("Discount Percent is: "+discount+" %");
		    String s=String.valueOf(discount);  
		    

		    String percent = driver.findElement(By.xpath("//div[@class='_3Ay6Sb _31Dcoz']//span[1]")).getText();
		    percent=percent.replace(" %","");
		  
		    if(percent.contains(s))
		    {
		    	System.out.println("Discount that is written in site is correct ");
		    }
		    else 
		    {
		    	System.out.println("Discount that is written in site is not correct ");
	        }
		  
		    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww' and text()='ADD TO CART']")).click(); 
		    
		    String cartPrice = driver.findElement(By.xpath("//div[@class='Ob17DV _3X7Jj1']//span[1]")).getText();
		       
		       
		    if(Finalpric.equalsIgnoreCase(cartPrice))
		    {
		    	   System.out.println("Final price equal to cart price" );
		    }
		       
		    else
		    {
		    	   System.out.println("Final price not equal to cart price");
		    }
	
		driver.close();
		driver.quit();
			
		    
	}

	

	
}		   
     
  

	
