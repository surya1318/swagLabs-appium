package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {	
	
	LoginPage login = new LoginPage();
	ProductsPage pp = new ProductsPage();
	
	@When("user enters username as {string}")
	public void user_enters_username(String username) throws Exception {		
		login.enterUserName(username);	    
	}
	@When("user enters password as {string}")
	public void user_enters_password(String password) {
	    login.enterPassword(password);
	}
	@When("I click on the login button")
	public void click_on_the_login_button() {
	   login.pressLoginBtn();
	}
	@Then("Verify user should be able to land on to the {string} home page")
	public void verify_user_should_be_able_to_land_on_to_the_products_home_page(String title) {
	    Assert.assertEquals(pp.getTitle(), title);
	}	
	
	@Then("I should get error message {string}")
	public void validate_error_message(String errMsg) {
		Assert.assertEquals(login.getErrTxt(), errMsg);
	}
	

	

	


}
