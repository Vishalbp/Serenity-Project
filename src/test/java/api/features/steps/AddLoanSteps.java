package api.features.steps;

import api.apis.AddLoanAPI;
import api.apis.LoginAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AddLoanSteps {

	@Steps
	private AddLoanAPI addLoanAPI;

	@Then("^Verify Admin is able to successfully create the loan \"(.*?)\"$")
	public void verify_Admin_sucessfully_Create_Loan(String statusCode) throws Throwable {
		addLoanAPI.verifyLoanResponse(statusCode);
	}

	@Then("^Admin adds new loan \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\"$")
	public void verify_Admin_Adds_new_loan(String addressLine1, String addressLine2, String borrowerName, String city,
			String zipcode, String legalDocuments, String loanType, String loanAmount, String loanTerm)
			throws Throwable {
		addLoanAPI.postCreateLoan(addressLine1, addressLine2, borrowerName, city, zipcode, legalDocuments, loanType,
				loanAmount, loanTerm);
	}
}