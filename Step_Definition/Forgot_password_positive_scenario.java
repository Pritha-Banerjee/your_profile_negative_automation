package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forgot_password_positive_scenario extends Generic_functions{
	static boolean value;

	/* Browser  is launching , navigating to Landing Welcome Page  */
	@Given("Launch the url")
	public static void browser_open() throws Exception {
		try{		
			app_launch();
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("browser_open");
		}	 
	}
	@When("Click on Login button")
	public void clickOnLoginButton() throws Exception {
	try {
		click("welcome_login");
		page_wait(30);
		value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("clickOnLoginButton");
	}
	}

	@Then("click on Forgot Password link")
	public void click_forgotpassword() throws Exception {
		try{
			click("forgot_password_link");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_forgotpassword");
		}
		
	}

	/* TC_001 -Validate that the  user should  able to enter 10 digit number in "Phone Number" field*/
	@And("enter phone number in Phone number field")
	public static void forgot_positive_tc_001() throws Exception{
		try {
			click("forgot_phone_number");
			page_wait(6);
			driver.findElement(By.xpath(OR_reader("forgot_phone_number"))).sendKeys(td_reader("forgot_phone_number",4));
			value = driver.findElement(By.xpath(OR_reader("forgot_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_positive_tc_001");
		}
	}

	/* TC_002 -Validate that the user should able to click on the  Send Reset Link button on entering valid phone number in Phone number field*/
	@When("Send Reset Link button gets enabled")
	public void resetlink_enable() throws Exception {
		page_wait(10);
		try {
			field_clear("forgot_phone_number");
			driver.findElement(By.xpath(OR_reader("forgot_phone_number"))).sendKeys(td_reader("forgot_phone_number",0));
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_positive_tc_002");
		}
	}
	@Then("Validate on click of reset link")
	public static void forgot_positive_tc_002() throws Exception{
		try {
			page_wait(30);
			click("send_resend_link");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_positive_tc_002");
		}
	}

	/* TC_003 -Validate that the user is navigated to sign up page on clicking Sign up link*/
	@When("Click on Sign up link")
	public void click_signup() throws Exception {
		try {
			click("forgot_signup_link");
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_positive_tc_003");
		}
	}
	@Then("Verify navigation to Sign up page")
	public static void forgot_positive_tc_003() throws Exception{
		try {
			value = driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_positive_tc_003");
		}	
		driver.closeApp();
	}
}
