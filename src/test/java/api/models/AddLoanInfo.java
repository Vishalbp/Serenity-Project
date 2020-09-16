package api.models;

public class AddLoanInfo {

	public BorrowerDetails borrowerDetails;
	public LoanDetails loanDetails;

	public static class BorrowerDetails {

		public String addreesLine1, addreesLine2, borrowerName, city;

		public int zipcode;

	}

	public static class LoanDetails {

		public String legalDocuments, loanType;

		public int loanAmount, loanId, loanTerm;

	}

}
