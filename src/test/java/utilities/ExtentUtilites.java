package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentUtilites implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	
	public ExtentReports extent;
	
	public ExtentTest extentTest;
	
	String repName;
	
	public void onStart(ITestContext context) {
       
		      String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());//TimeStamp...
		      
		      repName = "Test-Report-"+timeStamp+".html";
		      
		  sparkReporter = new ExtentSparkReporter("C:\\Users\\kvsg2\\eclipse-workspace\\selenium1\\Nop-Commerce2\\Reports"+repName);//Specifies The Location....
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Nop-Commerce Automation Results Report");// Report Title..... 
		sparkReporter.config().setDocumentTitle("Nop-Commerce Automation Report");//`
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application","Nop-Commerce");
		extent.setSystemInfo("Browser Name","Chrome" );
		extent.setSystemInfo("Module","Admin" );
		extent.setSystemInfo( "sub-Module","Customer" );
		extent.setSystemInfo("Username",System.getProperty("user.name"));
		extent.setSystemInfo("Enviroment","QA");
		extent.setSystemInfo("OS","Windows");
	  }

	
	public void onTestStart(ITestResult result) {
	
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" started executing");
	  
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		extentTest = extent.createTest(result.getClass().getName());
		extentTest.log(Status.PASS,result.getName()+" got successfully executed");
		
	}
  
	
	public void onTestFailure(ITestResult result) {
		extentTest = extent.createTest(result.getClass().getName());
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
		
		try {
			String imgPath=new BaseClass().captureScreenShot(result.getName());
			extentTest.addScreenCaptureFromPath(imgPath);
			
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
	
	}
	
	
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
		  
	}

	
	public void onFinish(ITestContext context) {

		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\Reports"+repName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	  }
	
}
