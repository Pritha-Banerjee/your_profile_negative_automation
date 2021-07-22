package Step_Definition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Your_profile_negative_scenarios extends Generic_functions {
	public static boolean value;
	public static String str,path;
	public static File file;

	/*Validate that the user is navigated to Welcome page*/
	@Given("Launch the URL and open login page")
	public static void launch_url() throws Exception{
		try {
			app_launch();
			page_wait(20);
			click("welcome_login");
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@When("Enter login details")
	public void enter_login() throws Exception {
		driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
		driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
		page_wait(10);
		click("login");	
	}

	/*TC_001- Verify clicking on profile will navigates to Your profile screen*/
	@Then("Click on your profile")
	public static void click_profile() throws Exception{
		try {
			Thread.sleep(2000);
			page_wait(120);
			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("hamburger");
			System.out.println("1");
			click("profile");
			page_wait(30);
			stale_click("profile_edit");
			page_wait(30);
			value= driver.findElement(By.xpath(OR_reader("profile_send_code"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("your_profile_negative_tc_001");
		}	
	}

	/* TC_002- Verify the scenario when blank 'security code and Re-enter password' fields*/
	@When("Enter 'security code and Re-enter password' as blank")
	public static void your_profile_negative_tc_002() throws Exception{
		try {
			click("profile_send_code");
			click("profile_verify");
			page_wait(12);
		} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("your_profile_negative_tc_002");
		}
	}

	@Then("verify the validation messages")
	public static void validation_msg() throws Exception{
		try {
//			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("password_valid_msg"));
			page_wait(10);
		}catch(Exception e){
			e.printStackTrace();		
		}
	}

	/* TC_003- Verify the scenario when entering invalid Security code  and Re-enter password */
	@When("Enter invalid 'security code and Re-enter password'")
	public static void your_profile_negative_tc_003() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",0));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			page_wait(10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Verify the validation message for invalid data")
	public static void invalid_validation_msg() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg_two"));
		}catch(Exception e) {

		}
	}

	/* TC_004- Verify the scenario when blank 'security code or Re-enter password' fields*/
	@When("Enter 'security code or Re-enter password' as blank")
	public static void your_profile_negative_tc_004() throws Exception{
		try {
			page_wait(2);
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
			page_wait(30);
			field_clear("profile_password");
			page_wait(5);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_004");
		}
	}

	@Then("Verify the validation blank message")
	public static void blank_validation_msg() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
		}catch(Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_005- Verify the scenario when unable to  Edit the primary and deactivate email*/
	@When("Click on edit contact details")
	public void clickOnEditContactDetails() throws Exception {
		try {
			field_clear("profile_password");
			page_wait(5);
			page_wait(10);
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			click("profile_ok");
			page_wait(15);
			click("profile_contact");
			page_wait(5);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_005");
		}
	}
	@Then("Not able to edit primary and deactivate email")
	public static void your_profile_negative_tc_005() throws Exception{
		try {

			click("profile_email_id_tab");
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isEnabled();
			Assert.assertEquals(true,value);
			stale_click("profile_go_back");
			page_wait(35);
			click("profile_edit");
			page_wait(15);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_006- Verify the scenario when blank Your profile Page fields*/
	@When("Enter firstname and lastname fields as blank")
	public static void your_profile_negative_tc_006() throws Exception{
		try {
			//click("profile_edit");
			page_wait(20);
			click("profile_firstname");
			//click("profile_firstname");
			page_wait(20);
			field_clear("profile_firstname");
			click("profile_lastname");
			field_clear("profile_lastname");
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_006");
		}
	}

	@Then("Verify the validation message for blank fields")
	public static void blank_validation_msg_fields() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_007- Verify the scenario when entering invalid First name, Last name  or  Preferred name*/
	@When("Enters invalid firstname,lastname and preferred name")
	public static void your_profile_negative_tc_007() throws Exception{
		try {
			page_wait(10);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",0));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",0));
			click("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",0));
			str= driver.findElement(By.xpath(OR_reader("profile_firstname_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg_two"),str);
			page_wait(2);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader( "profile_firstname"))).sendKeys(td_reader("profile_firstname",1));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader( "profile_lastname"))).sendKeys(td_reader("profile_lastname",1));
			click("profile_preferred_name");
			field_clear("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",0));
			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg_two"),str);
			page_wait(2);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",1));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",0));
			click("profile_preferred_name");
			field_clear("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",1));
			str= driver.findElement(By.xpath(OR_reader("profile_preferred_name_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_preferred_name_valid_msg"),str);
			//scrollAndClick("Save");
			Thread.sleep(1000);	} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Then("Verify the validation for invalid first name, last name or preferred name")
	public static void invalid_message() throws Exception{
//		try {
//			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
//			Assert.assertEquals(td_reader("profile_firstname_invalid_msg"),str);
//			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg"))).getText();
//			Assert.assertEquals(td_reader("profile_lastname_invalid_msg"),str);
//			str= driver.findElement(By.xpath(OR_reader( "profile_preferred_valid_msg"))).getText();
//			Assert.assertEquals(td_reader("profile_preferred_invalid_msg"),str);
//		}catch(Exception e) {
//			e.printStackTrace();
//
//		}
	}

	/* TC_008- Verify the scenario unable to  Edit the User ID*/
	@When("Verify 'User ID' is displayed")
	public void userID_IsDisplayed() throws Exception {
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_user_id"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_008");
		}
	}
	@Then("verify 'User ID' is disabled for edit")
	public static void your_profile_negative_tc_008() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_user_id"))).isEnabled();
			Assert.assertEquals(true,value);
			click("profile_go_back");
			page_wait(15);
			click("your_profile_header_menu");
			page_wait(35);
			click("your_profile_header");
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_009- Verify the scenario when Email ID fields are blank*/
	@When("click on contact details")
	public void clickOnContactDetails() throws Exception {
		try {
			page_wait(15);
			scrollAndClick("Contact details");
			page_wait(5);
			click("profile_contact");
			page_wait(15);
			click("p_plus");
			page_wait(12);
			value= driver.findElement(By.xpath(OR_reader("profile_submit"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_009");
		}
	}
	@Then("Leave email id field as blank")
	public static void your_profile_negative_tc_009() throws Exception{
		try {
			click("profile_plus");
			value= driver.findElement(By.xpath(OR_reader("profile_add_email_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_010- Verify the scenario when entering invalid Email ID  or  already exist Email ID*/
	@When("Enter invalid email id")
	public static void your_profile_negative_tc_010() throws Exception{
		try {
			page_wait(10);
			driver.findElement(By.xpath(OR_reader("profile_email_edttext"))).sendKeys(td_reader("profile_email_edttext",0));
			click("profile_submit");
			page_wait(5);
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg"),str);
			field_clear("profile_email_edttext");
			driver.findElement(By.xpath(OR_reader("profile_email_edttext"))).sendKeys(td_reader("profile_email_edttext",1));
			click("profile_submit");
			page_wait(5);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_010");
		}
	}

	@Then("Verify the validation for invalid email id")
	public static void validation_invalid_mail() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_011- Verify the scenario when unable to  Edit the primary and deactivate phone number*/
	@When ("Click on phone number")
	public void click_phone_number() throws Exception{
		try {
			page_wait(20);
			click("your_prof_add_mail_back_arrow");
			click("profile_phone_no_tab");
			page_wait(15);
			click("p_plus");
		} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("your_profile_negative_tc_011");
		}
	}
	@Then("primary and deactivate phone number is disabled for edit")
	public static void your_profile_negative_tc_011() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader( "profile_phone_no_text"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_012- Verify the scenario when entering invalid Phone number  or  Phone number fields are blank*/
	@When("Enter invalid Phone number  or  Phone number fields")
	public static void your_profile_negative_tc_012() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_phone_edttext"))).sendKeys(td_reader("profile_phone_edttext",0));
			click("profile_submit");
			page_wait(20);
			 } catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_012");
		}
	}

	@Then("Verify the validation message for Phone number  or  Phone number fields")
	public static void invalid_validation_message() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_phone_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_013- Verify the scenario when unable to  Edit the primary and deactivate address*/
	@When("Click on Address")
	public void click_address() throws Exception{
		try {
			page_wait(5);
		    click("your_prof_add_mail_back_arrow");
		    click("profile_address_tab");
		    page_wait(15);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_013");
		}
	}
	@Then("primary and deactivate address are disbled for edit")
	public static void your_profile_negative_tc_013() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_address_tab"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_014- Verify the scenario when leaving the fields blank in the Add new address Page*/
	@When("Click on add new address '+' symbol")
	public void click_new_address() throws Exception{
		try {
			page_wait(15);
			click("p_plus");
			page_wait(15);
			click("add_save");
			page_wait(20);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_014");
		}
	}
	@Then("Leaves fields blank")
	public static void your_profile_negative_tc_014() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_saveas_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_saveas_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_address_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_address_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_city_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_city_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_state_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_state_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_zip_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_015- Verify the scenario when entering invalid Zip code in Add new address page*/
	@When("Enters invalid zip code")
	public static void invalid_zipcode() throws Exception{
		page_wait(5);
	    click("your_prof_add_mail_back_arrow");
	    page_wait(15);
		click("p_plus");
		page_wait(10);
		driver.findElement(By.xpath(OR_reader("your_prof_address_zip"))).sendKeys(td_reader("your_prof_address_zip"));
		page_wait(5);
		click("your_proff_address_save_btn");
		page_wait(10);
		scrollAndClick("Save");
		
	}
	@Then("Verify the Invalid zip code message")
	public void your_profile_negative_tc_015() throws Exception{
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_zip_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	/* TC_016- Verify the scenario when leaving the fields blank in the Add plan Page*/
	@When("click on plan coverage")
	public void click_plan_coverage() throws Exception {
		try {
			page_wait(5);
		    click("your_prof_add_mail_back_arrow");
		    page_wait(5);
		    click("profile_go_back");
		    page_wait(5);
		    click("profile_go_back");
		    page_wait(10);
		    scrollAndClick("Plan coverage");
		    page_wait(10);
		    click("p_plus");
		    scrollAndClick("Save");
		    page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}
	@Then("Enter add plan page feilds blank")
	public static void your_profile_negative_tc_016() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_insurer_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_insurer_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_memberid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_memberid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_groupid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_groupid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_plan_type_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_type_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_017-Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page*/
	@When("Enters invalid firstname and lastname fields in add plan page")
	public static void invalid_first_last_name() throws Exception{
		try {
			page_wait(5);
			click("profile_go_back");
		    page_wait(5);
		    click("p_plus");
			driver.findElement(By.xpath(OR_reader("profile_plan_firstname"))).sendKeys(td_reader("profile_plan_firstname"));
			str= driver.findElement(By.xpath(OR_reader("profile_plan_first_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_first_invalidmsg"),str);
			page_wait(10);
			click("profile_go_back");
		    page_wait(5);
		    click("p_plus");
			driver.findElement(By.xpath(OR_reader("profile_plan_lastname"))).sendKeys(td_reader("profile_plan_lastname"));
			str= driver.findElement(By.xpath(OR_reader("profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
			page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_017");
		}
	}
	@Then("Verify the error message on invalid firstname and lastname")
	public void your_profile_negative_tc_017() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_018-Verify the scenario when leaving the fields blank in the Change password page*/
	@When("Enter blank fields in Change password page")
	public static void blank_password() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			 page_wait(5);
			scrollAndClick("Save");
			page_wait(30);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}
	@Then("Verify the blank field message")
	public void your_profile_negative_tc_018() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_019-Verify the scenario when entering wrong Old password in Change password page*/
	@When("Enter wrong passwords")
	public static void wrong_password() throws Exception{

		try {
			click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password",0));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",0));
			click("your_proff_save_btn");
			page_wait(10);
			scrollAndClick("Save");
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_019");
		}
	}
	@Then("Verify wrong password message")
	public void your_profile_negative_tc_019() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/* TC_020-Verify the scenario when invalid New password in Change password page*/
	@When("Enter invalid new password")
	public static void invalid_new_password() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			page_wait(15);
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",1));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",3));
			click("profile_confirm_password");
			click("your_proff_save_btn");
			scrollAndClick("Save");
			page_wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_020");
		}
	}
	@Then("Verify invalid password message")
	public void your_profile_negative_tc_020() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

	/* TC_021-Verify the scenario when entering same data in Old password and New password fields in Change password page*/
	@When("Enter same data in Old password and New password fields")
	public static void old_new_password() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			page_wait(15);
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",2));
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password", 2));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",1));
			click("your_proff_save_btn");
			page_wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_021");
		}
	}
	@Then("verify the validation message")
	public void your_profile_negative_tc_021() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_three"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_three"),str);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/* TC_022-Verify the scenario when entering different data in New password and Confirm new password fields*/
	@When("Enter different data in New password and Confirm new password fields")
	public static void diff_password_confirm_password() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			page_wait(15);
			field_clear("profile_old_password");
			field_clear("profile_new_password");
			field_clear("profile_confirm_password");
			page_wait(15);
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",3));
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password", 3));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",2));
			page_wait(10);
			scrollAndClick("Save");
			page_wait(5);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_022");
		}
	}
	@Then("Verify the different password message")
	public void your_profile_negative_tc_022() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg_two"),str);
			click("profile_go_back");
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

	/* TC_023-Verify the scenario when a dialogue box appears dur to the failure of profile picture */
	@When("Not able to upload profile picture")
	public static void upload_profile_picture() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 click("profile_go_back");
			 page_wait(10);
			 click("your_profile_header_menu");
			 click("your_profile_header");
			 click("profile_edit");
			click("profile_picture");
			click("profile_upload_image");
			//click("profile_files");
			page_wait(10);
            close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_023");
		}	

	}

	@Then("Verify the message on unsuccessful upload")
	public void your_profile_negative_tc_023() throws Exception {
		try {
			click("profile_picture");
			click("profile_upload_image");
			//click("profile_files");
			page_wait(10);
//			file = new File(getprofilepic());
//			StringSelection ss = new StringSelection(file.getAbsolutePath());
            close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_023");
		}	
			}
}