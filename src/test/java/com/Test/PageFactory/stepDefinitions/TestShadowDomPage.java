package com.Test.PageFactory.stepDefinitions;

import com.Test.PageFactory.utility.Pages;
import com.Test.PageFactory.utility.Screenshot;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestShadowDomPage implements Pages {

    @Before
    public void setupScenario(Scenario scenario) {
        Screenshot.scenario = scenario;
    }

    @Given("user at shadow dom page")
    public void user_at_shadow_dom_page() {
       wd.navigateToUrl("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");
    }
    @When("user selects encoding")
    public void user_selects_encoding() {
        sp.clickElem("Encoding");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        sp.clickElem("Encode in UTF-8");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    @And("user selects view server explorer")
    public void user_selects_view_server_explorer() {
        sp.clickElem("View");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        sp.clickElem("Server Explorer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    @And("user deselects view solution explorer")
    public void user_deselects_view_solution_explorer() {
        sp.clickElem("View");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        sp.clickElem("Solution Explorer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    @And("user deselects view server explorer")
    public void user_deselects_view_server_explorer() {
        sp.clickElem("View");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        sp.clickElem("Server Explorer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    @Then("user exits")
    public void user_exits() {
        sp.clickElem("View");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        sp.clickElem("View");
        wd.close();
    }
}
