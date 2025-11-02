package com.tripautomation_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
	
	
	public static WebDriver driver;
	public static Properties config;
	
	@BeforeClass
	
	public void setUp() {
		
		config=new Properties();
		try {
			String path=System.getProperty("user.dir")+File.separator+"config.properties";
			FileInputStream fis=new FileInputStream(path);
			config.load(fis);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		String browserName=config.getProperty("browser");
		String url=config.getProperty("url");
		switch(browserName) {
		case "Edge":{
			driver=new EdgeDriver();
			break;
			
		}
		case "Chrome":{

ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-blink-features=AutomationControlled");
options.addArguments("--start-maximized");
driver = new ChromeDriver(options);

			break;
			
		}

default:
                throw new RuntimeException("Invalid browser name in config.properties: " + browserName);

		
		
			
		}

driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("timeout"))));

       driver.get(url);
		
	}
	
	@AfterClass
	
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
