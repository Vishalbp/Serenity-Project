package api.runners;

//import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			features = "src/test/resources/api/features/",
			tags =  {"@LoginFeature"} , 
			glue = {"api.features.steps" }, 
			monochrome = true)

public class LoginRunner{
		

}