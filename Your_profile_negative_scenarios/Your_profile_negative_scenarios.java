package Your_profile_negative_scenarios;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;


public class Your_profile_negative_scenarios extends Generic_functions {
	public static boolean value;
	public static String str,path;
	public static File file;

	/*Applications opens and user is on your profile page */ 	
	@When("User is on home page and clicks on your profile")
	public static void browser_launching() throws Exception{
		try {
			app_launch();
			page_wait(20);
			click("welcome_login");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",3));
			page_wait(20);
			click("login");	
			page_wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* TC_001- Validate that Send Code button is disabled when they do not check the phone number  */
	@When("User should not be able to click on Send Code")
	public static void your_profile_negative_tc_001() throws Exception{
		try {
			click("your_profile_header_menu");
			click("your_profile_header");
			click("profile_edit");
			value= driver.findElement(By.xpath(OR_reader("profile_send_code"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_001");
		}
	}

	/* TC_002- Validate that the user is not allowed to verify when 'Security code' and 'Re-enter password' fields are blank */
	@When("Validation msgs should be displayed when user leaves security code and reenter password fields blank")
	public static void your_profile_negative_tc_002() throws Exception{
		try {
			click("profile_send_code");
			click("profile_verify");
			page_wait(2);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("password_valid_msg"));
			page_wait(10);
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",0));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			page_wait(10);
//			str= driver.findElement(By.xpath(OR_reader("Object Locator", "security_code_valid_msg_two"))).getText();
//			Assert.assertEquals(str,td_reader("security_code_valid_msg_two"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_002");
		}
	}

	/* TC_003- Validate that the user should get a validation message on entering invalid 'Security code'  and 'Re-enter password' */
	@When("Validation msgs should be displayed when user enters invalid security code and  password")
	public static void your_profile_negative_tc_003() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
//			str= driver.findElement(By.xpath(OR_reader("Object Locator", "security_code_valid_msg_two"))).getText();
//			Assert.assertEquals(str,td_reader("security_code_valid_msg_two"));
//			str= driver.findElement(By.xpath(OR_reader("Object Locator", "password_valid_msg_two"))).getText();
//			Assert.assertEquals(str,td_reader("password_valid_msg_two"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_003");
		}
	}

	/* TC_004- Validate that the user is not allowed leave the 'Security code' or  'Re-enter password' field blank. */
	@When("User is not allowed to leave security code and password field blank")
	public static void your_profile_negative_tc_004() throws Exception{
		try {
			page_wait(2);
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
			page_wait(2);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			field_clear("profile_password");
			page_wait(5);
			driver.findElement(By.xpath(OR_reader( "profile_security_code"))).sendKeys(td_reader("profile_security_code",1));
			click("profile_verify");
			page_wait(2);
			str= driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("password_valid_msg"));
			field_clear("profile_security_code");
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			click("profile_ok");
			page_wait(10);
			click("profile_edit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_004");
		}
	}


	/* TC_005- Validate that the user is unable to  Edit the primary and deactivate email */
	@When("User is unable to  edit the primary and deactivate email")
	public static void your_profile_negative_tc_005() throws Exception{
		try {
			page_wait(15);
			click("profile_contact");
			page_wait(5);
			click("profile_email_id_tab");
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isEnabled();
			Assert.assertEquals(true,value);
			click("profile_go_back");
			page_wait(5);
			click("profile_edit");
			page_wait(5);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_005");
		}
	}
	/* TC_006- Validate that user gets validation message on leaving the fields blank in the Your profile Page */
	@When("Validation msgs should be displayed when user leaves firstname and lastname fields blank")
	public static void your_profile_negative_tc_006() throws Exception{
		try {
			//click("profile_edit");
			page_wait(4);
			click("profile_firstname");
			//click("profile_firstname");
			page_wait(2);
			field_clear("profile_firstname");
			click("profile_lastname");
			field_clear("profile_lastname");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg"),str);
			page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_006");
		}
	}


	/* TC_007- Validate that the user should get a validation message on entering invalid First name, Last name  or  Preferred name*/
	@When("Validation msgs should be displayed when user enters invalid firstname,lastname and preferred name")
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
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",1));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",1));
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
			page_wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("your_profile_negative_tc_007");
		}
	}

	/* TC_008- Validate that the user is unable to  Edit the User ID*/
	@When("User should not be able to edit User ID")
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
			takeScreenShot("your_profile_negative_tc_008");
		}
	}

	/* TC_009- Validate that the user is not allowed to add email id when 'Email ID' fields are blank*/
	@When("Validation msgs should be displayed when user leaves email id field blank")
	public static void your_profile_negative_tc_009() throws Exception{
		try {
			page_wait(15);
			//scrolldown("Contact details");
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

	/* TC_010- Validate that the user should get a validation message on entering invalid Email ID  or  already exist Email ID*/
	@When("Validation msgs should be displayed when user enters invalid email id")
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
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_010");
		}
	}

	/* TC_011- Validate that the user is unable to  Edit the primary and deactivate phone number*/
	@When("User is unable to Edit the primary and deactivate phone number")
	public static void your_profile_negative_tc_011() throws Exception{
		try {
			page_wait(20);
			click("your_prof_add_mail_back_arrow");
			click("profile_phone_no_tab");
			page_wait(15);
			click("p_plus");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_011");
		}
	}

	/* TC_012- Validate that the user should get a validation message on entering invalid Phone number  or  'Phone number' fields are blank*/
	@When("Validation msgs should be displayed when user enters invalid phone number")
	public static void your_profile_negative_tc_012() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_phone_edttext"))).sendKeys(td_reader("profile_phone_edttext",0));
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_phone_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_valid_msg"),str);
			page_wait(20);
			
        } catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_012");
		}
	}

	/* TC_013- Validate that the user is unable to  Edit the primary and deactivate address*/
	@When("User is unable to Edit the primary and deactivate address")
	public static void your_profile_negative_tc_013() throws Exception{
		try {
			page_wait(5);
		    click("your_prof_add_mail_back_arrow");
		    click("profile_address_tab");
		    page_wait(15);
			value= driver.findElement(By.xpath(OR_reader("profile_address_tab"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_013");
		}
	}

	/* TC_014- Validate that user gets validation message on leaving the fields blank in the Add new address Page*/
	@When("Validation msgs should be displayed when user leaves fields blank")
	public static void your_profile_negative_tc_014() throws Exception{
		try {
			page_wait(15);
			click("p_plus");
			page_wait(15);
			click("your_proff_address_save_btn");
			page_wait(20);
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
			takeScreenShot("your_profile_negative_tc_014");
		}
	}

	/* TC_015- Validate that the user should get a validation message on entering invalid Zip code in Add new address page*/
	@When("Validation msgs should be displayed when user enters invalid zip code")
	public static void your_profile_negative_tc_015() throws Exception{
		try {
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
			str= driver.findElement(By.xpath(OR_reader("profile_zip_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_invalid_msg"),str);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_015");
		}
	}

	/* TC_016- Validate that user gets validation message on leaving the fields blank in the Add plan Page*/
	@When("Validation msgs should be displayed when user leave fields blank in add plan page")
	public static void your_profile_negative_tc_016() throws Exception{
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
			str= driver.findElement(By.xpath(OR_reader("profile_insurer_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_insurer_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_memberid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_memberid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_groupid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_groupid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_plan_type_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_type_valid_msg"),str);
			page_wait(5);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}

	/* TC_017-Validate that the user should get a validation message on entering invalid First name of policy holder or Last name of policy holder  in Add plan page*/
	@When("Validation msgs should be displayed when user enters invalid firstname and lastname fields in add plan page")
	public static void your_profile_negative_tc_017() throws Exception{
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

	/* TC_018-Validate that user gets validation message on leaving the fields blank in the Change password page*/
	@When("Validation msgs should be displayed when user leave fields blank in Change password page")
	public static void your_profile_negative_tc_018() throws Exception{
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
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}

	/* TC_019-Validate that the user should get a validation message on entering wrong Old password in Change password page*/
	@When("Validation msgs should be displayed when user enter wrong passwords")
	public static void your_profile_negative_tc_019() throws Exception{
		try {
			click("profile_go_back");
			 page_wait(10);
			 scrollAndClick("Password");
			 page_wait(5);
			 click("profile_edit");
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password",0));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",0));
			click("your_proff_save_btn");
			page_wait(10);
			scrollAndClick("Save");
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_019");
		}
	}

	/* TC_020-Validate that the user should get a validation message on entering invalid New password in Change password page*/
	@When("Validation msgs should be displayed when user enter invalid new password")
	public static void your_profile_negative_tc_020() throws Exception{
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
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_020");
		}
	}

	/* TC_021-Validate that the user should get a validation message on entering same data in Old password and New password fields in Change password page*/
	@When("Validation msgs should be displayed when user enters same data in Old password and New password fields")
	public static void your_profile_negative_tc_021() throws Exception{
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
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_three"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_three"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_021");
		}
	}

	/* TC_022-Validate that the user should get a  validation message on entering different data in 'New password' and 'Confirm new password' fields */
	@When("Validation msgs should be displayed when user enters different data in New password and Confirm new password fields")
	public static void your_profile_negative_tc_022() throws Exception{
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
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg_two"),str);
			click("profile_go_back");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_022");
		}
	}

	/* TC_023-Validate that the user get a  dialogue box when fail to upload the profile picture */
	@When("User should not be able to upload profile picture")
	public static void your_profile_negative_tc_023() throws Exception{
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
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_023");
		}
	}

}
