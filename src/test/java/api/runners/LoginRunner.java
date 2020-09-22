package api.runners;

//import cucumber.api.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/api/features/Login.feature", 
				tags = { "@User1" },
				glue = {"api.features.steps" }, 
				monochrome = true)

public class LoginRunner {

}