package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/resources/features",
glue="steps",
monochrome = true,
tags= "@Valid",
plugin = {"pretty", "html:target/cucumber-report.html"}
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

}