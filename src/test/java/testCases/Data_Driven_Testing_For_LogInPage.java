package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.ExcelUtilites;

public class Data_Driven_Testing_For_LogInPage extends BaseClass {

	
	@Test(dataProvider = "LoginPage")
	public void login (String email,String Password) {
		 LoginPage l2=new LoginPage(driver);
		 l2.setEmail(email);
		 l2.setPassword(Password);
		 l2.clickLogin();
	}
	 
	
	@DataProvider(name="LoginPage")
	public Object[][] LoginData() throws IOException {
	    
		String filepath="C:\\Users\\kvsg2\\eclipse-workspace\\selenium2\\Nop-Commerce\\testdata\\TestData.xlsx";
		String sheetName="Sheet1";
		
		       int rowNum1=ExcelUtilites.getRowCount(filepath, sheetName);
		       int cellCount1 = ExcelUtilites.getCellCout(filepath, sheetName, 1);
		
		Object logindata[][]=new Object[rowNum1][cellCount1];
		
		for (int i = 1; i < rowNum1; i++) {
			
			for (int j = 0; j <cellCount1; j++) {
				logindata[i-1][j]=ExcelUtilites.getCellData(filepath, sheetName,i, j);
			}
		}
		return logindata;
	}
	
	
}
