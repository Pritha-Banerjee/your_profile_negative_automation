package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Header_positive_scenario extends Generic_functions{
	public static boolean value;

	@Given("Site is available")
	/*Browser launch*/
	public static void app_launching () throws Exception {
		try {
			app_launch();
			page_wait(20);
		} 	catch (Exception e) {
			e.printStackTrace();
		}	 
	
		}

	/*TC 001 - Validate that the  'mpowered health’ logo  should be present in the header*/
	@When("Navigated to welcome screen")
	public void welcome_screen() throws Exception {
		try{
			click("welcome_login");
		click("login_phone_number");
		driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
		driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
		page_wait(10);
		click("login");
	}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_001");
		}	 
	}
	@Then("Check the mpowered health logo in the header")
	public static void header_positive_tc_001() throws Exception {
		try {

			Thread.sleep(2000);
			page_wait(120);
			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("1");
			} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_001");
		}
		
	}
	
	/*TC 002 -Validate that the user is navigated to the help page on clicking 'Help' icon*/

	@When("Click on Help icon")
	public void click_help_icon() throws Exception {
	try {
		page_wait(20);
		click("header_faq");
		page_wait(20);
	}

	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("header_positive_tc_002");
	}
	}
	@Then("Verify navigation to the help page")
	public static void header_positive_tc_002() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_faq_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_002");
		} 
	}

	/*TC 003 -Validate that the user is navigated to the alerts page on clicking 'Your alerts' icon*/
	@When("Click on Your alerts icon")
	public void click_alerts_icon() throws Exception {
	try {
		click("hamburger");
		page_wait(20);
		click("header_alerts");
	}

	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("header_positive_tc_003");
	}
	}
	@Then("Verify navigation to the alerts page")
	public static void header_positive_tc_003() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_alerts_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_003");
		}
	}

	/*TC 004 -Validate that user is able to click on the 'Drop down' tab*/
	@When("Click on Drop down tab")
	public void click_dropDown() throws Exception {
		try{
			click("hamburger");
		page_wait(20);
		click("header_rating");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_004");
		}
		
	}
	@Then("Verify the drop down options")
	public static void header_positive_tc_004() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_rating_explore"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
			Assert.assertEquals(true,value);
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_004");
		} 
	}
	
	/*TC 005 -Validate that the user is navigated to the  profile page on clicking 'Your profile' tab*/
	@When("Click on  Your profile")
	public void click_your_profile() throws Exception {
	try {
		click("header_profile");
		page_wait(20);
	}

	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("header_positive_tc_005");
	}
		
	}
	@Then("Verify navigation to the profile page.")
	public static void header_positive_tc_005() throws Exception {
	    try {
	    	value = driver.findElement(By.xpath(OR_reader("profile_first_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_005");
		}
	}

	/*TC 006 -Validate that the user is navigated to the ratings dashboard page on clicking 'Your ratings' tab*/
	@Then("Click on  Your ratings")
	public void clickOnYourRatings() throws Exception {
     	try{
     		click("hamburger");
		page_wait(20);
		click("header_rating");
     	}

		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_006");
		}
	}
	@Then("Verify navigation to the ratings dashboard page.")
	public static void header_positive_tc_006() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_rating_explore"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_006");
		}		
	}

	/*TC 007 -Validate that the user is navigated to the 'Feedback Port'   page  on clicking 'Feedback'*/
	@When("Click on  Feedback")
	public void click_feedback() throws Exception {
		click("hamburger");
		page_wait(20);
		click("header_feedback");
		
	}
	@Then("Verify the navigation to the Feedback Port.")
	 public static void header_positive_tc_007() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_feedback_portal"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("8");
			page_back();
	     }catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("header_positive_tc_007");
			}	
		}
	
	
	/*TC 008 -Validate that the user is navigated to the Contact Us   page  on clicking Contact us */
	@When("Click on  Contact Us")
	public void click_contactUs() throws Exception {
		click("hamburger");
		page_wait(20);
		click("header_contact");
			}
	@Then("Verify the navigation to the Contact Us.")
	public static void header_positive_tc_008() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_contact_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_008");
		}	
		}  

	/*TC 009 -Validate that the user is able to see Privacy Policy dialogue box on clicking on the 'Privacy Policy' */
	@When("Click on  Privacy Policy")
	public void click_privacy_policy() throws Exception {
		click("header_privacy");
		page_wait(20);
		
	}
	@Then("Verify the dialogue box on privacy page")
	public static void header_positive_tc_009() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_privacy_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("header_privacy_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_009");
		}	
		}		 

   
	/*TC 010 - Validate that the user is able to see Terms & Conditions dialogue box on clicking on the 'Terms & Conditions' */
	@When("click on  Terms & Conditions")
	public void click_terms_conditions() throws Exception {
		click("header_terms");
		page_wait(20);
		
	}
	@Then("Verify the dialogue box on Terms and condition page")
	public static void header_positive_tc_010() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_terms_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("header_terms_ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_010");
		}	
		}   
	/*TC 011 -Validate that the user is navigated to the Landing page on clicking 'Log out' icon*/
	@When("Click on Log out icon")
	public void click_logout_icon() throws Exception {
		click("logout");
		page_wait(20);
		
	}
	@Then("Verify navigation to the Landing  page")
	public static void header_positive_tc_0011() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_tc_011");
		}	
		}
	}
	
