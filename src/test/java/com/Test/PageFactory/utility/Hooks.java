package com.Test.PageFactory.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    static String browser = "chrome";

    @Before(order=0)
    public void setupScenario(Scenario scenario) {
        Screenshot.scenario = scenario;
    }

}
