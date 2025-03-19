package com.Test.PageFactory.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/Test/PageFactory/resources/features",
        glue = {"com/Test/PageFactory/stepDefinitions", "com/Test/PageFactory/utility"},
        plugin = {"pretty", "html:target/cucumber-html-reports/cucumberHtmlReport.html", "com.Test.PageFactory.TestRunner.GetStepName"},
        dryRun = false
//        tags = "not @Login"
)

public class TestRunner {

}
