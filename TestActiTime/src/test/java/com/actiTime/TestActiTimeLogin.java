package com.actiTime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestActiTimeLogin {
WebDriver driver;
	
	@BeforeTest
	public void setPath()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	}
	
	@BeforeMethod
    public void setUp()
    {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1/login.do;jsessionid=1l16js04ez513");
		
		
    }
	
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(5000);
		driver.findElement(By.id("loginButton")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
}
