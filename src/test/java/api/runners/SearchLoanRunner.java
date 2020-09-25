package api.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/api/features/SearchLoan.feature", 
				tags = { "@Search_Loan" }, 
				glue = {"api.features.steps" }, 
				monochrome = true)

public class SearchLoanRunner {

}