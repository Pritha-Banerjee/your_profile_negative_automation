package Step_Definition;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_negative_scenario extends Generic_functions{
	public static String str;
	
	/*TC_001 -Verify the scenario when entered invalid firstname and lastname*/
	@Given("Launch  URL and click on signup")
	public static void signup_negative_tc_001() throws Exception  {
		try {
			app_launch();
			page_wait(40);
			click("welcome_signup");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Enter invalid 'Firstname' and 'Lastname' details")
	public static void invalid_details() throws Exception {
		try {
			click("signup_first_name");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",0));
			click("signup_last_name");
			str= driver.findElement(By.xpath(OR_reader("signup_firstname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_firstname_valid_msg"));
			click("signup_page_back");
			click("welcome_signup");
			click("signup_last_name");
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",0));
			click("signup_email_id");
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_001");
		}
	}
	
	/* To refresh the page that is currently in use */
	@Then("Verify the validation message")
	public static void signup_negative_validation_msg() throws Exception {
		try{
			page_wait(10);
		str= driver.findElement(By.xpath(OR_reader("signup_lastname_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("signup_lastname_valid_msg")); 
	}
	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("signup_negative_tc_001");
	}
}


	/* TC_002 -Verify the scenario when entered invalid 'Email ID'*/
	@When("Enter invalid 'Email ID'")
	public static void signup_negative_tc_002() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_email_id");
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",0));
			click("signup_phone_number");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("signup_emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_invalid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_002");
		}
	}

	/* TC_003 -Verify the scenario when blank 'Email ID' field*/
	@When("Enter 'Email ID' as blank")
	public static void signup_negative_tc_003() throws Exception  {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_email_id");
			click("signup_phone_number");
			page_wait(10);
			str = driver.findElement(By.xpath(OR_reader("signup_emailid_blank_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_blank_msg")); 
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_003");
		}
	}

	/* TC_004 -Verify the scenario when entering less than 10 digits in the 'Phone number' field*/
	@When("Enter phone number with less than ten digits")
	public static void signup_negative_tc_004() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			page_wait(20);
			click("signup_phone_number");
			page_wait(20);
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",0));
			click("signup_password");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_less_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_004");
		}
		}
	

	/* TC_005 -Verify the scenario when entering more than 10 digits in 'Phone number' field*/
	@When("Enter phone number with more than ten digits")
	public static void signup_negative_tc_005() throws Exception {
		try {
			click("signup_page_back");
			click("welcome_signup");
			click("signup_phone_number");
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",1));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("signup_phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_more_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_005");
		}
	}

	/* TC_006 -Verify the scenario when entering already registered phone number*/
	@When("Enter already registered phone number")
	public static void signup_negative_tc_006() throws Exception {
		try {
			click("welcome_signup");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			page_wait(10);
			click("signup_terms_and_conditions");
			page_wait(10);
			scrollAndClick("Sign Up");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("signup_exist_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_exist_no_msg"));	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_tc_006");
		}
		page_back();
		close();
		}	
}
