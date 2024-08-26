package testBase;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import utilities.ExcelUtilites;
import utilities.ConfigUtilites;
 
public class BaseClass extends ExcelUtilites{
 
   ConfigUtilites cf=new ConfigUtilites();
   
   public WebDriver driver;
  
  
    @Parameters("browser")
	@BeforeClass
	public void setUp(String bro) {
	 	
		if(bro.equals("chrome")) {
			
		driver=new ChromeDriver();	
		
		}
		else if (bro.equals("edge")) {
			
			driver=new EdgeDriver();
			
		}
		else if(bro.equals("firefox")) {
			
			driver=new FirefoxDriver();
		 
		}
	 	
		
	 	 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(cf.readApplicationUrl());
		driver.manage().deleteAllCookies();

	}
	
	@AfterClass
	public void tearDown() {
 		 
        driver.close();
	}
	
	
	// To Pass The Random Data Into Text-Box......
	public String randomString() {
		String genreateString = RandomStringUtils.randomAlphabetic(5);
		return genreateString;
	}
	
	public String randomAlphaNumeric() {
		String genreateString = RandomStringUtils.randomAlphabetic(5);
        String genreateNumber=RandomStringUtils.randomNumeric(3);
		return (genreateString+"@"+genreateNumber);
	}
	
	public String randomPhoneNum() {
		String generetNum = RandomStringUtils.randomNumeric(10);
		return generetNum;
	}
	
	// TakeScreenShot Method.....
	public void screenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	      File destination=new File("C:\\Users\\kvsg2\\eclipse-workspace\\selenium1\\Nop-Commerce2\\TakeScreenShot"+randomString()+".png");
		Files.copy(source, destination);
	}
	
	
	public String captureScreenShot(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("C:\\Users\\kvsg2\\eclipse-workspace\\selenium1\\Nop-Commerce2\\TakeScreenShot"+tname+"_"+timeStamp+".png");
	      File destination=new File(targetFilePath);
		 
	      source.renameTo(destination);
	      
	      return targetFilePath;
	}
	
 
}