package api.runners;

//import io.cucumber.junit.CucumberOptions;
//import cucumber.api.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/api/features/", 
				tags = { "@User1" },
				glue = {"api.features.steps" }, 
				monochrome = true)

public class LoginRunner {

}