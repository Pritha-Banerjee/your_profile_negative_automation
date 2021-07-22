package Step_Definition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home_page_positive_scenarios extends Generic_functions{
	public static boolean value;
	public static WebElement ele;
	public static String ere;
	public static boolean value1;
	
	@Given("Welcome page is available")
	public static void browser_is_open() throws IOException {
		try {
			app_launch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("browser_is_open");
		}	
		}

	/*TC_001 -Validate that the user is navigated to Welcome page*/
	@When("Click on 'Welcome Login' button")
	public static void home_positive_tc_001() throws Exception {
	try {
		page_wait(10);
		value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("welcome_login");
	}
	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("home_positive_tc_001");
	}
	}
	@Then("Verify the Welcome page")
	public void verifyTheWelcomePage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_001");
		}
	}
	
	/*Tc_002- Validate that the user is able to Login with valid credentials*/
	@When("User enters valid phonenumber and password")
	public static void enter_login_details() throws InterruptedException, Exception {
		try {
			click("login_phone_number");
			page_wait(20);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_002");
		}
	}

	@Then("click on 'login' button")
	public static void home_positive_tc_002() throws InterruptedException, Exception {
	try {
		click("login");
		page_wait(30);
		value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
		Assert.assertEquals(true,value);
	}
	catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("home_positive_tc_002");
	}
	}

	/*Tc_003 - Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
	@When("clicks on all the grid tiles")
	public static void home_positive_tc_003() throws Exception, InterruptedException {
		try {
			click("home_first_tile");
			page_wait(50);
			value1=driver.findElement(By.xpath(OR_reader("home_dashboard_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value1);
			click("home_dashboard_back_arrow");
			click("home_second_tile");
			page_wait(50);
			value1=driver.findElement(By.xpath(OR_reader("home_dashboard_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value1);
			click("home_dashboard_back_arrow");
			click("home_third_tile");
			page_wait(50);
			value1=driver.findElement(By.xpath(OR_reader("home_dashboard_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value1);
			click("home_dashboard_back_arrow");
			}catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("home_positive_tc_003");
		}
	}
	
	/*TC_004 -Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
	@When("clicks on the 'Request for second opinion' button")
	public void home_positive_tc_004() throws InterruptedException, Exception {
		try {
			click("home_so_button");
			page_wait(50);
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_004");
		}
	}

	@Then("navigated to the Second opinion page")
	public void refer_a_friend_page() throws Exception {
		try {
			value1=driver.findElement(By.xpath(OR_reader("so_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			page_wait(10);
			click("home_dashboard_back_arrow");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_004");
		}
	}

	/*TC_005-Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
	@When("clicks on 'Refer a friend' button")
	public static void home_positive_tc_005() throws InterruptedException, Exception {
		try {
			click("home_refer_button");
			page_wait(50);
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_005");
		}				
	}
	@Then("navigated to the Refer a friend page")
	public void navigated_to_the_refer_a_friend_page() throws Exception {

		try {
			value1=driver.findElement(By.xpath(OR_reader("refer_frnd_refer_code"))).isDisplayed();
			Assert.assertEquals(true,value1);
			page_wait(10);	
			page_back();
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_tc_005");
		}		
	}
}
