package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/multiplication.feature",
		glue="stepDefination",
		monochrome=true
	)

public class runnerGoogle {

}
