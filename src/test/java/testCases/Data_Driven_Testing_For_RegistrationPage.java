package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtilites;

public class Data_Driven_Testing_For_RegistrationPage extends BaseClass {

	@Test(dataProvider ="RegsiterData" )
	
	public void RegistrationData(String firstName,String LastName,String Email,String PhoneNum ,String passWord,String conformPassWord) throws IOException {
		
		try {
		HomePage h1=new HomePage(driver);
		 h1.clickMyAcount();
		 
		 h1.clickRegister();
		 
		AccountRegistrationPage ac1=new AccountRegistrationPage(driver);
		
		ac1.setFirstName(firstName);
		
		ac1.setLastName(LastName);
		
		ac1.setEmail(Email);
	
		ac1.setPhoneNum(PhoneNum);
		
           ac1.setPassWord(passWord);
           
           ac1.conformPassWord(passWord);
           
           ac1.policyButton();
           
		ac1.continueButton();
		
		String confmsg = ac1.getConformationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		ac1.continueButton1();
		
		ac1.logOut();
		
		} catch (Exception e) {
			 screenShot(driver);
		}
		
	}
		
	
	@DataProvider(name="RegsiterData")
	public String[][] getData() throws IOException 
	{
	 String filePath="C:\\Users\\kvsg2\\eclipse-workspace\\selenium2\\Nop-Commerce\\testdata\\TestData.xlsx";
	String sheetName="TestData";
	     
	     int rownum = ExcelUtilites.getRowCount(filePath, sheetName);
	      int colucount = ExcelUtilites.getCellCout(filePath, sheetName, 1);
	      
	      String regsiterData[][]=new String[rownum][colucount];
	      
	      for (int i =1; i <rownum; i++) 
	      {
			 for (int j = 0; j <colucount; j++) {
				  regsiterData[i-1][j]=ExcelUtilites.getCellData(filePath, sheetName,i, j);
			}
		  }
	    return regsiterData ; 
	}
	
}
