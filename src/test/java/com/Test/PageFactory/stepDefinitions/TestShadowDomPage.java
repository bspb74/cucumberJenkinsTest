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
        sp.clickElem("aria-label", "Encoding");
        sp.clickElem("aria-label","Encode in UTF-8");
        sp.findCheckedMenuItems("aria-label", "Encoding");
    }
    @And("user selects view server explorer")
    public void user_selects_view_server_explorer() {
        sp.clickElem("aria-label","View");
        sp.clickElem("aria-label","Server Explorer");
        sp.findCheckedMenuItems("aria-label", "View");
    }
    @And("user deselects view solution explorer")
    public void user_deselects_view_solution_explorer() {
        sp.clickElem("aria-label","View");
        sp.clickElem("aria-label","Solution Explorer");
        sp.findCheckedMenuItems("aria-label", "View");
    }
    @And("user deselects view server explorer")
    public void user_deselects_view_server_explorer() {
        sp.clickElem("aria-label","View");
        sp.clickElem("aria-label","Server Explorer");
        sp.findCheckedMenuItems("aria-label", "View");
    }
    @Then("user exits")
    public void user_exits() {
        System.out.println("Test");
        sp.clickElem("aria-label","View");
    }
}
