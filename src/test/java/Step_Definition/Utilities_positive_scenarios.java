package Step_Definition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_positive_scenarios extends Generic_functions {
	public static boolean value;
	public static String exacttext;
	
	/*Validate that the user is navigated to Welcome page*/
	@Given("user is on home page")
	public static void launch_url() throws Exception{
		try {
				app_launch();
				page_wait(20);
				System.out.println("app launched");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			}
		

	/* TC_001 -Navigate to Utilities screen*/
	@When("clicks on Utilities tab")
	public static void click_utilities() throws Exception {
		try {
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(10);
			click("login");
            click("utilities");
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	@Then("Navigate to Utilities Dashboard")
	public static void utilities_positive_tc_001() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	/* TC_002-Click options provided in left side navigator*/
	@When("Click on left side navigator options")
	public static void click_navigator_options() throws Exception {
		try {  page_wait(20);
		    click("home");
	        value = driver.findElement(By.xpath(OR_reader("home_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
          click("services");
			value = driver.findElement(By.xpath(OR_reader("services_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circles");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_002");
		}
	}
	@Then("Verify the navigator options")
	public void utilities_positive_tc_002() throws Exception {
		try{
			value = driver.findElement(By.xpath(OR_reader("utilities_walletassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_002");
		}
	}

	/* TC_003 - Verify that click on all the Tiles in the Utilities dashboard*/
	@And("Click all tiles in utilities dashboard")
	public static void utilities_positive_tc_003() throws Exception {
		try {
			 click("utilities");
			 click("utilities_wallet");
			 page_wait(20);
			 value = driver.findElement(By.xpath(OR_reader("utilities_add_payment_method"))).isDisplayed();
			 Assert.assertEquals(true,value);
			 click("utilities_back");
			 click("utilities_awardspoints");
			 page_wait(20);
			 value = driver.findElement(By.xpath(OR_reader("utilities_awardspointsassert"))).isDisplayed();
		     Assert.assertEquals(true,value);
		     click("utilities_back");
			 click("utilities_idcard");
			 page_wait(20);
			 value = driver.findElement(By.xpath(OR_reader("utilities_idcard_ok"))).isDisplayed();
			 Assert.assertEquals(true,value);
			 page_wait(20);
			 click("utilities_idcard_ok");
			 page_wait(20);
			 click("utilities_settings");
			 page_wait(20);
			 value = driver.findElement(By.xpath(OR_reader("utilities_settingsassert"))).isDisplayed();
			 Assert.assertEquals(true,value);
			 page_back();
			 click("utilities_upload");
			 page_wait(20);
		     value = driver.findElement(By.xpath(OR_reader("utilities_upload_ok"))).isDisplayed();
			 Assert.assertEquals(true,value);
			 page_wait(20);
			 click("utilities_upload_ok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_003");
		}	
	}

	/* TC_004 - Add card details  in the Wallet dashboard*/
	@When("Enter card details in wallet dashboard")
	public static void utilities_positive_tc_004() throws Exception {
		try {
//			click("utilities");
//			click("utilities_wallet");
//			page_wait(10);
//			click("utilities_add_payment_method");
//			page_wait(10);
//			click("utilities_add_debit_credit_card");
//			driver.findElement(By.xpath(OR_reader("utilities_addcardsaveas"))).sendKeys(td_reader("utilities_addcardsaveas"));
//			driver.findElement(By.xpath(OR_reader("utilities_addcardname"))).sendKeys(td_reader("utilities_addcardname"));
//			page_wait(10);
//			driver.findElement(By.xpath(OR_reader( "utilities_addcardnum"))).sendKeys(td_reader("utilities_addcardnum"));
//			driver.findElement(By.xpath(OR_reader( "utilities_addcardexpiry"))).sendKeys(td_reader("utilities_addcardexpiry"));
//			page_wait(10);
//			driver.findElement(By.xpath(OR_reader("utilities_addcardcvc"))).sendKeys(td_reader("utilities_addcardcvc"));
//			driver.findElement(By.xpath(OR_reader("utilities_addcardpost"))).sendKeys(td_reader("utilities_addcardpost"));
//			page_wait(10);
//			driver.findElement(By.xpath(OR_reader("utilities_addcardphonenumber"))).sendKeys(td_reader("utilities_addcardphonenumber"));
//			driver.findElement(By.xpath(OR_reader( "utilities_addcardaddress1"))).sendKeys(td_reader("utilities_addcardaddress1"));
//			driver.findElement(By.xpath(OR_reader("utilities_addcardaddress2"))).sendKeys(td_reader("utilities_addcardaddress2"));
//			page_wait(10);
//			click("utilities_addcardscountry");
//			exacttext = td_reader("utilities_addcardscountry");
//			scrolldown(exacttext);
//			click("utilities_addcardsstate");
//			exacttext = td_reader("utilities_addcardsstate");
//			scrolldown(exacttext);
//			page_wait(10);
//			driver.findElement(By.xpath(OR_reader("Object Locator", "utilities_addcardcity"))).sendKeys(td_reader("utilities_addcardcity"));

		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}	
	}

	@Then("Verify card details is saved")
	public static void card_details_save() throws Exception {
		try {
//			click("utilities_addcardsave");
//			waitelement("utilities_addcardok");
//			click("utilities_addcardok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}
	}


	/* TC_005 - Add bank details  in the Wallet dashboard*/
	@When("Enter bank details in wallet dashboard")
	public void bank_details() throws Exception {
		try {
//			click("utilities_add_payment_method");
//			click("utilities_addbank");
//			value = driver.findElement(By.xpath(OR_reader("utilities_addbankassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			driver.findElement(By.xpath(OR_reader("utilities_addbanksaveas"))).sendKeys(td_reader("utilities_addbanksaveas"));
//			driver.findElement(By.xpath(OR_reader("utilities_addbankname"))).sendKeys(td_reader("utilities_addbankname"));
//			page_wait(10);
//			driver.findElement(By.xpath(OR_reader("utilities_addbankrouting"))).sendKeys(td_reader("utilities_addbankrouting"));
//			click("utilities_addbankholdertype");
//			exacttext = td_reader("utilities_addbankholdertype");
//			scrolldown(exacttext);
//			driver.findElement(By.xpath(OR_reader("utilities_addbankaccountno"))).sendKeys(td_reader("utilities_addbankaccountno"));
//			page_wait(10);
//			click("utilities_addbankcheckbox");
//			browser_back();
			}catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("utilities_positive_tc_005");
		}
	}

	@Then("User should able to click on Deactivate tile")
	public static void utilities_positive_tc_005() throws Exception {
		try {
			click("utilities_back");
			click("utilities_settings");
			click("utilities_settingsdeactivate");
			value = driver.findElement(By.xpath(OR_reader("utilities_deactivateassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("utilities_deactivatecancel");
			click("home");
			click("hamburger");
			click("logout");
			System.out.println("8");
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}	
	}
}
