package testrunners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		features="featurefiles/employeereg.feature",
		glue = "stepdefinitions",
		dryRun = false,
		plugin= {"pretty","html:test Reports/build2/empreports2.html"}
		
		)

public class EmployeeregTestcase extends AbstractTestNGCucumberTests
{
	

}
