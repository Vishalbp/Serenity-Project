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

import api.models.LoginInfo;
//import io.restassured.response.Response;

public class LoginAPI {

	private static final Logger LOG = LoggerFactory.getLogger(LoginAPI.class);
	public static String token = null;
	public static String CONTENT_TYPE = "application/json";

	public String postLoginCall(String userid, String pwd)
			throws JsonParseException, JsonMappingException, IOException {

		LOG.info("User Logins");

		String strJsonFile = "src/test/resources/json/Login/Login.json";

		ObjectMapper mapper = new ObjectMapper();

		LoginInfo PostLogin = mapper.readValue(new File(strJsonFile), LoginInfo.class);

		PostLogin.password = pwd;
		PostLogin.username = userid;

		given().contentType(CONTENT_TYPE).header("accept", "*/*").body(mapper.writeValueAsString(PostLogin)).when()
				.post("https://loan-user-management.cfapps.io/token");

		token = then().extract().body().jsonPath().getString("token");

		return token;
	}

	public void verifyResponse(int statusCode) {

		LOG.info(then().extract().response().asString());

		assertEquals((then().extract().statusCode()), statusCode);

		if (then().extract().statusCode() == 200) {

			LOG.info("Logged in successfully");

			if (then().extract().body().jsonPath().getString("role").equals("ADMIN")) {

				assertEquals((then().extract().body().jsonPath().get("role")), "ADMIN");

				LOG.info("Admin logged in successfully");
			}

		}

		else {

			LOG.info("Login is not succussfull");

		}

	}

	public void verifyToken() {

		assertNotNull((then().extract().body().jsonPath().get("token")));

		LOG.info("Token is generated successfully");

	}

}
