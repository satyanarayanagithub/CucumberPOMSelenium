package com.test.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"StepDefinitions","ApplicationHooks"},
		monochrome= true,
		plugin = {"pretty"}
		)
public class OrangeTestRunner {

}
