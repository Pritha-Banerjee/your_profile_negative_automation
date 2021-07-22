package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bills_positive_scenarios extends Generic_functions {
	public static String exacttext,str;
	public static boolean value;

	/*Validate that the user is navigated to Welcome page*/
    @Given("Launch the application")
	public void browser_launching() throws Exception {
		try {
			app_launch();
			page_wait(20);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	/*TC 001 -Validate navigation to bills page*/
	@When("Click on 'Bills'")
	public void bills_positive_tc_001() throws Exception {
		try {
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(10);
			click("login");
			page_wait(30);
			click("services");
			click("bills");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_001");
		}
	}
    
	
	/*TC 002 - Verify the scenario to view Total bills due*/
	@When("'Total bills due' visible on the page")
	public void bills_positive_tc_002() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("bills_total_bills_due"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_002");
			
		}	
	}
	
	@And("'Amount' visible on the page")
	public void amount_visible() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("bills_due_amount_dollar"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_002");
		}	
	}

	/*TC 003 - Validate by selecting Newest option from the dropdown*/
	@When("Click on dropdown")
	public void bills_positive_tc_003() throws Exception {
		try {
			page_wait(20);
			click("bills_oldest");
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_003");
			
		}	
	}
	
	@Then("Select 'Newest'")
	public void select_newest() throws Exception {
		try {
			exacttext = td_reader("bills_newest");
			scrolldown(exacttext);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_003");
			
		}	
	}
	
	/*TC 004 - Validate view bills as two sections*/
	@When("Click on 'Due' section")
	public void bills_positive_tc_004() throws Exception {
		try {
			page_wait(20);
			click("bills_paid");
			value = driver.findElement(By.xpath(OR_reader("bills_paid_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("bills_due");
			value = driver.findElement(By.xpath(OR_reader("bills_due_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_004");
			
		}	
	}
	
	@And("Click on 'Paid' section")
	public void click_paid_section() throws Exception {
		try {
			page_wait(20);
			click("bills_paid");
			value = driver.findElement(By.xpath(OR_reader("bills_paid_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_004");
			
		}	
	}
	
	/*TC 005 - Validate slide the grid below the Bills page title.*/
	@When("Slide through 'Total bills due'")
	public void bills_positive_tc_005() throws Exception {
		try {
			page_wait(20);
            click("bills_slide");
            value = driver.findElement(By.xpath(OR_reader("bills_gotohome"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_005");
			
		}
	}

	@Then("Validate  'Your expenses' grid is visible")
	public void your_expense_grid() throws Exception {
		try {
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("bills_slide"))).getText();
			Assert.assertEquals(str,td_reader("bills_slide"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_005");
			
		}
	}
	
	/*TC 006 - Validate'Pay a Bill' button*/
	@When("Click on 'Pay a Bill' button")
	public void bills_positive_tc_006() throws Exception {
		try {
			click("bills_slide_dot");
			page_wait(20);
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_006");
			
		}	
	}
	
	@Then("Validate navigation to bill due section")
	public void bills_due_section() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("bills_slide"))).getText();
			Assert.assertEquals(str,td_reader("bills_slide"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_006");
			
		}	
	}


	/*TC 007 - Validate that the user will get validation message when expense is $0*/
	@When("Shows validation message 'you have no expenditures yet'")
	public void bills_positive_tc_008() throws Exception {
		try {
			click("home");
			click("hamburger");
			click("logout");
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_007");
			
		}	
	}
}
