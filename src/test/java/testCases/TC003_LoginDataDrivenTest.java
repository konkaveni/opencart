package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseTest {

	@Test(dataProvider ="LoginData", dataProviderClass = DataProviders.class,groups= {"DataDriven"})
	public void verifyloginDDT(String email,String pwd,String exp ) {
		
		logger.info("****starting TC003_LoginDataDrivenTest**** ");
	
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickBtnLogin();

		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isMyAccountPageExists();
		
		/*
		   Data Valid....>> login success...>>Test pass....>>logout
		                 >> login fail....>> Test fail
		                 
		   Data Invalid...>>>login success...>> Test fail...>>logout
		                  >>> Login fail.....>> Test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetPage==true) {
				ap.clickLogout();
				Assert.assertTrue(true);
			}else {
				
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid")) 
		{
			if(targetPage==true) {
				ap.clickLogout();
				Assert.assertTrue(false);
			}else {
				
				Assert.assertTrue(true);
			}
			
		}
		
		logger.info("****finished TC003_LoginDataDrivenTest**** ");

	}

}
