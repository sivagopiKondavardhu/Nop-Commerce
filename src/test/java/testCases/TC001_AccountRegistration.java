package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	  
	@Test
     public void verifiy_Regerstration() throws IOException {
		 
		HomePage h1=new HomePage(driver);
		 h1.clickMyAcount();
		 
		 h1.clickRegister();
		 
		AccountRegistrationPage ac1=new AccountRegistrationPage(driver);
		
		ac1.setFirstName(randomString().toUpperCase());
		
		ac1.setLastName(randomString().toUpperCase());
		
		ac1.setEmail(randomString()+"@gmail.com");
	
		ac1.setPhoneNum(randomPhoneNum());
		
            String password = randomAlphaNumeric();
            
            ac1.setPassWord(password);
            
            ac1.conformPassWord(password);
            
            ac1.policyButton();
            
		ac1.continueButton();
		
		String confmsg = ac1.getConformationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		ac1.continueButton1();
		
		ac1.logOut();
		
		//screenShot(driver,"file1");
	}	
}