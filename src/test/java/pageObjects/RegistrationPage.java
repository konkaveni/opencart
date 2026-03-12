package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMessage;
	
	//Action Methods
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	
	public void setTelephone(String phone) {
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		confirm.sendKeys(pwd);
	}
	public void clickPolicy() {
		policy.click();
	}

	
	public void clickContinue() {
		
		//SOL 1
		Continue.click();
		
		//SOL 2
		//Continue.submit();
		
		//SOL 3
		//Actions action= new Actions(driver);
		//action.moveToElement(Continue).click().perform();
		
		//SOl 4
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", Continue);
		
		//SOL 5
		//Continue.sendKeys(Keys.RETURN);
		
		//SOL 6
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();//
		
	}
	
	public String checkconfirmation() {
		try {
		return (confirmMessage.getText());
		
	}catch(Exception e){
		return (e.getMessage());
	}
	}

}
