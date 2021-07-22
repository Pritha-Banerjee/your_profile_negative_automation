package Step_Definition;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Award_points_positive_scenarios extends Generic_functions{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	/*TC_001-Validate that the user is navigated to Welcome page*/
	@Given("User is on landing page")
	public static void launch_url() throws Exception {
		app_launch();
		page_wait(20);
	}

	@When("Navigate to Welcome screen")
	public static void award_point_positive_tc_001() throws Exception {
		try {
			click("welcome_login");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",4));
			click("login");	
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_001");
		}
	}

	@Then("Click on 'Utilities'")
	public static void click_utilities() throws Exception {
		try {
			click("utilities");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_001");
		}
	}
	/*TC 002 - Validate that the user is able to navigated to Utilities screen */
	@When("Click on Award points tile")
	public void click_awardpoints() throws Exception {
	try{
		click("utilities_award_points");
	}catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("Award_point_positive_tc_002");
	}
		
	}

	@And("Validate Award points page")
	public static void Award_point_positive_tc_001() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("award_points_history_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_002");
		}
		}

	@Then("User should be able to click on Award point tile and to Award points page successfully")
	public static void Award_point_positive_tc_002()throws InterruptedException, Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "award_point_title"))).isDisplayed();
			click("awardpoints_redeem_button");
			page_wait(5);
			value = driver.findElement(By.xpath(OR_reader("redeem_award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			 
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_002");
		}
	}

	/*TC 003 - Validate that user can click the Tile "Award Points"in the Utilities dashboard*/
	@When("Click on the Redeem Points button")
	public void click_redeem_points_button() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("award_points_availableassert"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("redeem_points_giftcard");
		text = td_reader("redeem_points_giftcard");
		scrolldown(text);
	}
	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("Award_point_positive_tc_003");
	}
	}

	@Then("Validate the redeem award points page")
	public void validateTheRedeemAwardPointsPage() throws Exception {
		try {
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",2));
			
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_003");
		}
	}

	/*TC 004 - Validate that the user is able to navigate to the 'redeemed' page */
	@When("Navigate to the redeem page")
	public void navigate_redeem_page() throws Exception {
		try { 
		 value = driver.findElement(By.xpath(OR_reader("award_points_redeemassert"))).isDisplayed();
		 Assert.assertEquals(true,value);
		 scrollAndClick("Email ID"); value = driver.findElement(By.xpath(OR_reader("award_points_redeemassert"))).isDisplayed();
		 Assert.assertEquals(true,value);
		 scrollAndClick("Email ID");
	         } 
		catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("Award_point_positive_tc_004");
	}
	}
	@Then("Validate the redeem page")
	public static void Award_point_positive_tc_004() throws Exception {
		try {
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeemed_titleassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeem_pointsassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeempage_availedassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			click("award_points_goto_dashboard");
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_history_title"))).isDisplayed();
//			Assert.assertEquals(true,value);
			close();
		
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_004");
		}
	}
}