package Step_Definition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Landing_positive_scenario extends Generic_functions{
	static boolean value;
	
	
	/*Application opens and enter URL*/
	@Given("launch")
	public void app_launching() throws Exception, InterruptedException {
		app_launch();
		page_wait(20);
			
	}
	
	/*TC_001 Verify that user is navigated to the Welcome page */
	@Then("navigated to Welcome page")
	public static void landing_welcome_positive_tc_001() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_001");
		}
	}
	
	/*TC_002 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("clicks on the 'Login' button")
	public static void click_login() throws Exception {
		try {
			page_wait(10);
			click("welcome_login");			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_002");
		}
	}
	
	@Then("navigate to Login page")
	public void landing_welcome_positive_tc_002() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_002");
		}	
	}

	/*TC_003 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page*/
	@When("clicks on  'Sign Up' button")
	public static void click_sign_up() throws Exception {
		try {
			page_wait(10);
			click("welcome_signup");
						
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_003");
		}
	}
	
	@Then("navigate to Sign up page")
	public void navigate_to_sign_up_page() throws IOException {
		try {
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("signup_page_back");	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_welcome_positive_tc_004");
		}
		page_back();
		close();
	}
		
}
