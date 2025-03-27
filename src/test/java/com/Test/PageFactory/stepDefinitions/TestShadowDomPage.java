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
       bp.navigateToUrl("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");
    }
    @When("user selects encoding")
    public void user_selects_encoding() {
        shadowPage.clickElem("aria-label", "Encoding");
        shadowPage.clickElem("aria-label","Encode in UTF-8");
        shadowPage.findCheckedMenuItems("aria-label", "Encoding");
    }
    @And("user selects view server explorer")
    public void user_selects_view_server_explorer() {
        shadowPage.clickElem("aria-label","View");
        shadowPage.clickElem("aria-label","Server Explorer");
        shadowPage.findCheckedMenuItems("aria-label", "View");
    }
    @And("user deselects view solution explorer")
    public void user_deselects_view_solution_explorer() {
        shadowPage.clickElem("aria-label","View");
        shadowPage.clickElem("aria-label","Solution Explorer");
        shadowPage.findCheckedMenuItems("aria-label", "View");
    }
    @And("user deselects view server explorer")
    public void user_deselects_view_server_explorer() {
        shadowPage.clickElem("aria-label","View");
        shadowPage.clickElem("aria-label","Server Explorer");
        shadowPage.findCheckedMenuItems("aria-label", "View");
    }
    @Then("user exits")
    public void user_exits() {
        System.out.println("Test");
        shadowPage.clickElem("aria-label","View");
    }
}
