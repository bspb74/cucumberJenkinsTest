package com.Test.PageFactory.utility;

import com.Test.PageFactory.TestRunner.GetStepName;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;

public class Screenshot {

    public static Scenario scenario;

    @AfterStep
    public void embedScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) WebDriverFactory.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot: " + GetStepName.stepName);
        } catch (Exception e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
