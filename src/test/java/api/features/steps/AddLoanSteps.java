package api.features.steps;

import api.apis.AddLoanAPI;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class AddLoanSteps {

	@Steps
	private AddLoanAPI addLoanAPI;

	@Then("^Verify Admin is able to successfully create the loan \"(.*?)\"$")
	public void verify_Admin_sucessfully_Create_Loan(int statusCode) throws Throwable {
		addLoanAPI.verifyLoanResponse(statusCode);
	}

	@Then("^Admin adds new loan \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\"$")
	public void verify_Admin_Adds_new_loan(String legalDocuments, String loanType, String loanAmount, String loanTerm)
			throws Throwable {
		addLoanAPI.postCreateLoan(legalDocuments, loanType, loanAmount, loanTerm);
	}
}