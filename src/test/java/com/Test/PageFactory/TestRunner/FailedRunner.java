package com.Test.PageFactory.TestRunner;

import com.Test.PageFactory.utility.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue = {"com/Test/PageFactory/stepDefinitions", "com/Test/PageFactory/utility"},
        plugin = {"pretty", "html:target/cucumber-html-reports/cucumberHtmlReport.html", "com.Test.PageFactory.TestRunner.GetStepName"},
        dryRun = false
//        tags = "@New_Features"
)

public class FailedRunner {

}
