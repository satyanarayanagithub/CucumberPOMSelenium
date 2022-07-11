package StepDefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.OrangeLoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrangeLoginSteps {
	
	private OrangeLoginPage OLPage = new  OrangeLoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("user is on Login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		title = OLPage.getLoginPagetitle();
		System.out.println("Login Page title is >>"+title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Expectedtitle) {
		
		Assert.assertTrue(title.contains(Expectedtitle));
	    
	}

	
	@Then("forgot password link should display")
	public void forgot_password_link_should_display() {
		
		
		Assert.assertTrue(OLPage.validateForgotPassword());
	    
	}

	@And("user entered valid Username {string}")
	public void user_entered_valid_username(String username) {
		
		OLPage.enterUsername(username);
	
	}

	@And("user entered valid password {string}")
	public void user_entered_valid_password(String password) {
		OLPage.enterPassword(password);
	  
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   OLPage.clickloginbtn();
	}


	@Then("message should contains {string}")
	public void message_should_contains(String msg) {
	  
		Assert.assertEquals(OLPage.validateLogin(), msg);
	}



}
