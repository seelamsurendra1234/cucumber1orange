package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="featurefiles/adminlogin.feature",
		glue = "stepdefinitions",
		dryRun = false
		)
public class AdminloginTest
{

}
 