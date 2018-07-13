package ru.BettingSite;

import java.io.File;
//import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page implements SingUpPage{
	
	protected static WebDriver driver;
	protected String url = "";
	static int b = 0;
	
	
	public Page(WebDriver driver) {
		PageSingUp.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}	
	
	public Page open(){
		driver.get(url);
		pause(1);
		System.out.println("open page " + url);
		return this;
	}
	
	public String getXpath(String element){
		return Elements.getEntryForElementName(element).getXpath();
	}
	
	public WebElement getElement(String element){
		return driver.findElement(By.xpath(getXpath(element)));
		
	}
	
	public String getURL(){
		return url;
	}
	
	public Page and() {
		return this;
	}
	
	public Page then(){
		return this;
	}
	
	public Page pageShouldBe(PageSingUp expectedPage){
		if(driver.getCurrentUrl().equals(expectedPage.getURL())){
			System.out.println("The page " + expectedPage.getURL() + " was loaded");
			return expectedPage;
		}
		throw new RuntimeException("Cannot load page " + expectedPage.getURL());
}	
	
	protected void pause(int i) {
		try {
			Thread.sleep(1000*i);
			isExistPng();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(fileWithPath);
			
			FileUtils.copyFile(ScrFile, DestFile);
	}
	
	public static void isExistPng(){
	String  a = "D://Selenium/Screens/test.png";
	try {
		if(new File(a).exists()){
			a = String.format("D://Selenium/Screens/test%d.png",b++);
			takeSnapShot(driver,a);
		}
		else {
			takeSnapShot(driver,a);
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}	
	
	public Page clickOn(String element){
		getElement(element).click();
		pause(1);		
		System.out.println("Click on element " + element);
		return this;
		
	}


}
