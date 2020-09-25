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

import api.models.SearchLoanInfo;

import static api.apis.LoginAPI.CONTENT_TYPE;
import static api.apis.LoginAPI.token;
//import io.restassured.response.Response;

public class SearchLoanAPI {

	private static final Logger LOG = LoggerFactory.getLogger(SearchLoanAPI.class);

	public void getSearchLoan(String borrowerFirstName, String borrowerLastName, String loanId, String loanAmount)
			throws JsonParseException, JsonMappingException, IOException {

		LOG.info("Search Loan");

		String strJsonFile = "src/test/resources/json/LoanMangement/SearchLoan.json";

		ObjectMapper mapper = new ObjectMapper();

		SearchLoanInfo getLoan = mapper.readValue(new File(strJsonFile), SearchLoanInfo.class);

		getLoan.borrowerFirstName = borrowerFirstName;
		getLoan.borrowerLastName = borrowerLastName;
		getLoan.loanId = Integer.parseInt(loanId);
		getLoan.loanAmount = Integer.parseInt(loanAmount);

		given().contentType(CONTENT_TYPE).header("accept", "*/*").header("Authorization", "Discover " + token)
				.body(mapper.writeValueAsString(getLoan)).when()
				.post("https://loan-management.cfapps.io/secured/search-loan");

		// return then().extract().response();

	}

	public void verifyLoanResponse(int statusCode) {

		LOG.info(then().extract().response().asString());
		
		assertEquals((then().extract().statusCode()), statusCode);

		if (then().extract().statusCode() == 200) {

			LOG.info("User is able to search loan successfully");

//			equals(!then().extract().body().jsonPath().getString("loan_id").contains(null));
//			equals(!then().extract().body().jsonPath().getString("user_id").contains(null));
//			equals(!then().extract().body().jsonPath().getString("loan_amount").contains(null));
//			equals(!then().extract().body().jsonPath().getString("loan_term").contains(null));
//			equals(!then().extract().body().jsonPath().getString("loan_type").contains(null));
			
			assertNotNull(then().extract().body().jsonPath().get("loan_id"));
			assertNotNull(then().extract().body().jsonPath().get("user_id"));
			assertNotNull(then().extract().body().jsonPath().get("loan_amount"));
			assertNotNull(then().extract().body().jsonPath().get("loan_term"));
			assertNotNull(then().extract().body().jsonPath().get("loan_type"));
		}

		else {

			LOG.info("Search Loan is failed");

		}

	}

}
