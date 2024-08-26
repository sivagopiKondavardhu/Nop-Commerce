package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtilites{
	
	public Properties pro1;
	public  FileInputStream file;
	
	public ConfigUtilites(){
	try {
		
		file = new FileInputStream("C:\\Users\\kvsg2\\eclipse-workspace\\selenium1\\Nop-Commerce2\\testdata\\confi.properties");
		 pro1 = new Properties();
		 pro1.load(file);
		 
	   } 
	catch (FileNotFoundException e) {
		
		e.printStackTrace();
		 
	} 
	catch (IOException e) {
		
		e.printStackTrace();
	}
}
	
	public String readApplicationUrl() {
		
		return pro1.getProperty("url");
	}
	
	public String readEmail() {
		
		return pro1.getProperty("email");
	}
	
	public String readPassWord() {
		
		return pro1.getProperty("passWord");
	}
	
}