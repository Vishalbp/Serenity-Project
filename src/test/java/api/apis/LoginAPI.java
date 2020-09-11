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

import api.models.LoginInfo;
import io.restassured.response.Response;

public class LoginAPI {

	private static final Logger LOG = LoggerFactory.getLogger(LoginAPI.class);

	public Response postLoginCall(String userid, String pwd)
			throws JsonParseException, JsonMappingException, IOException {

		LOG.info("User Logins");

		String strJsonFile = "src/test/resources/json/Login/Login.json";

		ObjectMapper mapper = new ObjectMapper();

		LoginInfo PostLogin = mapper.readValue(new File(strJsonFile), LoginInfo.class);

		PostLogin.password = pwd;
		PostLogin.userid = userid;

		given().header("", "").body(mapper.writeValueAsString(PostLogin)).when().post("");

		return then().extract().response();

	}

	public void verifyResponse(String statusCode) {

		LOG.info(then().extract().response().asString());

		if (then().extract().statusCode() == 200) {

			LOG.info("Logged in successfully");

		}

		else if (then().extract().statusCode() == 422) {

			LOG.info("Log in failed");

		}

		else {

			LOG.info("Status code not recognized");

		}

	}

}
