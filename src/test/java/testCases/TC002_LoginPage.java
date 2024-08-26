package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.ConfigUtilites;

public class TC002_LoginPage extends BaseClass {

	@Test
	public void login() throws InterruptedException {
     
		ConfigUtilites rf=new ConfigUtilites();
		
		HomePage h1=new HomePage(driver);
	     h1.clickMyAcount();
	     h1.clickLogin();
	
	     LoginPage l1=new LoginPage(driver);
	     
	      l1.setEmail(rf.readEmail());
	     
	      l1.setPassword(rf.readPassWord());
	      
	      
	      l1.clickLogin();
	      
	      Thread.sleep(2000);
	}
}
