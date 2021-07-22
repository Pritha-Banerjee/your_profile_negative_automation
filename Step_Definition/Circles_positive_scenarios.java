package Step_Definition;


import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Circles_positive_scenarios extends Generic_functions{
	public static boolean value;
	public static String str;

	/*TC_001-Browser launch*/
	@Given("launch the app")
	public void browserlaunching() throws IOException {
		try {
			app_launch();
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("welcome_login");
			page_wait(10);
			click("login_phone_number");
			page_wait(20);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",3));
			page_wait(10);
			click("login");
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_001");
		}
	}

	@When("Click on the Circles tab")
	public void click_circles() throws Exception {
		try {
			click("circles");
			page_wait(12);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_001");
		}
	}

	/*TC 002 - Validate that a user is taken to the Circles page when they click on the Circles tab*/
	@Then("Validate Circles page")
	public void circle_positive_tc_002() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("circles_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_002");
		}
	}

	/*TC 003 - Validate that a user is able to click on Add a Partner and options pop up*/
	@When("Click on Add a Partner")
	public void click_add_partner() throws Exception {
		try{
			page_wait(12);
		click("circles_add_partner_button");
	}catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("circle_positive_tc_003");
		}
	}

	@Then("Validate options pop up")
	public void circle_positive_tc_003() throws Exception {
		try {
			page_wait(12);
			value = driver.findElement(By.xpath(OR_reader("circles_add_patner_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_003");
		}
	}

	/*TC 004 - Validate that when a user clicks on Add a Provider option under Add a Partner drop-down, they are directed to the provider screen*/
	@When ("Click on Add a Partner link")
	public void add_partner() throws Exception {
		try{
			page_wait(20);
		click("circles_add_partner_dropdown");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_004");
	}
	}

	@Then ("Click on Select a partner")
	public void select_partner() throws Exception {
		try{
			click("circles_mymedicare_option");
		click("circles_proceed_button");
		page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_004");
		}
	}

	/*TC 005 - Validate that the user is able to click on the 'Forgot username?' link*/
	@When ("click on the Forgot username? link")
	public void forgot_username() throws Exception {
		try{
			value = driver.findElement(By.xpath(OR_reader("circles_mymedicare_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		page_wait(12);
		click("circles_forgot_username_link");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_005");
		}	
	}

	@Then("Validate forgot username")
	public void circle_positive_tc_004() throws Exception {
		try {
			page_wait(12);
			value = driver.findElement(By.xpath(OR_reader("circles_forgot_username_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_005");
		}
	}

	/*TC 006 - Validate that the user is able to click on the 'Forgot password?' link*/
	@When ("Click on the Forgot password link")
	public void forgot_password() throws Exception {
	try {
		page_wait(20);
		click("circles_forgot_password_link");
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("circle_positive_tc_006");
	}
	}

	@Then("Validate the forgot password")
	public void circle_positive_tc_005() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("circles_forgot_password_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_006");
		}
	}

	/*TC 007 - Validate that the user is able to enter  the Username and Password in the 'USERNAME' and 'PASSWORD' field*/
	@When("Enter  the Username and Password")
	public void Login() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("circles_mymedicare_username"))).sendKeys(td_reader("circles_mymedicare_username",0));
			driver.findElement(By.xpath(OR_reader("circles_mymedicare_password"))).sendKeys(td_reader("circles_mymedicare_password",0));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_007");
		}
		}


	/*TC 008 Validate that the password should be displayed on clicking the eye*/
	@When("Click on eye symbol")
	public void eye_symbol() throws Exception {
		try{
			click("circles_mymedicare_eye");
		    page_wait(20);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_008");
		}
	}

	@Then("View password on clicking the eye")
	public void circle_positive_tc_007() throws Exception {
		try {
			str =driver.findElement(By.xpath(OR_reader("circles_mymedicare_password"))).getText();
			Assert.assertEquals(str,td_reader("circles_mymedicare_password"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_008");
		}
	}

	/*TC 009 Validate that the user is able to Login with valid data*/
	@When("Enter valid username and password")
	public void username_password() throws Exception {
		try{
			click("circle_login");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_009");
	}
	}

	@Then("Validate Login with valid data")
	public void circle_positive_tc_008() throws Exception {
		try {
			page_wait(50);
			click("circles_mymedicare_login_button");
			page_wait(30);
			click("circles_mymedicare_allow_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_009");
		} 
	}

	/*TC 010 - Validate that the user can able to view 'My Medicare’ icon in the Circles page and also it should be clickable */
	@When("Navigate to Circles page")
	public void circles() throws Exception {
		try {
			page_wait(30);
			click("circles_mymedicare_button");
			click("circles_mymedicare_back_arrow");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_010");
		}
	}

	@When("My Medicare logo should be present")
	public void medicare_logo() throws Exception {
	try {
		page_wait(40);
		value = driver.findElement(By.xpath(OR_reader("circles_mymedicare_img_icon"))).isDisplayed();
		Assert.assertEquals(true,value);
	}
	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("circle_positive_tc_010");
	}
	}

	@And("Validate that its clickable")
	public void circle_positive_tc_012() throws Exception  {
		try {
			click("home");
			click("hamburger");
			click("logout");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_positive_tc_010");
		}	
		close();
	}
}
