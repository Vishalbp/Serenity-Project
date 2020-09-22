package api.apis;

import static net.serenitybdd.rest.SerenityRest.then;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.models.AddLoanInfo;
import static api.apis.LoginAPI.CONTENT_TYPE;
import static api.apis.LoginAPI.token;
//import io.restassured.response.Response;

public class AddLoanAPI {

	private static final Logger LOG = LoggerFactory.getLogger(AddLoanAPI.class);

	public void postCreateLoan(String addressLine1, String addressLine2, String borrowerName, String city,
			String zipcode, String legalDocuments, String loanType, String loanAmount, String loanTerm)
			throws JsonParseException, JsonMappingException, IOException {

		LOG.info("Add Loan");

		String strJsonFile = "src/test/resources/json/LoanMangement/AddLoan.json";

		ObjectMapper mapper = new ObjectMapper();

		AddLoanInfo postLoan = mapper.readValue(new File(strJsonFile), AddLoanInfo.class);

		postLoan.borrowerDetails.addreesLine1 = addressLine1;
		postLoan.borrowerDetails.addreesLine2 = addressLine2;
		postLoan.borrowerDetails.borrowerName = borrowerName;
		postLoan.borrowerDetails.city = city;
		postLoan.borrowerDetails.zipcode = Integer.parseInt(zipcode);

		postLoan.loanDetails.legalDocuments = legalDocuments;
		postLoan.loanDetails.loanType = loanType;
		postLoan.loanDetails.loanAmount = Integer.parseInt(loanAmount);
		postLoan.loanDetails.loanTerm = Integer.parseInt(loanTerm);

		given().contentType(CONTENT_TYPE).header("accept", "*/*").header("Authorization", "Discover " + token)
				.body(mapper.writeValueAsString(postLoan)).when()
				.post("https://loan-management.cfapps.io/secured/add-loan");

		// return then().extract().response();

	}

	public void verifyLoanResponse(String statusCode) {

		LOG.info(then().extract().response().asString());

		if (then().extract().statusCode() == 200) {

			LOG.info("Loan is created successfully");

			equals(!then().extract().body().jsonPath().getString("loanId").contains(null));

		}

		else {

			LOG.info("Loan creation is failed");

		}

	}

}
