package com.Test.PageFactory.TestRunner;

import com.Test.PageFactory.utility.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/Test/PageFactory/resources/features",
        glue = {"com/Test/PageFactory/stepDefinitions", "com/Test/PageFactory/utility"},
        plugin = {"pretty", "html:target/cucumber-html-reports/cucumberHtmlReport.html", "com.Test.PageFactory.TestRunner.GetStepName",
        "rerun:target/failed.txt","timeline:target"},
//        tags = "@Login",
        dryRun = false
)

public class TestRunner {

    static String browser = "chrome";
    @BeforeClass()
    public static void initializeBrowser() {
        browser = (System.getProperty("browser") == null) ? browser : System.getProperty("browser");
        System.out.println("Browser: " + browser);
        WebDriverManager.getInstance(browser);
    }

    @AfterClass
    public static void closeBrowser() {
        WebDriverManager.quitBrowser();
    }
}
