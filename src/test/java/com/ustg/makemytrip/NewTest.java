package com.ustg.makemytrip;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

public class NewTest {
	
	 WebDriver driver;
	 String parent = "";
	 
	@BeforeClass
	  public void init() {
		  System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com ");
	  }
	  
	 
  @Test 
  public void testLogin() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  WebElement loginLink=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]"));
	  wait.until(ExpectedConditions.elementToBeClickable(loginLink));
	  loginLink.click();
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")));
	   WebElement userNameText=driver.findElement(By.id("username"));
	   WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button"));
	   userNameText.sendKeys("sonimol12345@yahoo.com");
	    continueButton.click();
	    WebElement passwordText=driver.findElement(By.id("password"));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")));
	    WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button"));
	    passwordText.sendKeys("SONya@93");
	    loginButton.click();
	   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]")));
		//driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Hotels")));
	    driver.findElement(By.linkText("Hotels")).click();
	    driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("chennai");
		driver.findElement(By.xpath("//p[contains(text(),'Chennai, Tamil Nadu, India')]")).click();
		//driver.findElement(By.id("checkin")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[1]")).click();
		//*[@id="root"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[3]
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[2]")).click();
		driver.findElement(By.id("guest")).click();
	     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[1]/div/div[2]/div/ul[1]/li[1]")).click();
	     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[2]/button[2]")).click();
		driver.findElement(By.id("hsw_search_button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Kodambakkam')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Hotel')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("htl_id_seo_201803131246392549")).click();
		 parent = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		WebElement button= driver.findElement(By.id("detpg_headerright_book_now"));
		wait.until(ExpectedConditions.elementToBeClickable(button));
		button.click();
		driver.findElement(By.id("fName")).sendKeys("soni");
		driver.findElement(By.id("lName")).sendKeys("A");
		driver.findElement(By.xpath("//div[contains(text(),'Pay Now')]")).click();
		WebElement payment = driver.findElement(By.xpath("//span[contains(text(),'Credit/Debit Cards')]"));
		wait.until(ExpectedConditions.elementToBeClickable(payment));
		payment.click();
		driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("3567232345671122");
		driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("sona");
		Select month = new Select(driver.findElement(By.id("PAYMENT_expiryMonth")));
		month.selectByValue("05");
		Select year = new Select(driver.findElement(By.id("PAYMENT_expiryYear")));
		year.selectByValue("2024");
		driver.findElement(By.name("PAYMENT_cvv")).sendKeys("600");
		driver.findElement(By.xpath("//span[contains(text(),'Make Payment ')]")).click();
		Thread.sleep(3000);
  }
 
  @AfterMethod
  public void afterMethod() throws IOException {
	  File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagePath=System.getProperty("user.dir")+"/screenshot/image.png";
		FileUtils.copyFile(screenshot, new File(imagePath));
		
  }
  @AfterClass
  public void destroy() {
	 driver.quit();
  }
  

}
