package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhoneNum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement polyButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement masgconfirmation;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement btncontinue1;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOutButton;
	
	
	
	public void setFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNum(String phoneNum) {
		txtPhoneNum.sendKeys(phoneNum);
	}
	
	
	public void setPassWord(String password) {
		txtPassword.sendKeys(password); 
	}

	public void conformPassWord(String conformPassword) {
		confPassword.sendKeys(conformPassword);
	}
	
	public void policyButton() {
		polyButton.click();
	}
	
	public void continueButton() {
		btncontinue.click();
	}
	
	public String getConformationMsg() {
		try {
		return masgconfirmation.getText();
		}
		catch (Exception e) {
		return (e.getMessage());
		}
	}
	
	public void continueButton1() {
		btncontinue1.click();
	}
	
	public void logOut() {
		logOutButton.click();
	}
}
