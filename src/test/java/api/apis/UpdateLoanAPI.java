package api.apis;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.models.UpdateLoanInfo;

import static api.apis.LoginAPI.CONTENT_TYPE;
import static api.apis.LoginAPI.token;
//import io.restassured.response.Response;

public class UpdateLoanAPI {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateLoanAPI.class);

	public void postUpdateLoan(String legalDocuments, String loanType, String loanAmount, String loanTerm,
			String loanId) throws JsonParseException, JsonMappingException, IOException {

		LOG.info("Update Loan");

		String strJsonFile = "src/test/resources/json/LoanMangement/UpdateLoan.json";

		ObjectMapper mapper = new ObjectMapper();

		UpdateLoanInfo updateLoan = mapper.readValue(new File(strJsonFile), UpdateLoanInfo.class);

		updateLoan.legalDocuments = legalDocuments;
		updateLoan.loanType = loanType;
		updateLoan.loan_id = Integer.parseInt(loanId);
		updateLoan.loanAmount = Integer.parseInt(loanAmount);
		updateLoan.loanTerm = Integer.parseInt(loanTerm);

		given().contentType(CONTENT_TYPE).header("accept", "*/*").header("Authorization", "Discover " + token)
				.body(mapper.writeValueAsString(updateLoan)).when()
				.post("https://loan-management.cfapps.io/secured/update-loan");

		// return then().extract().response();

	}

	public void verifyLoanResponse(int loanId) {

		LOG.info(then().extract().response().asString());

		assertEquals((then().extract().statusCode()), 201);

		if (then().extract().statusCode() == 201) {

//			then().extract().body().jsonPath().getString("loanId").equals(loanId);

			assertEquals((then().extract().body().jsonPath().getInt("loanId")), loanId);

			LOG.info("Loan is updated successfully");

		}

		else {

			LOG.info("Loan updation is failed");

		}

	}

}
