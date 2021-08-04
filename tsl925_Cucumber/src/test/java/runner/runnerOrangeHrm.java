package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/orangeHrm.feature",
		glue="stepDefinition",
		monochrome=true,
		dryRun=false,
		plugin= {
				"pretty", "html:target/htmlReport.html",
				"json:target/JsonReport/report.json"
			}
		)

public class runnerOrangeHrm {
	
}
