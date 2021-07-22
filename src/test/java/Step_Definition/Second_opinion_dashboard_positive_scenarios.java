package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Second_opinion_dashboard_positive_scenarios extends Generic_functions {
	static boolean value;

	/* Browser opens and enter URL*/ 	
	@Given("browser is open")
	public void browser_open() throws Exception {
		try {
			app_launch();
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("clicks on the 'login' button")
	public void login() throws Exception {
		try {
			click("welcome_login");
			click("login_phone_number");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(10);
			click("login");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login");
		}
	}
	@And("navigated to the login page")
	public void loginpage() throws Exception {
		try {
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}  catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("loginpage");
		}
	}

	/*  TC_001-Validate that the user is able to click on the Second Opinion tab*/	
	@When("clicks on the second opinion tab")
	public void second_opinion_positive_dashboard_tc_001() throws Exception {
		try {
			page_wait(20);
			click("services");
			click("second_opinions");
					
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_001");
		}
	}

	@Then("navigated to second opinion page")
	public void second_opinion_page() throws Exception {
		try {
			page_wait(50);
			value=driver.findElement(By.xpath(OR_reader("second_opinions_title"))).isDisplayed();
			Assert.assertEquals(true,value);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_001");
		}	
	}

	/* TC_002-Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page */
	@When ("clicks on Resume Cases")
	public void second_opinion_positive_dashboard_tc_002() throws Exception, InterruptedException{
		try{
			Thread.sleep(5000);
			click("so_resume_case");
			page_wait(30);
			click("so_switch_ok_button");
			value = driver.findElement(By.xpath(OR_reader("so_resume_case_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_002");
		}
	}

	
	/* TC_003 - Validate that User is able to click on Requested tab */
	@When ("clicks on the Requested tab")
	public static void second_opinion_positive_dashboard_tc_007() throws Exception, InterruptedException
	{
		try {
			click("so_requested_tab");
				
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_003");
		}
	}
	@Then("navigated to Requested page")
	public void Requestedpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_requested_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_003");
		}
		}

	/* TC_004 - Validate that User is able to click on Reviewed tag */
	@When ("clicks on the Reviewed tab")
	public static void second_opinion_positive_dashboard_tc_008() throws Exception
	{ 
		try {
			click("so_reviewed_tab"); 
			
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_004");
		}
		}
	@Then("navigated to Reviewed  page")
	public void Reviewedpage() throws Exception {
		try {
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("so_reviewed_msg"))).isDisplayed();			
			Assert.assertEquals(true,value);
			close();		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_004");
		}
		}		
}