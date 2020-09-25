package api.features.steps;

import api.apis.UpdateLoanAPI;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class UpdateLoanSteps {

	@Steps
	private UpdateLoanAPI updateLoanAPI;

	@Then("^Verify Admin is able to successfully update the loan \"(.*?)\"$")
	public void verify_Admin_sucessfully_update_Loan(int loanId) throws Throwable {
		updateLoanAPI.verifyLoanResponse(loanId);
	}

	@Then("^Admin updates loan \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\"$")
	public void verify_Admin_updates_loan(String legalDocuments, String loanType, String loanAmount, String loanTerm, String loanId)
			throws Throwable {
		updateLoanAPI.postUpdateLoan(legalDocuments, loanType, loanAmount, loanTerm, loanId);
	}
}