package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		 PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login']") WebElement btnLogin;


       public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}


       public void setPassword(String password) {
   		txtEmail.sendKeys(password);
   	}
       
       public void clickLogin() {
		btnLogin.click();
	}
}