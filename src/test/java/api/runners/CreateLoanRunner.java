package api.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

//import cucumber.api.junit.Cucumber;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/api/features/AddLoan.feature", 
				tags = { "@Create_Loan" }, 
				glue = {"api.features.steps" }, 
				monochrome = true)

public class CreateLoanRunner {

}