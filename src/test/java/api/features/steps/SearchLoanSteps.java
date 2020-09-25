package api.features.steps;


import api.apis.SearchLoanAPI;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SearchLoanSteps {

	@Steps
	private SearchLoanAPI searchLoanAPI;

	@Then("^Verify user is able to successfully search the loan \"(.*?)\"$")
	public void verify_user_sucessfully_Search_Loan(int statusCode) throws Throwable {
		searchLoanAPI.verifyLoanResponse(statusCode);
	}

	@Then("^Search loan \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\"$")
	public void verify_User_Search_loan(String borrowerFirstName, String borrowerLastName, String loanId, String loanAmount)
			throws Throwable {
		searchLoanAPI.getSearchLoan(borrowerFirstName, borrowerLastName, loanId, loanAmount);
	}
}