package api.features.steps;

import api.apis.LoginAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

	@Steps
	private LoginAPI loginAPI;

	@Given("^A customer with \"(.*?)\" and \"(.*?)\"$")
	public void a_customer_with_and(String userid, String password) throws Throwable {
		loginAPI.postLoginCall(userid, password);
	}

	@When("^Verify the response code \"(.*?)\"$")
	public void verify_the_response_code(String statusCode) throws Throwable {
		loginAPI.verifyResponse(statusCode);

	}
	
	@Then("^Verify token is successfully created$")
	public void verify_the_token() throws Throwable {
		loginAPI.verifyToken();

	}

}